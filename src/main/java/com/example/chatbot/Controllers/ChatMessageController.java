package com.example.chatbot.Controllers;

import com.example.chatbot.Models.Message;
import com.example.chatbot.french.*;
import com.example.chatbot.services.Lemmatizing;
import com.example.chatbot.services.POSTagging;
import com.example.chatbot.services.Questionanswer;
import com.example.chatbot.services.Tokenizing;
import opennlp.tools.doccat.DoccatModel;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static com.example.chatbot.french.Frcategorizer.detectFrCategory;
import static com.example.chatbot.french.Frcategorizer.trainFrCategorizerModel;
import static com.example.chatbot.services.Categorizing.detectCategory;
import static com.example.chatbot.services.Categorizing.trainCategorizerModel;

@RestController
public class ChatMessageController {

    @CrossOrigin
    @PostMapping("/francais")
    public String answerfrench(@RequestBody Message message){
        DoccatModel model = null;
        try {
            model = trainFrCategorizerModel();
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
                try {
                    token = Tokenizerfr.tokenizer(phrase);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String[] tags = new String[0];
                try {
                    tags = FrPosTagging.posTagger(token);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String[] lemmas = Frlemmatizing.lemmatizing(token,tags);

                String category = null;
                try {
                    category = detectFrCategory(model, lemmas);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                answer = answer + " " + Reponse.questionAnswer.get(category);
            }
            return answer;
    }

    @CrossOrigin
    @PostMapping("/anglais")
    public String answerenglish(@RequestBody Message message){
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
