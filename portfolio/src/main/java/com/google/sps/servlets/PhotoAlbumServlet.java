package com.google.sps.servlets;

import com.google.sps.data.Photo;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/** Handles requests sent to the /photoAlbum URL. */
@WebServlet("/photoAlbum")
public class PhotoAlbumServlet extends HttpServlet {

    private static int index = 0;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Create a ArrayList that will contains FactsAboutMe
        ArrayList<Photo> photoAlbumEN = getPhotoAlbumEN();
        ArrayList<Photo> photoAlbumES = getPhotoAlbumES();
        

        // Select randomly a fact in the arrayList
        String json = convertToJson(photoAlbumEN, photoAlbumES);

        response.setContentType("application/json;");
        response.getWriter().println(json);
    }

    // Add FactsAboutMeES in Englishsh in a ArrayList;
    private ArrayList<Photo> getPhotoAlbumEN() {
        ArrayList<Photo> photoAlbumEN = new ArrayList<>();

        photoAlbumEN.add(new Photo("images/logof1.png", "F1 logo", "I'm a F1 fan since 2020"));
        photoAlbumEN.add(new Photo("images/18number.png", "18 Number", "I'm 18 years old"));
        photoAlbumEN.add(new Photo("images/birthdayCake.png", "Birthday cake", "My birthday is August 7th"));
        photoAlbumEN.add(new Photo("images/ninaGP.jpeg", "Guinea pig", "I have guinea pig of pet called Nina"));
        photoAlbumEN.add(new Photo("images/footballer.png", "footballer",
                "My frustrated dream is to be a footballer (soccer)"));
        photoAlbumEN.add(new Photo("images/elmer-elephant.jpg", "Elmer elephant",
                "An elephant, famous latin singer, Looney Toon and me are call Elmer"));
        photoAlbumEN.add(new Photo("images/brokenBone.png", "Broken bone", "I have never broken a bone"));
        photoAlbumEN.add(new Photo("images/teacher.png", "Teacher Icon",
                "As a child he hates teaching, now I love being a teacher."));

        return photoAlbumEN;
    }

    // Add FactsAboutMeES in spanish in a ArrayList;
    private ArrayList<Photo> getPhotoAlbumES() {
        ArrayList<Photo> photoAlbumES = new ArrayList<>();

        photoAlbumES.add(new Photo("images/logof1.png", "Logo F1", "Desde 2020, soy fan de la Formula 1"));
        photoAlbumES.add(new Photo("images/18number.png", "Número 18", "Tengo 18 años de edad"));
        photoAlbumES.add(
                new Photo("images/birthdayCake.png", "Pastel de cumpleaños", "Mi cumpleaños es el 7 de Agosto"));
        photoAlbumES.add(new Photo("images/ninaGP.jpeg", "Cuyo", "Mi mascota es un cuyo llamdo Nina"));
        photoAlbumES
                .add(new Photo("images/footballer.png", "Futbolista", "Mi sueño frustado es ser futbolista"));
        photoAlbumES.add(new Photo("images/elmer-elephant.jpg", "Elmer el elefante",
                "Un elefante, un famoso cantante latino, una caricatura de Looney Toons y yo nos llamamos Elmer"));
        photoAlbumES.add(new Photo("images/brokenBone.png", "Hueso Roto", "Nunca me he roto un hueso"));
        photoAlbumES.add(new Photo("images/teacher.png", "Icono de profesor",
                "De niño nunca quise enseñar. Ahora, adoro dar clases."));

        return photoAlbumES;
    }

    private String convertToJson(ArrayList<Photo> photoAlbumEN, ArrayList<Photo> photoAlbumES) {
        StringBuilder json = new StringBuilder();

        json.append("{");

        json.append("\"length\" : " + photoAlbumEN.size() + ",");

        json.append("\"photosInEN\" : ");
        json.append("[");
        for (Photo photo : photoAlbumEN) {
            json.append("{");
            json.append("\"pathImage\" : ");
            json.append("\"" + photo.getPathImage() + "\"");
            json.append(",");
            json.append("\"altAttribute\" : ");
            json.append("\"" + photo.getAltAttribute() + "\"");
            json.append(",");
            json.append("\"captionText\" : ");
            json.append("\"" + photo.getCaption() + "\"");
            json.append("},");
        }

        // Delete the last unnecessary comma
        json.deleteCharAt(json.length() - 1);

        json.append("],");

        json.append("\"photosInES\" : ");
        json.append("[");
        for (Photo photo : photoAlbumES) {
            json.append("{");
            json.append("\"pathImage\" : ");
            json.append("\"" + photo.getPathImage() + "\"");
            json.append(",");
            json.append("\"altAttribute\": ");
            json.append("\"" + photo.getAltAttribute() + "\"");
            json.append(",");
            json.append("\"captionText\": ");
            json.append("\"" + photo.getCaption() + "\"");
            json.append("},");
        }
        // Delete the last unnecessary comma
        json.deleteCharAt(json.length() - 1);

        json.append("]");
        json.append("}");

        return json.toString();
    }
}