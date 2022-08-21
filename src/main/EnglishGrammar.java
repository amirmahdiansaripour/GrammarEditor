package main;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import java.io.IOException;


public class EnglishGrammar {
    public static void main(String[] args) throws IOException {
        CharStream fileName = CharStreams.fromFileName(args[0]);
        GrammarCompiler grammarCompiler = new GrammarCompiler();
        grammarCompiler.compile(fileName);
    }
}
