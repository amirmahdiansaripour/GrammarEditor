package main.ast.partOfSpeech;
import main.ast.*;
import main.visitor.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import main.error.*;

public class Adverb extends Word{
    protected static ArrayList<String> adverbDataset;
    public Adverb(String t, Boolean capital_) throws IOException{
        super(t, capital_);
        adverbDataset = makeDataSet("src\\dataset\\adverbs.txt", adverbDataset);
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    @Override
    public void verify(){
        checkCapital();
        checkValidWord(text, adverbDataset, " isn't an adverb.");
    }
}
