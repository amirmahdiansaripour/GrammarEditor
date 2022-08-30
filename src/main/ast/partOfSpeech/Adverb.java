package main.ast.partOfSpeech;
import main.ast.*;
import main.visitor.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import main.error.*;

public class Adverb extends Word{
    protected static ArrayList<String> adverbDataset, pastTimeAdverbs, simplePresentAdverbs;
    public String tense;
    public Adverb(String t, Boolean capital_, int line_) throws IOException{
        super(t, capital_, line_);
        adverbDataset = makeDataSet("src\\dataset\\adverbs.txt", adverbDataset);
        pastTimeAdverbs = makeDataSet("src\\dataset\\pastTimeAdverbs.txt", pastTimeAdverbs);
        simplePresentAdverbs = makeDataSet("src\\dataset\\simplePresentTenseAdverbs.txt", simplePresentAdverbs);
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
                    errors.add(new GrammarError.WrongWord(line, root + " isn't correct."));
                }
            }
        }
        else if(pastTimeAdverbs.contains(text.toLowerCase())){
            tense = "past";
            if(simplePresentAdverbs.contains(text.toLowerCase())){
                tense = "both";
            }
        }
        else if(simplePresentAdverbs.contains(text.toLowerCase())){
            tense = "simple present";
        }
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    @Override
    public void verify(){
        checkCapital();
        if(tense == null){
            if(!adverbDataset.contains(text.toLowerCase(Locale.ROOT))){
//                checkValidWord(text, adverbDataset, " isn't an adverb.");
                errors.add(new GrammarError.WrongWord(line, text + " isn't an adverb."));
            }
        }
    }
}
