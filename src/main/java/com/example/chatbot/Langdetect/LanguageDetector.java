package com.example.chatbot.Langdetect;

import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;

import java.io.File;
import java.io.IOException;

public class LanguageDetector {
    public static String languageDetector(String sentence) throws IOException {

        MapLanguage languageMapper = new MapLanguage();

        // load the trained Language Detector Model file
        File modelFile = new File("src/main/java/com/example/chatbot/Langdetect/langdetect-183.bin");

        LanguageDetectorModel trainedModel = new LanguageDetectorModel(modelFile);

        // load the model
        LanguageDetectorME languageDetector = new LanguageDetectorME(trainedModel);

        // use the model for predicting the language
        //Spanish
        Language[] languages = languageDetector.predictLanguages(sentence);


        System.out.println("Predicted language: "+ languageMapper.getLanguage(languages[0].getLang()));

        // uncomment to know confidence for rest of the languages
	       /* for(Language language:languages){
	            System.out.println(language.getLang()+"  confidence:"+language.getConfidence());
	        }*/
        return languageMapper.getLanguage(languages[0].getLang());
    }
}
