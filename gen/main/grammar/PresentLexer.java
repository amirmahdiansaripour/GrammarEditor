// Generated from C:/Users/amirmahdi/IdeaProjects/NLP_GrammarEditor/src/main/grammar\Present.g4 by ANTLR 4.9.2
package main.grammar;

    import main.ast.*;
    import main.error.*;
    import java.util.*;


    import main.ast.*;
    import main.error.*;
    import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PresentLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ENDPOINT=1, WORD=2, DOT=3, COMMA=4, SEMICOLON=5, SPACE=6, EXCLAMATION=7, 
		QUESTION=8, NEWLINE=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ENDPOINT", "WORD", "DOT", "COMMA", "SEMICOLON", "SPACE", "EXCLAMATION", 
			"QUESTION", "NEWLINE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'.'", "','", "';'", null, "'!'", "'?'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ENDPOINT", "WORD", "DOT", "COMMA", "SEMICOLON", "SPACE", "EXCLAMATION", 
			"QUESTION", "NEWLINE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public PresentLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Present.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13\60\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3"+
		"\2\3\2\5\2\31\n\2\3\2\5\2\34\n\2\3\3\6\3\37\n\3\r\3\16\3 \3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\2\2\13\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\3\2\5\4\2C\\c|\4\2\13\13\"\"\4\2\f\f\17\17\2\63"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3\30\3\2\2\2\5\36\3\2\2\2"+
		"\7\"\3\2\2\2\t$\3\2\2\2\13&\3\2\2\2\r(\3\2\2\2\17*\3\2\2\2\21,\3\2\2\2"+
		"\23.\3\2\2\2\25\31\5\7\4\2\26\31\5\17\b\2\27\31\5\21\t\2\30\25\3\2\2\2"+
		"\30\26\3\2\2\2\30\27\3\2\2\2\31\33\3\2\2\2\32\34\5\23\n\2\33\32\3\2\2"+
		"\2\33\34\3\2\2\2\34\4\3\2\2\2\35\37\t\2\2\2\36\35\3\2\2\2\37 \3\2\2\2"+
		" \36\3\2\2\2 !\3\2\2\2!\6\3\2\2\2\"#\7\60\2\2#\b\3\2\2\2$%\7.\2\2%\n\3"+
		"\2\2\2&\'\7=\2\2\'\f\3\2\2\2()\t\3\2\2)\16\3\2\2\2*+\7#\2\2+\20\3\2\2"+
		"\2,-\7A\2\2-\22\3\2\2\2./\t\4\2\2/\24\3\2\2\2\6\2\30\33 \2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}