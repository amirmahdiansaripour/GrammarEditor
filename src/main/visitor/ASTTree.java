package main.visitor;
import main.ast.*;
public class ASTTree extends Visitor<Void>{
    public void messagePrinter(int line, String message){
        System.out.println("Line " + line + ": " + message);
    }
    @Override
    public Void visit(Text text){
//        messagePrinter(text.getLine(), text.toString());
        for(Sentence senc : text.getSentences())
            senc.accept(this);
        return  null;
    }
    @Override
    public Void visit(Sentence sentence){
        messagePrinter(sentence.getLine(), sentence.toString());
        return null;
    }
}
