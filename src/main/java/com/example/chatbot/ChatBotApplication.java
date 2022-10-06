package com.example.chatbot;

import com.example.chatbot.Models.DetecteurPhrase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ChatBotApplication {

    public static void main(String[] args) throws IOException {
        DetecteurPhrase.entrainerDetecteurPhrase("Hello my name is Bachar. I need directions to the nearest agency. Thank you very much.");
        SpringApplication.run(ChatBotApplication.class, args);

    }
}
