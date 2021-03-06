package com.google.sps.servlets;

import com.google.sps.data.FactAboutMe;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/** Handles requests sent to the /randomFactAboutMe URL. */
@WebServlet("/randomFactsAboutMe")
public class RandomFactsAboutMeServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Create a ArrayList that will contains FactsAboutMe
    ArrayList<FactAboutMe> factsAboutMeEN = getFactsAboutMeEN();
    ArrayList<FactAboutMe> factsAboutMeES = getFactsAboutMeES();
    
    //Select randomly a fact in the arrayList
    String json = convertToJson( factsAboutMeEN, factsAboutMeES );

    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

  // Add FactsAboutMeES in Englishsh in a ArrayList;
  private ArrayList<FactAboutMe> getFactsAboutMeEN(){
    ArrayList<FactAboutMe> factsAboutMeEN = new ArrayList<>();
    
    factsAboutMeEN.add( new FactAboutMe("images/logof1.png", "F1 logo","I'm a F1 fan since 2020"));
    factsAboutMeEN.add( new FactAboutMe("images/18number.png", "18 Number","I'm 18 years old"));
    factsAboutMeEN.add( new FactAboutMe("images/birthdayCake.png", "Birthday cake","My birthday is August 7th"));
    factsAboutMeEN.add( new FactAboutMe("images/ninaGP.jpeg", "Guinea pig","I have guinea pig of pet called Nina"));
    factsAboutMeEN.add( new FactAboutMe("images/footballer.png", "footballer", "My frustrated dream is to be a footballer (soccer)"));
    factsAboutMeEN.add( new FactAboutMe("images/elmer-elephant.jpg", "Elmer elephant", "An elephant, famous latin singer, Looney Toon and me are call Elmer"));
    factsAboutMeEN.add( new FactAboutMe("images/brokenBone.png", "Broken bone", "I have never broken a bone"));
    factsAboutMeEN.add( new FactAboutMe("images/teacher.png", "Teacher Icon","As a child he hates teaching, now I love being a teacher."));

    return factsAboutMeEN;
  }

  // Add FactsAboutMeES in spanish in a ArrayList;
  private ArrayList<FactAboutMe> getFactsAboutMeES(){
    ArrayList<FactAboutMe> factsAboutMeES = new ArrayList<>();
    
    factsAboutMeES.add( new FactAboutMe("images/logof1.png", "Logo F1","Desde 2020, soy fan de la Formula 1"));
    factsAboutMeES.add( new FactAboutMe("images/18number.png", "N??mero 18","Tengo 18 a??os de edad"));
    factsAboutMeES.add( new FactAboutMe("images/birthdayCake.png", "Pastel de cumplea??os","Mi cumplea??os es el 7 de Agosto"));
    factsAboutMeES.add( new FactAboutMe("images/ninaGP.jpeg", "Cuyo","Mi mascota es un cuyo llamdo Nina"));
    factsAboutMeES.add( new FactAboutMe("images/footballer.png", "Futbolista", "Mi sue??o frustado es ser futbolista"));
    factsAboutMeES.add( new FactAboutMe("images/elmer-elephant.jpg", "Elmer el elefante", "Un elefante, un famoso cantante latino, una caricatura de Looney Toons y yo nos llamamos Elmer"));
    factsAboutMeES.add( new FactAboutMe("images/brokenBone.png", "Hueso Roto", "Nunca me he roto un hueso"));
    factsAboutMeES.add( new FactAboutMe("images/teacher.png", "Icono de profesor","De ni??o nunca quise ense??ar. Ahora, adoro dar clases."));
    
    return factsAboutMeES;
  }

  private String convertToJson(ArrayList<FactAboutMe> factsAboutMeEN, ArrayList<FactAboutMe> factsAboutMeES ) {
    StringBuilder json = new StringBuilder();
    
    json.append("{");
    
    json.append("\"length\" : "+factsAboutMeEN.size()+",");

    json.append("\"factsInEN\" : ");
    json.append("[");
    for(FactAboutMe fact : factsAboutMeEN){
        json.append("{");
        json.append("\"pathImage\" : ");
        json.append("\"" + fact.getPathImage() + "\"");
        json.append(",");
        json.append("\"altAttribute\" : ");
        json.append("\"" + fact.getAltAttribute() + "\"");
        json.append(",");
        json.append("\"factText\" : ");
        json.append("\"" + fact.getFact() + "\"");
        json.append("},");
    }
    
    //Delete the last unnecessary comma
    json.deleteCharAt(json.length()-1);

    json.append("],");
    
    json.append("\"factsInES\" : ");
    json.append("[");
    for(FactAboutMe fact : factsAboutMeES){
        json.append("{");
        json.append("\"pathImage\" : ");
        json.append("\"" + fact.getPathImage() + "\"");
        json.append(",");
        json.append("\"altAttribute\": ");
        json.append("\"" + fact.getAltAttribute() + "\"");
        json.append(",");
        json.append("\"factText\": ");
        json.append("\"" + fact.getFact() + "\"");
        json.append("},");
    }
    //Delete the last unnecessary comma
    json.deleteCharAt(json.length()-1);
    
    json.append("]");
    json.append("}");
    
    return json.toString();
  }
}