package main.ast;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class Sentence extends astNode {
    private ArrayList<String> subject;
//    private String object;
//    private String adverb;
//    private String verb;

    public Sentence(){
        this.subject = new ArrayList<String>();
    }
    public void addSubject(String subject){
        this.subject.add(subject);
    }
    @Override
    public String toString(){return "";}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
