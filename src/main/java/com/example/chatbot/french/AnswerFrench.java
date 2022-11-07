package com.example.chatbot.french;

import com.example.chatbot.Models.Message;
import opennlp.tools.doccat.DoccatModel;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

import static com.example.chatbot.french.Frcategorizer.detectFrCategory;
import static com.example.chatbot.french.Frcategorizer.trainFrCategorizerModel;

public class AnswerFrench {
    public static String answerfrench(Message message){
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
}
