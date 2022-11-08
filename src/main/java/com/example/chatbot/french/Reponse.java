package com.example.chatbot.french;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Reponse {
    public static Map<String, String> questionAnswer = new HashMap<>();

    public static HashMap<String, String> putInHashmap() throws IOException {
        HashMap<String, String> map = new HashMap<String, String>();
        BufferedReader in = new BufferedReader(new FileReader("src/main/java/com/example/chatbot/french/reponses.txt"));
        String line = "";

        while ((line = in.readLine()) != null) {
            String parts[] = line.split("_");
            map.put(parts[0], parts[1]);
        }
        in.close();

        return map;

    }
    static {
        try {
            questionAnswer = putInHashmap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
