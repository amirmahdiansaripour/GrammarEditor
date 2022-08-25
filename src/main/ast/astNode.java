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
    public void addError(GrammarError error){
        errors.add(error);
    }
    public boolean hasError(){
        return !errors.isEmpty();
    }
    public int getLine(){
        return line;
    }
    public void setLine(int line_){
        line = line_;
    }
    public abstract String toString();
    public abstract void verify();
    public abstract <T> T accept(IVisitor<T> visitor);
}
