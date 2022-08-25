package main.ast;
import main.visitor.*;
import main.error.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class Word extends astNode{
    protected String text;
    protected Boolean capital;
    public Word(String t, Boolean capital_){
        text = t;
        capital = capital_;
    }

    protected ArrayList<String> makeDataSet(String address, ArrayList<String> dataSet) throws IOException {
        dataSet = new ArrayList<String>();
        File file = new File(address);
        BufferedReader stream = new BufferedReader(new FileReader(file));
        String line;
        while ((line = stream.readLine()) != null)
            dataSet.add(line);
        stream.close();
        return dataSet;
    }

    public void captalize(){
        capital = true;
    }
    @Override
    public String toString(){return text;}
    @Override
    public GrammarError verify(){return null;}

    public GrammarError checkCapital(){
        if(capital && Character.isLowerCase(text.charAt(0)))
            return new GrammarError.WordShouldBeCapital(line, text);
        else if(!capital && Character.isUpperCase(text.charAt(0)))
            return new GrammarError.WordShouldBeLittle(line, text);
        return null;
    }

    public GrammarError generalVerify(ArrayList<String> dataSet, String errorPartOfSpeech){
        GrammarError capError = checkCapital();
        if(capError != null){
            return capError;
        }
        if(!dataSet.contains(text.toLowerCase(Locale.ROOT))){
            return new GrammarError.WrongWord(line, text + errorPartOfSpeech);
        }
        return null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}

}
