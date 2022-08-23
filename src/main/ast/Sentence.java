package main.ast;

import main.visitor.IVisitor;
import java.util.*;

public class Sentence extends astNode {
    private int index;
    private ArrayList<String> words;
    private ArrayList<String> subject;
    private ArrayList<String> object;
    private ArrayList<String> verb;
    private ArrayList<String> adverb;


    public Sentence(){
        words = new ArrayList<String>();
        subject = new ArrayList<String>();
        object = new ArrayList<String>();
        verb = new ArrayList<String>();
        adverb = new ArrayList<String>();
    }
    public void setIndex(int index){this.index = index;}
    public String getIndex(){return String.valueOf(this.index);}
    public void addSubject(String subject){words.add("Subject: " + subject); this.subject.add(subject);}
    public void addObject(String object){words.add("Object: " + object); this.object.add(object);}
    public void addVerb(String verb){words.add("Verb: " + verb); this.verb.add(verb);}
    public void addAdverb(String adverb){words.add("Adverb: " + adverb); this.adverb.add(adverb);}
    public ArrayList<String> getWords(){return words;}
    @Override
    public String toString(){return "Sentence";}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
