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
    public Verb(String t) throws IOException {
        super(t, false); // verbs are never capitalized
        verbDataset = makeDataSet("src\\dataset\\verbs.txt", verbDataset);
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    @Override
    public GrammarError verify(){
        return generalVerify(verbDataset, " isn't a verb.");
    }
}
