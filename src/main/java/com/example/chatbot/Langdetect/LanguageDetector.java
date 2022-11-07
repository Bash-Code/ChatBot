package com.example.chatbot.Langdetect;

import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;

import java.io.File;
import java.io.IOException;

public class LanguageDetector {
    public static String languageDetector(String sentence) throws IOException {

        MapLanguage languageMapper = new MapLanguage();


        File modelFile = new File("src/main/java/com/example/chatbot/Langdetect/langdetect-183.bin");

        LanguageDetectorModel trainedModel = new LanguageDetectorModel(modelFile);


        LanguageDetectorME languageDetector = new LanguageDetectorME(trainedModel);


        Language[] languages = languageDetector.predictLanguages(sentence);


        System.out.println("Predicted language: "+ languageMapper.getLanguage(languages[0].getLang()));


        return languageMapper.getLanguage(languages[0].getLang());
    }
}
