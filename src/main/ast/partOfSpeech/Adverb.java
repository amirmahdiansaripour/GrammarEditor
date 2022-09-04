package main.ast.partOfSpeech;
import main.ast.*;
import main.visitor.*;
import java.io.*;
import java.util.ArrayList;
import main.error.*;

public class Adverb extends Word{
    protected static ArrayList<String> adverbDataset = makeDataSet("src\\dataset\\adverbs\\adverbs.txt");
    protected static ArrayList<String> pastTimeAdverbs = makeDataSet("src\\dataset\\adverbs\\pastTimeAdverbs.txt");
    protected static ArrayList<String> adverbsOfFrequency = makeDataSet("src\\dataset\\adverbs\\adverbsOfFrequency.txt");
    protected static ArrayList<String> futureAdverbs = makeDataSet("src\\dataset\\adverbs\\futureAdverbs.txt");
    protected static ArrayList<String> perfectAdverbs = makeDataSet("src\\dataset\\adverbs\\presentPerfectAdverbs.txt");

    public ArrayList<String> tense;
    public Adverb(String t, Boolean capital_, int line_){
        super(t, capital_, line_);
        tense = new ArrayList<String>();
        setTense();
    }

    public void setTenseBasedOnDataSet(){
        if(pastTimeAdverbs.contains(text.toLowerCase())){
            tense.add("past");
        }
        if(adverbsOfFrequency.contains(text.toLowerCase())){
            tense.add("simple present");
        }
        if(futureAdverbs.contains(text.toLowerCase())){
            tense.add("future");
        }
        if(perfectAdverbs.contains(text.toLowerCase())) {
            tense.add("present perfect");
            tense.add("past perfect");
        }
    }

    public void setTenseBasedOnPrefix(){
        int spaceIndex = text.indexOf(' ');
//        System.out.println("index " + spaceIndex);

        if (spaceIndex != -1) {
            String prefix = text.substring(0, spaceIndex).toLowerCase();
            if (prefix.equals("last")) {
                tense.add("past");
            }
            else if (prefix.equals("every") || prefix.equals("each") || text.equals("in the morning") ||
                    text.equals("in the evening") || text.equals("at night")) {
                tense.add("simple present");
                tense.add("past");
                tense.add("future");
                tense.add("present");
            }
            else if (prefix.equals("next")) {
                tense.add("future");
            }
            else if (prefix.equals("very") || prefix.equals("this")) {
                tense.add("general");
                String root = text.substring(spaceIndex + 1).toLowerCase();
                if (!adverbDataset.contains(root.toLowerCase())) {
                    errors.add(new GrammarError.WrongWord(line, root + " isn't correct."));
                }
            }
            if (perfectAdverbs.contains(prefix.toLowerCase())) {
                tense.add("present perfect");
                tense.add("past perfect");
            }
        }
    }

    public void setTense(){
        setTenseBasedOnDataSet();
        if(tense.isEmpty()) {
            setTenseBasedOnPrefix();
        }
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    @Override
    public void verify(){
        checkCapital();
//        if(tense == null){
//            if(!adverbDataset.contains(text.toLowerCase())){
////                checkValidWord(text, adverbDataset, " isn't an adverb.");
//                errors.add(new GrammarError.WrongWord(line, text + " isn't an adverb."));
//            }
//        }
    }
}
