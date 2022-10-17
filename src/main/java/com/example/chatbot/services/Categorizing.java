package com.example.chatbot.services;

import opennlp.tools.doccat.*;
import opennlp.tools.util.*;
import opennlp.tools.util.model.ModelUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Categorizing {
    public static DoccatModel trainCategorizerModel() throws FileNotFoundException, IOException {
        InputStreamFactory inputStreamFactory = new MarkableFileInputStreamFactory(new File("src/main/java/com/example/chatbot/services/categorizer.txt"));
        ObjectStream<String> lineStream = new PlainTextByLineStream(inputStreamFactory, StandardCharsets.UTF_8);
        ObjectStream<DocumentSample> sampleStream = new DocumentSampleStream(lineStream);

        DoccatFactory factory = new DoccatFactory(new FeatureGenerator[] { new BagOfWordsFeatureGenerator() });

        TrainingParameters params = ModelUtil.createDefaultTrainingParameters();
        params.put(TrainingParameters.CUTOFF_PARAM, 0);

        DoccatModel model = DocumentCategorizerME.train("en", sampleStream, params, factory);
        return model;
    }

    public static String detectCategory(DoccatModel model, String[] finalTokens) throws IOException {
        DocumentCategorizerME myCategorizer = new DocumentCategorizerME(model);


        double[] probabilitiesOfOutcomes = myCategorizer.categorize(finalTokens);
        String category = myCategorizer.getBestCategory(probabilitiesOfOutcomes);
        System.out.println("Category: " + category);

        return category;
    }
}
