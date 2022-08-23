package main.ast.partOfSpeech;
import main.ast.*;
import main.visitor.*;

public class Adverb extends Sentence{
    private String text;
    public Adverb(String t){
        text = t;
    }
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    @Override
    public String toString() {
        return text;
    }
}
