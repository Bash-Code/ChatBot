package com.example.chatbot.services;

import opennlp.tools.lemmatizer.DictionaryLemmatizer;

import java.io.*;

public class Lemmatizing {
    public static String[] lemmatizing(String[] tokens, String[] tags){
        String[] lemmas = {};
        try {
            InputStream dictLemmatizer = new FileInputStream("src/main/java/com/example/chatbot/services/en-lemmatizer.txt");
            DictionaryLemmatizer lemmatizer = new DictionaryLemmatizer(dictLemmatizer);
            lemmas = lemmatizer.lemmatize(tokens, tags);

            for(int i=0;i< tokens.length;i++){
                System.out.println(tokens[i]+" -"+tags[i]+" : "+lemmas[i]);
            }
            return lemmas;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lemmas;
    }
}
