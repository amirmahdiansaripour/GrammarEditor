package main.ast.partOfSpeech;

import main.ast.Word;
import main.visitor.IVisitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Subject extends Word {
    protected static ArrayList<String> pluralExceptions = new ArrayList<String>(Arrays.asList("the police",
            "people", "the blind", "the poor", "the rich"));
    private ArrayList<String> count;
    public Subject(String t, Boolean cap, int line_){
        super(t, cap, line_);
        setCount();
//        nounDataset = makeDataSet("", nounDataset);
    }
    public void setCount(){
        String sub = text.toLowerCase();
        if(sub.equals("he") || sub.equals("she") || sub.equals("it")){
            count.add("has"); count.add("was"); count.add("is"); count.add("does");
//            count.add("did"); count.add("had");   did and had are common
        }
        else if(sub.equals("i")){
            count.add("have"); count.add("was"); count.add("am"); count.add("do");
        }
        else if(sub.equals("you") || sub.equals("we") || sub.equals("they")){
            count.add("have"); count.add("were"); count.add("are"); count.add("do");
        }
        else if(sub.contains("a ") || sub.contains("an ")){
            count.add("has"); count.add("was"); count.add("is"); count.add("does");
        }
        else if(pluralExceptions.contains(sub)){
            count.add("have"); count.add("were"); count.add("are"); count.add("do");
        }
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    @Override
    public void verify(){
        checkCapital();
//        checkValidWord(adverbDataset, " isn't an adverb.");
    }

}
