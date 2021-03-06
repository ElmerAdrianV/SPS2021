package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/** Servlet responsible for save new messages. */
@WebServlet("/new-message")
public class NewMessageServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Sanitize user input to remove HTML tags and JavaScript.
        String nameValue    = Jsoup.clean(request.getParameter("name-input"), Whitelist.none());
        String emailValue   = Jsoup.clean(request.getParameter("email-input"), Whitelist.none());
        String topicValue   = Jsoup.clean(request.getParameter("topic-input"), Whitelist.none());
        String messageValue = Jsoup.clean(request.getParameter("message-input"), Whitelist.none());
        
        //Start the dataStore
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("Message");

        if (!nameValue.isEmpty() && !emailValue.isEmpty() && !topicValue.isEmpty() && !messageValue.isEmpty() ) {
            // Print the value so you can see it in the server logs.
            System.out.println("You submitted: ");
            System.out.println("NAME: " + nameValue);
            System.out.println("EMAIL: " + emailValue);
            System.out.println("TOPIC: " + topicValue);
            System.out.println("MESSAGE: " + messageValue);

            // Write the value to the response so the user can see it.
            response.setContentType("text/html;");
            response.getWriter().println("You submitted: ");
            response.getWriter().println("NAME: " + nameValue);
            response.getWriter().println("EMAIL: " + emailValue);
            response.getWriter().println("TOPIC: " + topicValue);
            response.getWriter().println("MESSAGE: " + messageValue);            
            
            FullEntity messageEntity =
                Entity.newBuilder(keyFactory.newKey())
                    .set("name", nameValue)
                    .set("topic", topicValue)
                    .set("email", emailValue)
                    .set("message", messageValue)
                    .build();
            
            datastore.put(messageEntity);
        }

  }
}