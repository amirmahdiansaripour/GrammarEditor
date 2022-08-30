package main.ast;
import main.visitor.*;
import main.GrammarCompiler;
import main.error.*;
import java.util.ArrayList;

public abstract class astNode {
    protected int line;
    protected ArrayList<GrammarError> errors = new ArrayList<GrammarError>();
    public ArrayList<GrammarError> getErrors(){
        return errors;
    }
    public void changeLine(int line_){line = line_;}
    public boolean hasError(){
        return !errors.isEmpty();
    }
    public int getLine(){
        return line;
    }
    public abstract String toString();
    public abstract void verify();
    public abstract <T> T accept(IVisitor<T> visitor);
}
