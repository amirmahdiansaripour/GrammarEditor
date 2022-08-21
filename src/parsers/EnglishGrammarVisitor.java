// Generated from C:/Users/amirmahdi/IdeaProjects/NLP/src/main/grammar\EnglishGrammar.g4 by ANTLR 4.9.2
package parsers;

    import main.ast.*;
    imort main.error.*;
    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EnglishGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EnglishGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EnglishGrammarParser#englishGrammar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnglishGrammar(EnglishGrammarParser.EnglishGrammarContext ctx);
}