package main.ast.partOfSpeech;

import main.ast.Word;
import main.error.GrammarError;
import main.visitor.IVisitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class Verb extends Word {
    protected static ArrayList<String> verbDataset;
    private String root;
    public Verb(String t, String root_) throws IOException {
        super(t, false); // verbs are never capitalized
        verbDataset = makeDataSet("src\\dataset\\verbs.txt", verbDataset);
        root = root_;
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    @Override
    public void verify(){
        checkCapital();
        checkValidWord(root, verbDataset, " isn't a verb.");
    }
}
