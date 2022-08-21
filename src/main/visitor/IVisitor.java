package main.visitor;
import main.ast.*;

public interface IVisitor<T> {
    T visit(Text text);
    T visit(Sentence sentence);
}
