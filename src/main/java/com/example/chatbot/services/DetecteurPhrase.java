package com.example.chatbot.services;

import com.example.chatbot.services.POSTagging;
import com.example.chatbot.services.Tokenizing;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.sentdetect.SentenceSampleStream;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.MarkableFileInputStreamFactory;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.TrainingParameters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DetecteurPhrase {

    public static String[] entrainerDetecteurPhrase(String testString) throws IOException {
        File dir = new File("model");
        InputStreamFactory in = new MarkableFileInputStreamFactory(new File("src/main/java/com/example/chatbot/services/Training_Data.txt"));
        TrainingParameters params = new TrainingParameters();
        params.put(TrainingParameters.ITERATIONS_PARAM, Integer.toString(15));
        params.put(TrainingParameters.CUTOFF_PARAM, Integer.toString(1));

        SentenceModel phraseModel = SentenceDetectorME.train("en",new SentenceSampleStream(new PlainTextByLineStream(in, StandardCharsets.UTF_8)),true, null, params);

        File outFile = new File(dir,"enPhrases.bin");
        FileOutputStream outFileStream = new FileOutputStream(outFile);
        phraseModel.serialize(outFileStream);

        SentenceDetectorME phraseDetecteur = new SentenceDetectorME(phraseModel);

        System.out.println("test String : "+ testString);

        String[] phrases = phraseDetecteur.sentDetect(testString);
        System.out.println("les phrases detectée");

        return phrases;
    }
}
