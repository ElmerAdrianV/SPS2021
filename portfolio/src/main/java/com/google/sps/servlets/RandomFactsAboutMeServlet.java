package com.google.sps.servlets;

import com.google.sps.data.FactAboutMe;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/randomFactsAboutMe")
public class RandomFactsAboutMeServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Create a ArrayList that will contains FactsAboutMe
    ArrayList<FactAboutMe> factsAboutMe = new ArrayList<>();
    
    // Add FactsAboutMe;
    factsAboutMe.add( new FactAboutMe("images/logof1.png", "I'm a F1 fans since 2020"));
    
    //Select randomly a fact in the arrayList
    int index = Math.round( (float) Math.random()*factsAboutMe.size() );
    FactAboutMe fact = factsAboutMe.get(index);
    String json = convertToJson( fact );

    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

  private String convertToJson(FactAboutMe fact) {
    StringBuilder json = new StringBuilder();
    
    json.append("{");
    json.append("\"pathImage\": ");
    json.append("\"" + fact.getPathImage() + "\"");
    json.append(",");
    json.append("\"fact\": ");
    json.append("\"" + fact.getFact() + "\"");
    json.append("}");

    return json.toString();
  }
}