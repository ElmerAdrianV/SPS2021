package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/message-form-handler")
public class MessageFormServlet extends HttpServlet {

    @Override
    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException {

        // Get the value entered in the form.
        final String nameValue = request.getParameter("name-input");
        final String emailValue = request.getParameter("email-input");
        final String topicValue = request.getParameter("topic-input");
        final String messageValue = request.getParameter("message-input");

        if (nameValue != null && emailValue != null && topicValue != null && messageValue != null) {
            // Print the value so you can see it in the server logs.
            System.out.println("You submitted: ");
            System.out.println("NAME: " + nameValue);
            System.out.println("EMAIL: " + emailValue);
            System.out.println("TOPIC: " + topicValue);
            System.out.println("MESSAGE: " + messageValue);

            // Write the value to the response so the user can see it.
            response.getWriter().println("You submitted: ");
            response.getWriter().println("NAME: " + nameValue);
            response.getWriter().println("EMAIL: " + emailValue);
            response.getWriter().println("TOPIC: " + topicValue);
            response.getWriter().println("MESSAGE: " + messageValue);
        }
    }
}