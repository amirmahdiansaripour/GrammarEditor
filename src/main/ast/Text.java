package main.ast;

import java.util.ArrayList;

import main.error.GrammarError;
import main.visitor.*;

public class Text extends astNode{
    public Text(){}
    private ArrayList<Sentence> sentences = new ArrayList<Sentence>();
    public ArrayList<Sentence> getSentences(){return sentences;}
    public void addSentence(Sentence sentence){sentences.add(sentence);}
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    @Override
    public String toString() {
        return "Text";
    }
    @Override
    public void verify() {return;}
}
