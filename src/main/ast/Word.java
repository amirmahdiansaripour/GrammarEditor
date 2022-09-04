package main.ast;
import main.visitor.*;
import main.error.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Word extends astNode{
    protected String text;
    protected Boolean capital;
    public Word(String t, Boolean capital_, int line_){
        text = t;
        capital = capital_;
        line = line_;
    }

    protected static ArrayList<String> makeDataSet(String address){
        try {
            ArrayList<String> dataSet = new ArrayList<String>();
            File file = new File(address);
            BufferedReader stream = new BufferedReader(new FileReader(file));
            String line;
            while ((line = stream.readLine()) != null) {
                dataSet.add(line);
//            if(address.equals("src\\dataset\\adverbs\\futureAdverbs.txt"))
//                System.out.println(line);
            }
            stream.close();
            return dataSet;
        }
        catch(IOException err){
            System.err.println(address + " not Found!");
            System.exit(0);
            return null;
        }
    }
    @Override
    public String toString(){return text;}
    @Override
    public void verify(){
        return;
    }

    public void checkCapital(){
        if(capital && Character.isLowerCase(text.charAt(0)))
            errors.add(new GrammarError.WordShouldBeCapital(line, text));
        else if(!capital && Character.isUpperCase(text.charAt(0)))
            errors.add(new GrammarError.WordShouldBeLittle(line, text));
    }

    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}

}
