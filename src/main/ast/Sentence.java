package main.ast;

import main.ast.partOfSpeech.*;
import main.error.GrammarError;
import main.visitor.IVisitor;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Sentence extends astNode {
    private int index;
    private ArrayList<ArrayList<String>> words;
    private ArrayList<Subject> subject;
    private ArrayList<OBject> object;
    private ArrayList<Verb> verb;
    private ArrayList<Adverb> adverb;
    private Boolean capital;
    private String singOrPru;
    public Sentence(int line_){
        capital = false;
        words = new ArrayList<ArrayList<String>>();
        subject = new ArrayList<Subject>();
        object = new ArrayList<OBject>();
        verb = new ArrayList<Verb>();
        adverb = new ArrayList<Adverb>();
        line = line_;
    }
    public void setSingOrPru(String singOrPru_){
        singOrPru = singOrPru_;
    }
    public void setIndex(int index){this.index = index;}
    public int getIndex(){return this.index;}
    public void addSubject(Subject subject){
        words.add(new ArrayList<String>(){{add("Subject: "); add(subject.toString());}});
        this.subject.add(subject);
    }
    public void addObject(OBject object){
        words.add(new ArrayList<String>(){{add("Object: "); add(object.toString());}});
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
    public ArrayList<Subject> getSubject(){return subject;}
    public ArrayList<OBject> getObject(){return object;}
    public ArrayList<Verb> getVerb(){return verb;}
    public ArrayList<Adverb> getAdverb(){return adverb;}
    public void capitalize(){capital = true;}
    @Override
    public String toString(){return "Sentence";}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
    @Override
    public void verify(){
        for(Verb ver : verb){
//            System.out.println(ver.toString() + " " + ver.tense);
            for(Adverb adv : adverb){
//                System.out.println(adv.toString() + " " + adv.tense);
                if(adv.tense == null || adv.tense.equals("general") || adv.tense.equals("both")) continue;
                if(!adv.tense.equals(ver.tense)){
                    errors.add(new GrammarError.TenseConflict(line, ver.toString() + " and " + adv.toString()));
                }
            }
        }
        return;
    }
}
