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
    protected static ArrayList<String> presentDataset, pastDataset, pastExceptions, simplePresentExceptions,
            continuousExceptions;

    private String root, tense, auxiliary;
    public Verb(String t, String root_, int line_) throws IOException {
        super(t, false, line_); // verbs are never capitalized
        presentDataset = makeDataSet("src\\dataset\\verbs\\simplePresentVerbs.txt", presentDataset);
        pastDataset = makeDataSet("src\\dataset\\verbs\\irregularPastVerbs.txt", pastDataset);
        pastExceptions = makeDataSet("src\\dataset\\verbs\\pastExceptions.txt", pastExceptions);
        simplePresentExceptions = makeDataSet("src\\dataset\\verbs\\simplePresentExceptions.txt", simplePresentExceptions);
        continuousExceptions = makeDataSet("src\\dataset\\verbs\\continuousExceptions.txt", continuousExceptions);
        root = root_;
        setSense();
//        System.out.println(text + " " + tense);
    }
    public void nonSimpleVerbs(String aux){
        if (aux.equals("am") || aux.equals("is") || aux.equals("are")) {
            tense = "present";
            auxiliary = aux;

        }
        else if (aux.equals("was") || aux.equals("were")) {
            tense = "past";
            auxiliary = aux;
        }
    }
    public Boolean regularPresentOrPast(String suffix, int offset){
//        System.out.println(text + ";; " + text.substring(text.length() - suffix.length()));
        if(text.substring(text.length() - suffix.length()).equals(suffix) &&
        (presentDataset.contains(text.substring(0, text.length() - suffix.length()).toLowerCase()) ||
        presentDataset.contains(text.substring(0, text.length() - offset).toLowerCase()))){return true;}
        else {return false;}
    }

    public Boolean change(){
        String lastTwo = text.substring(text.length() - 3, text.length() - 1);
        String last = text.substring(text.length() - 2, text.length() - 1);
//        System.out.println(text + " " + lastTwo);
//        System.out.println(text + " " + last);
        if(lastTwo.equals("sh") || lastTwo.equals("ch") || lastTwo.equals("ss") || last.equals("x")){
            return true;
        }
        return false;
    }

    public void simpleVerbs(){
        if(pastExceptions.contains(text.toLowerCase())){
            tense = "past";
        }
        else if(simplePresentExceptions.contains(text.toLowerCase())){
            tense = "simple present";
        }
        else if(regularPresentOrPast("s", 1)){  // receives, agrees
            if(change()){
//                System.out.println(text + "s" );
                errors.add(new GrammarError.IsntCorrect(line, text));
                tense = "wrong";
            }
            else tense = "simple present";
        }
        else if(regularPresentOrPast("es", 2)){
            if(!change()){
//                System.out.println(text + "es" );
                errors.add(new GrammarError.IsntCorrect(line, text));
                tense = "wrong";
            }
            else tense = "simple present";
        }
        else if(presentDataset.contains(text.toLowerCase())){     // simple present
            tense = "simple present";
            if(pastDataset.contains(text.toLowerCase())){
                tense = "both"; // for verbs such as cost, put, etc.
            }
        }
        else if(pastDataset.contains(text.toLowerCase())){   // irregular simple past
            tense = "past";
        }
        else if(regularPresentOrPast("ed", 1)){ // received, agreed
//            System.out.println(text + "ed" );
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
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    @Override
    public void verify(){
        checkCapital();
        if(tense == null){
            tense = "wrong";
            errors.add(new GrammarError.WrongWord(line, root + " isn't correct."));
        }
    }
}
