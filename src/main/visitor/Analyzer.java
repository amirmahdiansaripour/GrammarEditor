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
        for(Verb ver : s.getVerb()){
            ver.accept(this);
        }
        for(Adverb adv : s.getAdverb()){
            adv.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Adverb adv){
        adv.verify();
        return null;
    }

    @Override
    public Void visit(Verb ver){
        ver.verify();
        return null;
    }

//    @Override
//    public Void visit(Word wor){
//        wor.verify();
//        return null;
//    }
}
