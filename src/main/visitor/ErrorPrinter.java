package main.visitor;
import main.ast.*;
import main.ast.partOfSpeech.Adverb;
import main.error.*;
import java.util.*;

public class ErrorPrinter extends Visitor<Integer>{
    private int printErrors(astNode node){
        ArrayList<GrammarError> errors = node.getErrors();
        for (GrammarError ge : errors)
            System.err.println(ge.getMessage());
        return errors.size();
    }
    @Override
    public Integer visit(Text text) {
        int numOfErrors = printErrors(text);
        for (Sentence s : text.getSentences())
            numOfErrors += s.accept(this);
        return numOfErrors;
    }
    @Override
    public Integer visit(Sentence s){
        int numOfErrors = printErrors(s);
        for(Adverb adv: s.getAdverb())
            numOfErrors += adv.accept(this);
        return numOfErrors;
    }
    @Override
    public Integer visit(Adverb adv){
        return printErrors(adv);
    }
    @Override
    public Integer visit(Word wor){
        return printErrors(wor);
    }


}
