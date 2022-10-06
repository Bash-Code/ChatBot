package com.example.chatbot;

import com.example.chatbot.Models.DetecteurPhrase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ChatBotApplication {

    public static void main(String[] args) throws IOException {
        DetecteurPhrase.entrainerDetecteurPhrase("hey, i'm oualid, i have a question, please Hey there?");
        SpringApplication.run(ChatBotApplication.class, args);

    }
}
