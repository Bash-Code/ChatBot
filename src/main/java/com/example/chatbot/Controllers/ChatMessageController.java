package com.example.chatbot.Controllers;

import com.example.chatbot.Langdetect.LanguageDetector;
import com.example.chatbot.Models.Message;
import com.example.chatbot.french.*;
import com.example.chatbot.services.*;
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
    @PostMapping("/chatbot")
    public String detectLanguage(@RequestBody Message message) throws IOException {
        String language = LanguageDetector.languageDetector(message.getContent());
        if (language.equals("French")){
            return AnswerFrench.answerfrench(message);
        }else if (language.equals("English")){
            return AnswerEnglish.answerenglish(message);
        }else{
            return "I don't understand this language";
        }
    }





}
