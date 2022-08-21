package main.ast;

import main.visitor.IVisitor;

public class Sentence extends astNode {
//    private Subject subject;
//    private Objective object;
//    private Adverb adverb;
//    private Verb verb;

    @Override
    public String toString(){return "";}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
