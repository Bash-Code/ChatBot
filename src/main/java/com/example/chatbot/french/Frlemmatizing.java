package com.example.chatbot.french;

import opennlp.tools.lemmatizer.DictionaryLemmatizer;
import opennlp.tools.lemmatizer.LemmatizerME;
import opennlp.tools.lemmatizer.LemmatizerModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Frlemmatizing {
    public static String[] lemmatizing(String[] tokens, String[] tags){
        LemmatizerModel model = null;
        try (InputStream modelIn = new FileInputStream("model/en-lemmatizer.bin")){
            model = new LemmatizerModel(modelIn);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LemmatizerME lemmatizer = new LemmatizerME(model);
        String[] lemmas = lemmatizer.lemmatize(tokens, tags);
        return lemmas;
    }
}
