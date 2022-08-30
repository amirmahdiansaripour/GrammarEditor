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
    protected static ArrayList<String> presentDataset;
    protected static ArrayList<String> pastDataset;
    private String root;
    public String tense;
    private String auxiliary;
    public void nonSimpleVerbs(String aux){
        if (aux.equals("am")) {
            tense = "present";
            auxiliary = "am";
        }
        else if (aux.equals("is")) {
            tense = "present";
            auxiliary = "is";
        }
        else if (aux.equals("are")) {
            tense = "present";
            auxiliary = "are";
        }
        else if (aux.equals("was")) {
            tense = "past";
            auxiliary = "was";
        }
        else if (aux.equals("were")) {
            tense = "past";
            auxiliary = "were";
        }
    }
    public void simpleVerbs(){
        if(presentDataset.contains(text.toLowerCase(Locale.ROOT))){     // simple present
            tense = "simple present";
            if(pastDataset.contains(text.toLowerCase(Locale.ROOT))){
                tense = "both"; // for verbs such as cost, put, etc.
            }
        }
        else if(pastDataset.contains(text.toLowerCase(Locale.ROOT))){   // irregular simple past
            tense = "past";
        }
        else if(text.substring(text.length() - 2).equals("ed") &&   // regular simple past
                (presentDataset.contains(text.substring(0, text.length() - 2).toLowerCase()) ||
                presentDataset.contains(text.substring(0, text.length() - 1).toLowerCase()))){
            tense = "past";
        }
    }
    public void setSense(){
        int indexOfAuxiliary = text.indexOf(" ");
        if(indexOfAuxiliary != -1) {
            String aux = text.substring(0, indexOfAuxiliary);
            nonSimpleVerbs(aux);
        }
        else{
            simpleVerbs();
        }
    }
    public Verb(String t, String root_) throws IOException {
        super(t, false); // verbs are never capitalized
        presentDataset = makeDataSet("src\\dataset\\presentTense.txt", presentDataset);
        pastDataset = makeDataSet("src\\dataset\\irregularPast.txt", pastDataset);
        root = root_;
        setSense();
//        System.out.println("Verb tense " + tense);
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    @Override
    public void verify(){
        checkCapital();
        if(tense == null){
            errors.add(new GrammarError.WrongWord(line, root + " isn't a verb."));
        }
    }
}
