package com.example.chatbot.french;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Tokenizerfr {
    public static String[] tokenizer(String sentence) throws IOException {
        InputStream modelIn = new FileInputStream("model/opennlp-en-ud-ewt-tokens-1.0-1.9.3.bin");
        TokenizerModel model = new TokenizerModel(modelIn);
        Tokenizer tokenizer = new TokenizerME(model);
        String tokens[] = tokenizer.tokenize(sentence);
        return  tokens;
    }
}
