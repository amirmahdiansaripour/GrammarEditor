// Generated from C:/Users/amirmahdi/IdeaProjects/NLP/src/main/grammar\EnglishGrammar.g4 by ANTLR 4.9.2
package parsers;

    import main.ast.*;
    imort main.error.*;
    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EnglishGrammarParser}.
 */
public interface EnglishGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EnglishGrammarParser#englishGrammar}.
	 * @param ctx the parse tree
	 */
	void enterEnglishGrammar(EnglishGrammarParser.EnglishGrammarContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnglishGrammarParser#englishGrammar}.
	 * @param ctx the parse tree
	 */
	void exitEnglishGrammar(EnglishGrammarParser.EnglishGrammarContext ctx);
}