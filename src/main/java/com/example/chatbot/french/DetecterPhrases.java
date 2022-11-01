package com.example.chatbot.french;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DetecterPhrases {
    public static String[] detecteurPhrase(String sentence) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("model/opennlp-1.0-1.9.3fr-ud-ftb-sentence-1.0-1.9.3.bin");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        SentenceModel model = new SentenceModel(inputStream);

        //Instantiating the SentenceDetectorME class
        SentenceDetectorME detector = new SentenceDetectorME(model);

        //Detecting the sentence
        String sentences[] = detector.sentDetect(sentence);

        //Printing the sentences
        for(String sent : sentences)
            System.out.println(sent);

        return sentences;
    }
}
