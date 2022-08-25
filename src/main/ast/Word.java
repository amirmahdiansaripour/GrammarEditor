package main.ast;
import main.visitor.*;
import main.error.*;

import java.util.ArrayList;

public class Word extends astNode{
    protected String text;
    protected ArrayList<String> dataset;
    protected Boolean capital;
    public Word(String t, Boolean capital_){
        text = t;
        capital = capital_;
        dataset = new ArrayList<String>();
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
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}

}
