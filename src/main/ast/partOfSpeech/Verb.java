package main.ast.partOfSpeech;

import main.ast.Word;
import main.error.GrammarError;
import main.visitor.IVisitor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Verb extends Word {
    protected static ArrayList<String> presentDataset = makeDataSet("src\\dataset\\verbs\\simplePresentVerbs.txt");
    protected static ArrayList<String> pastDataset = makeDataSet("src\\dataset\\verbs\\irregularPastVerbs.txt");
    protected static ArrayList<String> pastExceptions = makeDataSet("src\\dataset\\verbs\\pastExceptions.txt");
    protected static ArrayList<String> simplePresentExceptions = makeDataSet("src\\dataset\\verbs\\simplePresentExceptions.txt");
    protected static ArrayList<String> wrongs = makeDataSet("src\\dataset\\verbs\\wrongs.txt");
    protected static ArrayList<String> modals = new ArrayList<>(Arrays.asList("will", "should", "must", "could", "would", "can", "may"));
    protected static ArrayList<String> literalChanges = new ArrayList<>(Arrays.asList("ss", "sh", "ch", "x"));
    protected static ArrayList<String> presentPerfect = new ArrayList<>(Arrays.asList("has", "have"));
    private String root, auxiliary;
    public ArrayList<String> tense, count;
    public Verb(String t, int line_) {
        super(t, false, line_); // verbs are never capitalized
        tense = new ArrayList<String>();
        count = new ArrayList<String>();
        setTense();
    }
    public void nonSimpleVerbs(int index){
        String aux = text.substring(0, index);
        String remained = text.substring(index + 1);
//        System.out.println("aux " + aux);
        root = remained;
        if (aux.equals("am") || aux.equals("is") || aux.equals("are")) {
            if(aux.equals("am")) count.add("first singular");
            else if(aux.equals("is")) count.add("third singular");
            else if(aux.equals("are")) count.add("plural");
            if(wrongs.contains(remained.toLowerCase())){
                errors.add(new GrammarError.IsntCorrect(line, remained));
                tense.add("wrong");
            }
            else {
                tense.add("present"); tense.add("future");
            }
        }
        else if (aux.equals("was") || aux.equals("were")) {
            if(aux.equals("was")) {count.add("first singular"); count.add("third singular");}
            else if(aux.equals("were")) count.add("plural");
            if(wrongs.contains(remained.toLowerCase())){
                errors.add(new GrammarError.IsntCorrect(line, remained));
                tense.add("wrong");
            }
            else tense.add("past");
        }
        else if(modals.contains(aux.toLowerCase())){
            count.add("first singular"); count.add("third singular"); count.add("plural");
            if(!presentDataset.contains(remained)){
                errors.add(new GrammarError.IsntCorrect(line, text));
                tense.add("wrong");
            }
            else {
                tense.add("present"); tense.add("simple present"); tense.add("future");
            }
        }
        else if(presentPerfect.contains(aux.toLowerCase())){
            if(aux.toLowerCase().equals("has")) count.add("third singular");
            else if(aux.toLowerCase().equals("have")) {count.add("first singular"); count.add("plural");}
            if(regularPresentOrPast("ed", 1, remained)){ // received, agreed
                if(wrongs.contains(text.toLowerCase())){
                    errors.add(new GrammarError.IsntCorrect(line, text));
                    tense.add("wrong");
                }
                else tense.add("present perfect");
            }
        }
    }
    public Boolean regularPresentOrPast(String suffix, int offset, String check){
//        System.out.println(check + ";;" + check.substring(check.length() - suffix.length()));
//        System.out.println(check + ";;" + check.substring(0, check.length() - suffix.length()));
        if(check.substring(check.length() - suffix.length()).equals(suffix) &&
        (presentDataset.contains(check.substring(0, check.length() - suffix.length()).toLowerCase()) ||
        presentDataset.contains(check.substring(0, check.length() - offset).toLowerCase()))){return true;}
        else {return false;}
    }

    public Boolean literalChange(){
        String lastTwo = text.substring(text.length() - 4, text.length() - 2);
        String last = text.substring(text.length() - 3, text.length() - 2);
//        System.out.println(text + " " + lastTwo);
//        System.out.println(text + " " + last);
        if(literalChanges.contains(lastTwo) || literalChanges.contains(last)){
            return true;
        }
        return false;
    }

    public void addSuffixToMakeTense(){
        if(regularPresentOrPast("s", 1, text)){  // receives, agrees
            if(literalChange() || wrongs.contains(text.toLowerCase())){
                errors.add(new GrammarError.IsntCorrect(line, text));
                tense.add("wrong");
            }
            else{
                count.add("third singular");
                tense.add("simple present");
            }
        }
        else if(regularPresentOrPast("es", 2, text)){
            if(!literalChange() || wrongs.contains(text.toLowerCase())){
                errors.add(new GrammarError.IsntCorrect(line, text));
                tense.add("wrong");
            }
            else{
                count.add("third singular");
                tense.add("simple present");
            }
        }
        else if(regularPresentOrPast("ed", 1, text)){ // received, agreed
            if(wrongs.contains(text.toLowerCase())){
                errors.add(new GrammarError.IsntCorrect(line, text));
                tense.add("wrong");
            }
            else {
                count.add("first singular"); count.add("third singular"); count.add("plural");
                tense.add("past");
            }
        }
    }

    public void simpleVerbs(){
        if(pastExceptions.contains(text.toLowerCase()) ||pastDataset.contains(text.toLowerCase())){
            tense.add("past");
            count.add("plural"); count.add("first singular"); count.add("third singular");
        }
        else if(simplePresentExceptions.contains(text.toLowerCase())){
            tense.add("simple present");
            count.add("first singular"); count.add("plural");
        }
        else if(presentDataset.contains(text.toLowerCase())){     // simple present
            tense.add("simple present");
            count.add("first singular"); count.add("plural");
            if(pastDataset.contains(text.toLowerCase())){
                tense.add("past"); // for verbs such as cost, put, cut etc.
                count.add("third singular");
            }
        }
        else addSuffixToMakeTense();
    }

    public void setTense(){
        int indexOfAuxiliary = text.lastIndexOf(' ');   // Why last index? Because of auxiliaries
                                                            // such as: have been , will be, etc.
        if(indexOfAuxiliary != -1) {
            nonSimpleVerbs(indexOfAuxiliary);
        }
        else{
            root = text;
            simpleVerbs();
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
            tense.add("wrong");
            errors.add(new GrammarError.WrongWord(line, text + " isn't correct."));
        }
    }
}
