package com.example.chatbot.services;

import java.util.HashMap;
import java.util.Map;

public class Questionanswer {
    public static Map<String, String> questionAnswer = new HashMap<>();

    /*
     * Define answers for each given category.
     */
    static {
        questionAnswer.put("greeting", "Hello, how can I help you?");
        questionAnswer.put("conversation-continue", "What else can I help you with?");
        questionAnswer.put("agency-inquiry", "the agency opens it's doors at 10am");
        questionAnswer.put("service-inquiry", "we offer costumer services at the number 0800208099");
        questionAnswer.put("account-inquiry", "visit our website in www.emiBank.org");
        questionAnswer.put("conversation-complete", "Nice chatting with you. Bye.");
    }
}
