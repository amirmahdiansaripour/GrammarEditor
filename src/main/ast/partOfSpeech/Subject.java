package main.ast.partOfSpeech;

import main.ast.Word;
import main.visitor.IVisitor;

import java.io.IOException;
import java.util.ArrayList;

public class Subject extends Word {
    protected static ArrayList<String> nounDataset;
    public Subject(String t, Boolean cap, int line_) throws IOException {
        super(t, cap, line_);
//        nounDataset = makeDataSet("", nounDataset);
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
