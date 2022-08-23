package main.ast;

import main.ast.partOfSpeech.*;
import main.visitor.IVisitor;
import java.util.*;

public class Sentence extends astNode {
    private int index;
    private ArrayList<String> words;
    private ArrayList<String> subject;
    private ArrayList<String> object;
    private ArrayList<String> verb;
    private ArrayList<Adverb> adverb;


    public Sentence(){
        words = new ArrayList<String>();
        subject = new ArrayList<String>();
        object = new ArrayList<String>();
        verb = new ArrayList<String>();
        adverb = new ArrayList<Adverb>();
    }
    public void setIndex(int index){this.index = index;}
    public int getIndex(){return this.index;}
    public void addSubject(String subject){words.add("Subject: " + subject); this.subject.add(subject);}
    public void addObject(String object){words.add("Object: " + object); this.object.add(object);}
    public void addVerb(String verb){words.add("Verb: " + verb); this.verb.add(verb);}
    public void addAdverb(Adverb adverb){words.add("Adverb: " + adverb.toString()); this.adverb.add(adverb);}
    public ArrayList<String> getWords(){return words;}
    public ArrayList<String> getSubject(){return subject;}
    public ArrayList<String> getObject(){return object;}
    public ArrayList<String> getVerb(){return verb;}
    public ArrayList<Adverb> getAdverb(){return adverb;}
    @Override
    public String toString(){return "Sentence";}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
