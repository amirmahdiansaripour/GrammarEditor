package main.visitor;
import main.ast.*;
import main.ast.partOfSpeech.*;

import java.util.ArrayList;

public class ASTTree extends Visitor<Void>{
    @Override
    public Void visit(Text text){
        for(Sentence senc : text.getSentences())
            senc.accept(this);
        return  null;
    }
    @Override
    public Void visit(Sentence sentence){
        if (sentence.hasError())
            return null;
        if(sentence.getSubject() != null && sentence.getSubject().hasError())
            return null;
        if(sentence.getObject() != null && sentence.getObject().hasError())
            return null;
        if(sentence.getVerb().hasError())
            return null;
        for(Adverb adv : sentence.getAdverb())
            if(adv.hasError())
                return null;
        System.out.println(sentence.toString() + " " + sentence.getIndex() + " at line " + sentence.getLine());
        for(ArrayList<String> pairs : sentence.getWords())
            System.out.println(pairs.get(0) + pairs.get(1));
        System.out.print("\n");
        return null;
    }
}
