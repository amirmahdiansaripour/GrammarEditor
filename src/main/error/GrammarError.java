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

    public static class TenseConflict extends GrammarError{
        public TenseConflict(int line_, String message_){super(line_, "Tenses of " + message_ + " don't correspond.");}
    }

    public static class CountConflict extends GrammarError{
        public CountConflict(int line_, String message_){super(line_, "Counts of " + message_ + " don't correspond.");}
    }

    public static class IsntCorrect extends GrammarError{
        public IsntCorrect(int line_, String message_){super(line_, "[" + message_ + "] isn't correct.");}
    }
    public static class Redundant extends GrammarError{
        public Redundant(int line_, String message_){super(line_, message_ + " is redundant.");}
    }
    public static class BeSingular extends GrammarError{
        public BeSingular(int line_, String message_){super(line_, "[" + message_ + "] should be a singular noun.");}
    }
    public static class BePlural extends GrammarError{
        public BePlural(int line_, String message_){super(line_, "[" + message_ + "] should be a plural noun.");}
    }



}
