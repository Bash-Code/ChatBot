package com.example.chatbot.Models;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class POSTagging {
     public static void posTagging(String[] tokens) throws IOException {
         InputStream posModelIn = new FileInputStream("src/main/java/com/example/chatbot/Models/en-pos-maxent.bin");
         POSModel posModel = new POSModel(posModelIn);
         POSTaggerME posTagger = new POSTaggerME(posModel);

         String tags[] = posTagger.tag(tokens);
         double probs[] = posTagger.probs();

         for(int i=0;i<tokens.length;i++){
             System.out.println(tokens[i]+"\t"+tags[i]+"\t"+probs[i]);
         }


    }
}
