package com.example.chatbot.french;

import java.util.HashMap;
import java.util.Map;

public class Reponse {
    public static Map<String, String> questionAnswer = new HashMap<>();

    /*
     * Define answers for each given category.
     */
    static {
        questionAnswer.put("salutation", "Bonjours comment est-ce que je pourrais vous aider?");
        questionAnswer.put("conversation-non-terminée", "d'autre choses?");
        questionAnswer.put("question-agence", "l'agence ouvre à 10h");
        questionAnswer.put("question-service", "notre service clientèle appelez le numéro 0800097765");
        questionAnswer.put("conversation-terminée", "bye bye.");
        questionAnswer.put("remerciements", "pas de soucie!");
        questionAnswer.put("affirmation", "d'accord");
    }
}
