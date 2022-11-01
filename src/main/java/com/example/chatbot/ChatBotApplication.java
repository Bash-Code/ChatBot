package com.example.chatbot;

import com.example.chatbot.french.*;
import com.example.chatbot.services.*;
import opennlp.tools.doccat.DoccatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

import static com.example.chatbot.french.Frcategorizer.detectFrCategory;
import static com.example.chatbot.french.Frcategorizer.trainFrCategorizerModel;
import static com.example.chatbot.services.Categorizing.detectCategory;
import static com.example.chatbot.services.Categorizing.trainCategorizerModel;

@SpringBootApplication
public class ChatBotApplication {

    public static void main(String[] args){
        SpringApplication.run(ChatBotApplication.class, args);
    }
}
