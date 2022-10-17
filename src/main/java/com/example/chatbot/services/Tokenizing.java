package com.example.chatbot.services;

import opennlp.tools.tokenize.SimpleTokenizer;

public class Tokenizing {
    public static String[] tokenizer (String sentence){
        SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE;
        String tokens[] = simpleTokenizer.tokenize(sentence);
        for (String token:tokens ){
            System.out.print(token);
        }
        return tokens;

    }
}
