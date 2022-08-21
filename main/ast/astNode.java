package main.ast;
import main.visitor.*;
import main.GrammarCompiler;
import main.error.*;
import java.util.ArrayList;

public abstract class astNode {
    private int line;
    private ArrayList<GrammarError> errors = new ArrayList<GrammarError>();
    public ArrayList<GrammarError> getErrors(){
        ArrayList<GrammarError> temp = errors;
        errors = new ArrayList<GrammarError>();
        return temp;
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

    public abstract <T> T accept(IVisitor<T> visitor);
}
