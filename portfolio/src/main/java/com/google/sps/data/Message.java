/** Class containing format of message send in my page. */
package com.google.sps.data;

public final class Message{
    private final String name;
    private final String email; 
    private final String topic; 
    private final String message;

    public Message(String name, String email, String topic, String message){
        this.name = name;
        this.email = email;
        this.topic = topic;
        this.message = message;
    }

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getTopic(){
        return topic;
    }
    public String getMessage(){
        return message;
    }
    
}