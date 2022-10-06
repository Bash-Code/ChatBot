package com.example.chatbot;

import org.springframework.data.mongodb.core.mapping.Document;




public class Chat {

    private String message;
    private String reponse;

    public Chat(String message, String reponse) {
        this.message = message;
        this.reponse = reponse;
    }
    
}
