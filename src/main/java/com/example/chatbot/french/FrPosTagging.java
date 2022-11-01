package com.example.chatbot.french;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FrPosTagging {
    public static String[] posTagger(String[] tokens) throws IOException {
        InputStream posModelIn = new FileInputStream("model/opennlp-fr-ud-ftb-pos-1.0-1.9.3.bin");
        POSModel posModel = new POSModel(posModelIn);
        POSTaggerME posTagger = new POSTaggerME(posModel);

        String tags[] = posTagger.tag(tokens);
        double probs[] = posTagger.probs();

        for(int i=0;i<tokens.length;i++){
            System.out.println(tokens[i]+"\t"+tags[i]+"\t"+probs[i]);
        }
        return tags;
    }
}
