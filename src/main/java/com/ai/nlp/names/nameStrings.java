package com.ai.nlp.names;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static java.lang.System.out;

/**
 * Created by
 * @author Derrick on 14-Oct-18.
 */
public class nameStrings {
    static final String[] SENTENCES = {
            "Jack was taller than peter. ",
            "However Mr.smith was taller than both of them. ",
            "The same could be said for mary and tommy. ",
            "Mary Anne was the tallest."
    };
    public static void openNLPExample(){
        out.println("---OpenNLP NER Example---");
        try(
                InputStream tokenModelStream = new FileInputStream(new File("en-token.bin"));
                InputStream nerModelInput = new FileInputStream(new File("en-ner-person.bin"))
        ){
            TokenizerModel tokenizerModel = new TokenizerModel(tokenModelStream);
            Tokenizer tokenizer = new TokenizerME(tokenizerModel);

            TokenNameFinderModel nameModel = new TokenNameFinderModel(nerModelInput);
            NameFinderME nameFinder = new NameFinderME(nameModel);

            for (String sentence:SENTENCES){
                out.println("Sentence: ["+sentence+"]");
                String tokens[] = tokenizer.tokenize(sentence);
                Span nameSpans[] = nameFinder.find(tokens);
                double[] spanProberbilities = nameFinder.probs(nameSpans);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
