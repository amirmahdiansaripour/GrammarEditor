package main.visitor;
import main.ast.*;
import main.ast.partOfSpeech.Adverb;
import main.ast.partOfSpeech.Verb;
import main.error.*;
import java.util.*;

public class ErrorPrinter extends Visitor<Void>{
    private void printErrors(astNode node){
        ArrayList<GrammarError> errors = node.getErrors();
        for (GrammarError ge : errors)
            System.err.println(ge.getMessage());
    }
    @Override
    public Void visit(Text text) {
        printErrors(text);
        for (Sentence s : text.getSentences())
            s.accept(this);
        return null;
    }
    @Override
    public Void visit(Sentence s){
        if(s.getSubject() != null) s.getSubject().accept(this);
        if(s.getObject() != null) s.getObject().accept(this);
        s.getVerb().accept(this);
        for(Word adv: s.getAdverb())
            adv.accept(this);
        printErrors(s);
        return null;
    }
//    @Override
//    public Void visit(Adverb adv){
//         printErrors(adv);
//         return null;
//    }
//    @Override
//    public Void visit(Verb ver){
//        printErrors(ver);
//        return null;
//    }
    @Override
    public Void visit(Word wor){
        printErrors(wor);
        return null;
    }
}
