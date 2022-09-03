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

    public Boolean checkCorrespondence(ArrayList<String> first, ArrayList<String> second){
        for(String subCount : first)
            if(second.contains(subCount))
                return true;
        return false;
    }
    public void usingTwoAdverbsOfTime(){
        for(Verb ver : verb){
            if(ver.tense.contains("present perfect") || ver.tense.contains("past perfect")){
                int counter = 0;
                for(Adverb adv : adverb){
                    if(adv.tense.contains("present perfect") || adv.tense.contains("past perfect"))
                        counter++;
                }
                if(counter >= 2){
                    errors.add(new GrammarError.Redundant(line, "Using more than one adverb for present tense"));
                }
            }
        }
    }
    public void checkTense(){
        for(Verb ver : verb){
//            System.out.println(ver.toString() + " " + ver.tense);
            if(ver.tense.isEmpty() || ver.tense.contains("wrong")) continue;
            for(Adverb adv : adverb){
//                System.out.println(adv.toString() + " " + adv.tense);
                if(adv.tense.isEmpty() || adv.tense.contains("general")) continue;
                if(!checkCorrespondence(adv.tense, ver.tense)){
                    errors.add(new GrammarError.TenseConflict(line, ver.toString() + " and " + adv.toString()));
                }
            }
        }
    }
    public void checkCount(){
        for(Verb ver: verb){
//            System.out.println(ver.toString() + ";;count;;" + ver.count);
            if(ver.count.isEmpty() || ver.count.contains("wrong")) continue;
            for(Subject sub: subject){
//                System.out.println(sub.toString() + ";;count;;" + sub.count);
                if(sub.count == null || sub.count.equals("wrong")) continue;
                if(!checkCorrespondence(new ArrayList<>(Arrays.asList(sub.count)), ver.count)){
                    errors.add(new GrammarError.CountConflict(line, sub.toString() + " and " + ver.toString()));
                }
            }
        }
    }
    @Override
    public String toString(){return "Sentence";}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
    @Override
    public void verify(){
        checkTense();
        checkCount();
        usingTwoAdverbsOfTime();
        return;
    }
}
