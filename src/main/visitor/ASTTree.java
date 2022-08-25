package main.visitor;
import main.ast.*;

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
        System.out.println(sentence.toString() + " " + sentence.getIndex() + " at line " + sentence.getLine());
        for(ArrayList<String> pairs : sentence.getWords())
            System.out.println(pairs.get(0) + pairs.get(1));
        System.out.print("\n");
        return null;
    }
}
