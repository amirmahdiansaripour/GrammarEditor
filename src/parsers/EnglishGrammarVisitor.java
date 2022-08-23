// Generated from C:/Users/amirmahdi/IdeaProjects/NLP_GrammarEditor/src/main/grammar\EnglishGrammar.g4 by ANTLR 4.9.2
package parsers;

    import main.ast.*;
    import main.error.*;
    import java.util.*;


    import main.ast.*;
    import main.ast.partOfSpeech.*;
    import main.error.*;
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
	/**
	 * Visit a parse tree produced by {@link EnglishGrammarParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(EnglishGrammarParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnglishGrammarParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(EnglishGrammarParser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnglishGrammarParser#partOfSpeech}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartOfSpeech(EnglishGrammarParser.PartOfSpeechContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnglishGrammarParser#subject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubject(EnglishGrammarParser.SubjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnglishGrammarParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(EnglishGrammarParser.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnglishGrammarParser#verb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerb(EnglishGrammarParser.VerbContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnglishGrammarParser#adverb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdverb(EnglishGrammarParser.AdverbContext ctx);
}