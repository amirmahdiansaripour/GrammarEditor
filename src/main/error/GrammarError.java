package main.error;

import main.ast.Word;

public class GrammarError extends Exception{
    protected int line;
    protected String message;

    public GrammarError(int line_, String message_){
        line = line_;
        message = message_;
    }
    public String getMessage(){return "Line " + line + ": " + message;}

    public static class WrongAdverb extends GrammarError{
        public WrongAdverb(int line_, String message_){
            super(line_, message_ + " isn't an adverb.");
        }
    }

    public static class WordShouldBeCapital extends GrammarError{
        public WordShouldBeCapital(int line_, String message_){
            super(line_, message_ + " should be capital letter.");
        }
    }


    public static class WordShouldBeLittle extends GrammarError{
        public WordShouldBeLittle(int line_, String message_){
            super(line_, message_ + " should be in little case.");
        }
    }

}
