package main.visitor;
import main.ast.*;
import main.ast.partOfSpeech.*;
import main.error.*;
import java.io.IOException;

public class Analyzer extends Visitor<Void>{
    private Text text;
    public Analyzer(Text t){text = t;}
    @Override
    public Void visit(Text text){
        for(Sentence s : text.getSentences()){
            s.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Sentence s){
        for(Word sub : s.getSubject()){
            sub.accept(this);
        }
        for(Word obj : s.getObject()){
            obj.accept(this);
        }
        for(Word ver : s.getVerb()){
            ver.accept(this);
        }
        for(Word adv : s.getAdverb()){
            adv.accept(this);
        }
        return null;
    }

//    @Override
//    public Void visit(Adverb adv){
//        adv.verify();
//        return null;
//    }
//
//    @Override
//    public Void visit(Verb ver){
//        ver.verify();
//        return null;
//    }

    @Override
    public Void visit(Word wor){
        wor.verify();
        return null;
    }
}
