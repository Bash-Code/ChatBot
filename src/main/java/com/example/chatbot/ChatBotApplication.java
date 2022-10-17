package com.example.chatbot;

import com.example.chatbot.services.*;
import opennlp.tools.doccat.DoccatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

import static com.example.chatbot.services.Categorizing.detectCategory;
import static com.example.chatbot.services.Categorizing.trainCategorizerModel;

@SpringBootApplication
public class ChatBotApplication {

    public static void main(String[] args) throws IOException {
        DoccatModel model = trainCategorizerModel();


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("speak to chatbot:");
            String userInput = scanner.nextLine();
            String[] phrases = DetecteurPhrase.entrainerDetecteurPhrase(userInput);
            String answer = "";
            boolean conversationComplete = false;
            for (String phrase : phrases){
                String[] token = Tokenizing.tokenizer(phrase);
                String[] tags = POSTagging.posTagging(token);
                String[] lemmas = Lemmatizing.lemmatizing(token,tags);

                String category = detectCategory(model, lemmas);


                answer = answer + " " + Questionanswer.questionAnswer.get(category);


                if ("conversation-complete".equals(category)) {
                    conversationComplete = true;
                }
            }
            System.out.println("##### Chat Bot: " + answer);
            if (conversationComplete) {
                break;
            }
        }


        SpringApplication.run(ChatBotApplication.class, args);

    }
}
