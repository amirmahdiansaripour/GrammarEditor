package main.ast.partOfSpeech;
import main.ast.*;
import main.visitor.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import main.error.*;

public class Adverb extends Word{
    protected static ArrayList<String> adverbDataset;
    protected static ArrayList<String> pastTimeAdverbs;
    public String tense;
    public Adverb(String t, Boolean capital_) throws IOException{
        super(t, capital_);
        adverbDataset = makeDataSet("src\\dataset\\adverbs.txt", adverbDataset);
        pastTimeAdverbs = makeDataSet("src\\dataset\\pastTimeAdverbs.txt", pastTimeAdverbs);
        setTense();
    }
    public void setTense(){
        int spaceIndex = text.indexOf(" ");
        if(spaceIndex != -1){
            String prefix = text.substring(0, spaceIndex).toLowerCase();
            if(prefix.equals("last")){tense = "past";}
            else if(prefix.equals("every")){tense = "simple present";}
            else if(prefix.equals("next")){tense = "present";}
            else if(prefix.equals("very")){
                tense = "general";
                String root = text.substring(spaceIndex + 1).toLowerCase();
                if(!adverbDataset.contains(root.toLowerCase())){
                    checkValidWord(root, adverbDataset, " isn't an adverb.");
                }
            }
        }
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    @Override
    public void verify(){
        if(pastTimeAdverbs.contains(text.toLowerCase())){ tense = "past";}
        checkCapital();
        if(tense == null){
            if(!adverbDataset.contains(text.toLowerCase(Locale.ROOT))){
//                checkValidWord(text, adverbDataset, " isn't an adverb.");
                errors.add(new GrammarError.WrongWord(line, text + " isn't an adverb."));
            }
        }
    }
}
