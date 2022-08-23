package main.visitor;
import main.ast.*;
import main.ast.partOfSpeech.Adverb;
import main.error.*;

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
        adv.addError(new GrammarError.WrongAdverb(adv.getLine(), adv.toString() + " isn't an adverb."));
        return null;
    }

}
