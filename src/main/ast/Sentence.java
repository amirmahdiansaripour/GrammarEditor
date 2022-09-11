package main.ast;

import main.ast.partOfSpeech.*;
import main.error.GrammarError;
import main.visitor.IVisitor;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Sentence extends astNode {
    private int index;
    private Subject subject;
    private OBject object;
    private final ArrayList<Adverb> adverb;
    private Verb verb;
    private final ArrayList<ArrayList<String>> words;
    private Boolean capital;
    public Sentence(int line_){
        capital = false;
        words = new ArrayList<ArrayList<String>>();
        adverb = new ArrayList<Adverb>();
        line = line_;
    }
    public void setIndex(int index){this.index = index;}
    public int getIndex(){return this.index;}
    public void setSubject(Subject subject){
        words.add(new ArrayList<String>(){{add("Subject: "); add(subject.toString());}});
        this.subject = subject;
    }
    public void setObject(OBject object){
        words.add(new ArrayList<String>(){{add("Object: "); add(object.toString());}});
        this.object = object;
    }
    public void setVerb(Verb ver){
        words.add(new ArrayList<String>(){{add("Verb: "); add(ver.toString());}});
        this.verb = ver;
    }
    public void addAdverb(Adverb adverb){
        words.add(new ArrayList<String>(){{add("Adverb: "); add(adverb.toString());}});
        this.adverb.add(adverb);
    }
    public ArrayList<ArrayList<String>> getWords(){return words;}
    public Subject getSubject(){return subject;}
    public OBject getObject(){return object;}
    public Verb getVerb(){return verb;}
    public ArrayList<Adverb> getAdverb(){return adverb;}
    public void capitalize(){capital = true;}

    public Boolean checkCorrespondence(ArrayList<String> first, ArrayList<String> second){
        for(String subCount : first)
            if(second.contains(subCount))
                return true;
        return false;
    }
    public Boolean isCapital(){return capital;}
    public void usingTwoAdverbsOfTime(){
//        System.out.println("num of adverbs : " + verb.get(0).tense);
        if(verb.tense.contains("present perfect") || verb.tense.contains("past perfect")){
            int counter = 0;
            ArrayList<String> redundantAdverbs = new ArrayList<>();
            for(Adverb adv : adverb){
                if(adv.tense.contains("present perfect") || adv.tense.contains("past perfect")) {
                    counter++;
                    redundantAdverbs.add(adv.toString());
                }
            }
            if(counter >= 2){
                errors.add(new GrammarError.Redundant(line, "Using more than one adverb " +
                        redundantAdverbs + " for perfect tenses"));
            }
        }
    }
    public void checkTense(){
//        System.out.println(verb.toString() + " " + verb.tense);
        if(verb.tense.isEmpty() || verb.tense.contains("wrong")) return;
        for(Adverb adv : adverb){
//            System.out.println(adv.toString() + " " + adv.tense);
            if(adv.tense.isEmpty() || adv.tense.contains("general")) continue;
            if(!checkCorrespondence(adv.tense, verb.tense)){
                errors.add(new GrammarError.TenseConflict(line, "[" + verb.toString() + "]"+ " and " + "[" + adv.toString() + "]" ));
            }
        }
    }
    public void checkCount(){
//        System.out.println(verb.toString() + ";;count;;" + verb.count);
        if(verb.count.isEmpty() || verb.count.contains("wrong")) return;
//        System.out.println(subject.toString() + ";;count;;" + subject.count);
        if(subject.count == null || subject.count.equals("wrong")) return;
        if(!checkCorrespondence(new ArrayList<>(Arrays.asList(subject.count)), verb.count)){
            errors.add(new GrammarError.CountConflict(line, subject.toString() + " and " + verb.toString()));
        }
    }
    public void checkPreposition(String prep, Boolean cap){
        if(!cap && Character.isUpperCase(prep.charAt(0)))
            errors.add(new GrammarError.WordShouldBeLittle(line, prep));

        else if(cap && Character.isLowerCase(prep.charAt(0)))
            errors.add(new GrammarError.WordShouldBeCapital(line, prep));
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
