package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/message-form-handler")
public class MessageFormServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String nameValue = request.getParameter("name-input");
    String emailValue = request.getParameter("email-input");
    String topicValue = request.getParameter("topic-input");
    String messageValue = request.getParameter("message-input");

    // Print the value so you can see it in the server logs.
    System.out.println("You submitted: ");
    System.out.println("NAME: "+nameValue);
    System.out.println("EMAIL: "+emailValue);
    System.out.println("TOPIC: "+topicValue);
    System.out.println("MESSAGE: "+messageValue);

    // Write the value to the response so the user can see it.
    response.getWriter().println("You submitted: ");
    response.getWriter().println("NAME: "+nameValue);
    response.getWriter().println("EMAIL: "+emailValue);
    response.getWriter().println("TOPIC: "+topicValue);
    response.getWriter().println("MESSAGE: "+messageValue);
    
    System.out.println(request.getParameter("value"));
    
    
  }
}