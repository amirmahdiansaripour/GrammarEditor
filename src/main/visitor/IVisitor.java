package main.visitor;
import main.ast.*;
import main.ast.partOfSpeech.Adverb;

public interface IVisitor<T> {
    T visit(Text text);
    T visit(Sentence sentence);
    T visit(Adverb adv);
}
