package main.visitor;
import main.ast.*;
public class Visitor<T> implements IVisitor<T> {
    @Override
    public T visit(Text text){return null;}
    @Override
    public T visit(Sentence sentence){return null;}
}
