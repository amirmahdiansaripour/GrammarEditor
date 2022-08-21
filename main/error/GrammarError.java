package main.error;

public class GrammarError extends Exception{
    protected int line;
    protected String message;

    public GrammarError(int line_, String message_){
        line = line_;
        message = message_;
    }

    public String getMessage(){return "Line " + line + ": " + message;}
}
