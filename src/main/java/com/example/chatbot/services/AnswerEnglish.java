package com.example.chatbot.services;

import com.example.chatbot.Models.Message;
import com.example.chatbot.french.DetecterPhrases;
import opennlp.tools.doccat.DoccatModel;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

import static com.example.chatbot.services.Categorizing.detectCategory;
import static com.example.chatbot.services.Categorizing.trainCategorizerModel;

public class AnswerEnglish {
    public static String answerenglish(Message message){
        DoccatModel model = null;
        try {
            model = trainCategorizerModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] phrases = new String[0];
        try {
            phrases = DetecterPhrases.detecteurPhrase(message.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String answer = "";

        for (String phrase : phrases){
            String[] token = new String[0];
            token = Tokenizing.tokenizer(phrase);
            String[] tags = new String[0];
            try {
                tags = POSTagging.posTagging(token);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] lemmas = Lemmatizing.lemmatizing(token,tags);

            String category = null;
            try {
                category = detectCategory(model, lemmas);
            } catch (IOException e) {
                e.printStackTrace();
            }


            answer = answer + " " + Questionanswer.questionAnswer.get(category);
        }
        return answer;
    }
}
