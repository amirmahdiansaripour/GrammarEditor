package main.visitor;
import main.ast.*;
import main.ast.partOfSpeech.Adverb;

public class Visitor<T> implements IVisitor<T> {
    @Override
    public T visit(Text text){return null;}
    @Override
    public T visit(Sentence sentence){return null;}
    @Override
    public T visit(Adverb adv){return null;}
    @Override
    public T visit(Word word){return null;}
}
