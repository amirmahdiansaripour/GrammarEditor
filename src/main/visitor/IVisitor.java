package main.visitor;
import main.ast.*;
import main.ast.partOfSpeech.Adverb;
import main.ast.partOfSpeech.Verb;

public interface IVisitor<T> {
    T visit(Text text);
    T visit(Sentence sentence);
//    T visit(Adverb adv);
//    T visit(Verb ver);
    T visit(Word wor);
}
