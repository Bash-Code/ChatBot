package com.example.chatbot.Langdetect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MapLanguage {
    public String getLanguage(String langCode) throws IOException {

        HashMap<String, String> langMap = readToHashmap();

        return langMap.get(langCode);

    }

    public HashMap<String, String> readToHashmap() throws IOException {
        HashMap<String, String> map = new HashMap<String, String>();
        BufferedReader in = new BufferedReader(new FileReader("src/main/java/com/example/chatbot/Langdetect/LanguageMapping.txt"));
        String line = "";

        while ((line = in.readLine()) != null) {
            String parts[] = line.split("\t");
            map.put(parts[0], parts[1]);
        }
        in.close();

        return map;

    }
}
