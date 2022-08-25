package main.visitor;
import main.ast.*;
import main.ast.partOfSpeech.Adverb;
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

        for(Adverb adv : s.getAdverb()){
            adv.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Adverb adv){
        GrammarError result = adv.verify();
        if(result != null)
            adv.addError(result);
        return null;
    }

    @Override
    public Void visit(Word wor){
        GrammarError result = wor.verify();
        if(result != null)
            wor.addError(result);
        return null;
    }
}
