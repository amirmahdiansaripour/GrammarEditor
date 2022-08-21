// Generated from C:/Users/amirmahdi/IdeaProjects/NLP/src/main/grammar\EnglishGrammar.g4 by ANTLR 4.9.2
package parsers;

    import main.ast.*;
    imort main.error.*;
    import java.util.*;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link EnglishGrammarVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class EnglishGrammarBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements EnglishGrammarVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitEnglishGrammar(EnglishGrammarParser.EnglishGrammarContext ctx) { return visitChildren(ctx); }
}