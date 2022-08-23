package main.visitor;
import main.ast.*;
public class ASTTree extends Visitor<Void>{
    @Override
    public Void visit(Text text){
        for(Sentence senc : text.getSentences())
            senc.accept(this);
        return  null;
    }
    @Override
    public Void visit(Sentence sentence){
        System.out.println(sentence.toString() + " " + sentence.getIndex() + " at line " + sentence.getLine());
        for(String partOfSpeech : sentence.getWords())
            System.out.println(partOfSpeech);
        System.out.print("\n");
        return null;
    }
}
