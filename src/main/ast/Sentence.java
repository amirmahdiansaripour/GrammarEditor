package main.ast;

import main.ast.partOfSpeech.*;
import main.error.GrammarError;
import main.visitor.IVisitor;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Sentence extends astNode {
    private int index;
    private ArrayList<ArrayList<String>> words;
    private ArrayList<String> subject;
    private ArrayList<String> object;
    private ArrayList<Verb> verb;
    private ArrayList<Adverb> adverb;
    private Boolean capital;

    public Sentence(){
        capital = false;
        words = new ArrayList<ArrayList<String>>();
        subject = new ArrayList<String>();
        object = new ArrayList<String>();
        verb = new ArrayList<Verb>();
        adverb = new ArrayList<Adverb>();
    }
    public void setIndex(int index){this.index = index;}
    public int getIndex(){return this.index;}
    public void addSubject(String subject){
        words.add(new ArrayList<String>(){{add("Subject: "); add(subject);}});
        this.subject.add(subject);
    }
    public void addObject(String object){
        words.add(new ArrayList<String>(){{add("Object: "); add(object);}});
        this.object.add(object);
    }
    public void addVerb(Verb verb){
        words.add(new ArrayList<String>(){{add("Verb: "); add(verb.toString());}});
        this.verb.add(verb);
    }
    public void addAdverb(Adverb adverb){
        words.add(new ArrayList<String>(){{add("Adverb: "); add(adverb.toString());}});
        this.adverb.add(adverb);
    }
    public ArrayList<ArrayList<String>> getWords(){return words;}
    public ArrayList<String> getSubject(){return subject;}
    public ArrayList<String> getObject(){return object;}
    public ArrayList<Verb> getVerb(){return verb;}
    public ArrayList<Adverb> getAdverb(){return adverb;}
    public Boolean isCapital(){return capital;}
    public void capitalize(){capital = true;}
    @Override
    public String toString(){return "Sentence";}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
    @Override
    public GrammarError verify(){
//        String firstWord = words.get(0).get(0);
//        if(capital){
//            if(Character.isLowerCase(firstWord.charAt(0))){
//                return null;
//            }
//        }
        return null;
    }
}
