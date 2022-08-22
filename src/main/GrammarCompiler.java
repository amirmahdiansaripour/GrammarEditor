package main;

import parsers.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import main.ast.*;
import main.visitor.*;

public class GrammarCompiler {
    public void compile(CharStream programName){
        EnglishGrammarLexer lexer = new EnglishGrammarLexer(programName);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        EnglishGrammarParser parser = new EnglishGrammarParser(tokenStream);

        Text text = parser.englishGrammar().whole;
//        NameAnalyzerHandler nameAnalyzerHandler = new NameAnalyzerHandler(program);
//
//        nameAnalyzerHandler.analyze();
//
//        ErrorPrinter errorPrinter = new ErrorPrinter();
//        int numOfErrors = program.accept(errorPrinter);
        ASTTree astTreePrinter = new ASTTree();
        text.accept(astTreePrinter);
//        if(numOfErrors == 0)
//            program.accept(astTreePrinter);
        return;
    }

}
