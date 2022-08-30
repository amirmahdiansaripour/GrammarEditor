// Generated from C:/Users/amirmahdi/IdeaProjects/NLP_GrammarEditor/src/main/grammar\EnglishGrammar.g4 by ANTLR 4.9.2
package parsers;

    import main.ast.*;
    import main.error.*;
    import java.util.*;


    import main.ast.*;
    import main.ast.partOfSpeech.*;
    import main.error.*;
    import java.util.*;
    import java.io.*;


    import main.ast.*;
    import main.error.*;
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
	/**
	 * Enter a parse tree produced by {@link EnglishGrammarParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(EnglishGrammarParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnglishGrammarParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(EnglishGrammarParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnglishGrammarParser#firstSentence}.
	 * @param ctx the parse tree
	 */
	void enterFirstSentence(EnglishGrammarParser.FirstSentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnglishGrammarParser#firstSentence}.
	 * @param ctx the parse tree
	 */
	void exitFirstSentence(EnglishGrammarParser.FirstSentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnglishGrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(EnglishGrammarParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnglishGrammarParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(EnglishGrammarParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnglishGrammarParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterStructure(EnglishGrammarParser.StructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnglishGrammarParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitStructure(EnglishGrammarParser.StructureContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnglishGrammarParser#partOfSpeech}.
	 * @param ctx the parse tree
	 */
	void enterPartOfSpeech(EnglishGrammarParser.PartOfSpeechContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnglishGrammarParser#partOfSpeech}.
	 * @param ctx the parse tree
	 */
	void exitPartOfSpeech(EnglishGrammarParser.PartOfSpeechContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnglishGrammarParser#subject}.
	 * @param ctx the parse tree
	 */
	void enterSubject(EnglishGrammarParser.SubjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnglishGrammarParser#subject}.
	 * @param ctx the parse tree
	 */
	void exitSubject(EnglishGrammarParser.SubjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnglishGrammarParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(EnglishGrammarParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnglishGrammarParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(EnglishGrammarParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnglishGrammarParser#verb}.
	 * @param ctx the parse tree
	 */
	void enterVerb(EnglishGrammarParser.VerbContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnglishGrammarParser#verb}.
	 * @param ctx the parse tree
	 */
	void exitVerb(EnglishGrammarParser.VerbContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnglishGrammarParser#adverb}.
	 * @param ctx the parse tree
	 */
	void enterAdverb(EnglishGrammarParser.AdverbContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnglishGrammarParser#adverb}.
	 * @param ctx the parse tree
	 */
	void exitAdverb(EnglishGrammarParser.AdverbContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnglishGrammarParser#endpoint}.
	 * @param ctx the parse tree
	 */
	void enterEndpoint(EnglishGrammarParser.EndpointContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnglishGrammarParser#endpoint}.
	 * @param ctx the parse tree
	 */
	void exitEndpoint(EnglishGrammarParser.EndpointContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnglishGrammarParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(EnglishGrammarParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnglishGrammarParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(EnglishGrammarParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnglishGrammarParser#present}.
	 * @param ctx the parse tree
	 */
	void enterPresent(EnglishGrammarParser.PresentContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnglishGrammarParser#present}.
	 * @param ctx the parse tree
	 */
	void exitPresent(EnglishGrammarParser.PresentContext ctx);
}