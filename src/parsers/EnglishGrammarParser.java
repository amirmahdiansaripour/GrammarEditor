// Generated from C:/Users/amirmahdi/IdeaProjects/NLP_GrammarEditor/src/main/grammar\EnglishGrammar.g4 by ANTLR 4.9.2
package parsers;

    import main.ast.*;
    import main.error.*;
    import java.util.*;


    import main.ast.*;
    import main.ast.partOfSpeech.*;
    import main.error.*;
    import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EnglishGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ENDPOINT=1, WORD=2, DOT=3, COMMA=4, SEMICOLON=5, SPACE=6, EXCLAMATION=7, 
		QUESTION=8, NEWLINE=9;
	public static final int
		RULE_englishGrammar = 0, RULE_text = 1, RULE_sentence = 2, RULE_partOfSpeech = 3, 
		RULE_subject = 4, RULE_object = 5, RULE_verb = 6, RULE_adverb = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"englishGrammar", "text", "sentence", "partOfSpeech", "subject", "object", 
			"verb", "adverb"
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

	@Override
	public String getGrammarFileName() { return "EnglishGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EnglishGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class EnglishGrammarContext extends ParserRuleContext {
		public Text whole;
		public TextContext t;
		public TerminalNode EOF() { return getToken(EnglishGrammarParser.EOF, 0); }
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(EnglishGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(EnglishGrammarParser.NEWLINE, i);
		}
		public EnglishGrammarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_englishGrammar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).enterEnglishGrammar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).exitEnglishGrammar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnglishGrammarVisitor ) return ((EnglishGrammarVisitor<? extends T>)visitor).visitEnglishGrammar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnglishGrammarContext englishGrammar() throws RecognitionException {
		EnglishGrammarContext _localctx = new EnglishGrammarContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_englishGrammar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(16);
				match(NEWLINE);
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22);
			((EnglishGrammarContext)_localctx).t = text();
			((EnglishGrammarContext)_localctx).whole =  ((EnglishGrammarContext)_localctx).t.textReturn;
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(24);
				match(NEWLINE);
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(30);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TextContext extends ParserRuleContext {
		public Text textReturn;
		public SentenceContext s;
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(EnglishGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(EnglishGrammarParser.NEWLINE, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(EnglishGrammarParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(EnglishGrammarParser.SPACE, i);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnglishGrammarVisitor ) return ((EnglishGrammarVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_text);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{

			        int line = 1;
			        int senIndex = 1;
			        ((TextContext)_localctx).textReturn =  new Text();
			        
			setState(42); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				((TextContext)_localctx).s = sentence(line, senIndex);
				_localctx.textReturn.addSentence(((TextContext)_localctx).s.s); senIndex++;
				setState(38); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(38);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case NEWLINE:
							{
							setState(35);
							match(NEWLINE);
							line++;
							}
							break;
						case SPACE:
							{
							setState(37);
							match(SPACE);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(40); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(44); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenceContext extends ParserRuleContext {
		public int line;
		public int index;
		public Sentence s;
		public TerminalNode ENDPOINT() { return getToken(EnglishGrammarParser.ENDPOINT, 0); }
		public SubjectContext subject() {
			return getRuleContext(SubjectContext.class,0);
		}
		public List<TerminalNode> SPACE() { return getTokens(EnglishGrammarParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(EnglishGrammarParser.SPACE, i);
		}
		public VerbContext verb() {
			return getRuleContext(VerbContext.class,0);
		}
		public AdverbContext adverb() {
			return getRuleContext(AdverbContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(EnglishGrammarParser.COMMA, 0); }
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public SentenceContext(ParserRuleContext parent, int invokingState, int line, int index) {
			super(parent, invokingState);
			this.line = line;
			this.index = index;
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).exitSentence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnglishGrammarVisitor ) return ((EnglishGrammarVisitor<? extends T>)visitor).visitSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenceContext sentence(int line,int index) throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState(), line, index);
		enterRule(_localctx, 4, RULE_sentence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			        ((SentenceContext)_localctx).s =  new Sentence();
			        _localctx.s.setLine(_localctx.line);
			        _localctx.s.setIndex(_localctx.index);
			        
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(47);
				subject(_localctx.s);
				setState(48);
				match(SPACE);
				setState(49);
				verb(_localctx.s);
				setState(52);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(50);
					match(SPACE);
					setState(51);
					object(_localctx.s);
					}
					break;
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(54);
					match(SPACE);
					setState(55);
					adverb(_localctx.s);
					}
				}

				}
				break;
			case 2:
				{
				setState(58);
				adverb(_localctx.s);
				setState(59);
				match(COMMA);
				setState(60);
				match(SPACE);
				setState(61);
				subject(_localctx.s);
				setState(62);
				match(SPACE);
				setState(63);
				verb(_localctx.s);
				setState(64);
				match(SPACE);
				setState(65);
				object(_localctx.s);
				}
				break;
			}
			setState(69);
			match(ENDPOINT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartOfSpeechContext extends ParserRuleContext {
		public Sentence s;
		public SubjectContext subject() {
			return getRuleContext(SubjectContext.class,0);
		}
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public VerbContext verb() {
			return getRuleContext(VerbContext.class,0);
		}
		public AdverbContext adverb() {
			return getRuleContext(AdverbContext.class,0);
		}
		public PartOfSpeechContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PartOfSpeechContext(ParserRuleContext parent, int invokingState, Sentence s) {
			super(parent, invokingState);
			this.s = s;
		}
		@Override public int getRuleIndex() { return RULE_partOfSpeech; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).enterPartOfSpeech(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).exitPartOfSpeech(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnglishGrammarVisitor ) return ((EnglishGrammarVisitor<? extends T>)visitor).visitPartOfSpeech(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartOfSpeechContext partOfSpeech(Sentence s) throws RecognitionException {
		PartOfSpeechContext _localctx = new PartOfSpeechContext(_ctx, getState(), s);
		enterRule(_localctx, 6, RULE_partOfSpeech);
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				subject(s);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				object(s);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				verb(s);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				adverb(s);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubjectContext extends ParserRuleContext {
		public Sentence sentnce;
		public Token WORD;
		public TerminalNode WORD() { return getToken(EnglishGrammarParser.WORD, 0); }
		public SubjectContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public SubjectContext(ParserRuleContext parent, int invokingState, Sentence sentnce) {
			super(parent, invokingState);
			this.sentnce = sentnce;
		}
		@Override public int getRuleIndex() { return RULE_subject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).enterSubject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).exitSubject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnglishGrammarVisitor ) return ((EnglishGrammarVisitor<? extends T>)visitor).visitSubject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubjectContext subject(Sentence sentnce) throws RecognitionException {
		SubjectContext _localctx = new SubjectContext(_ctx, getState(), sentnce);
		enterRule(_localctx, 8, RULE_subject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			((SubjectContext)_localctx).WORD = match(WORD);
			_localctx.sentnce.addSubject((((SubjectContext)_localctx).WORD!=null?((SubjectContext)_localctx).WORD.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectContext extends ParserRuleContext {
		public Sentence sentnce;
		public Token WORD;
		public TerminalNode WORD() { return getToken(EnglishGrammarParser.WORD, 0); }
		public ObjectContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ObjectContext(ParserRuleContext parent, int invokingState, Sentence sentnce) {
			super(parent, invokingState);
			this.sentnce = sentnce;
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).exitObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnglishGrammarVisitor ) return ((EnglishGrammarVisitor<? extends T>)visitor).visitObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectContext object(Sentence sentnce) throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState(), sentnce);
		enterRule(_localctx, 10, RULE_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			((ObjectContext)_localctx).WORD = match(WORD);
			_localctx.sentnce.addObject((((ObjectContext)_localctx).WORD!=null?((ObjectContext)_localctx).WORD.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VerbContext extends ParserRuleContext {
		public Sentence sentnce;
		public Token WORD;
		public TerminalNode WORD() { return getToken(EnglishGrammarParser.WORD, 0); }
		public VerbContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public VerbContext(ParserRuleContext parent, int invokingState, Sentence sentnce) {
			super(parent, invokingState);
			this.sentnce = sentnce;
		}
		@Override public int getRuleIndex() { return RULE_verb; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).enterVerb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).exitVerb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnglishGrammarVisitor ) return ((EnglishGrammarVisitor<? extends T>)visitor).visitVerb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VerbContext verb(Sentence sentnce) throws RecognitionException {
		VerbContext _localctx = new VerbContext(_ctx, getState(), sentnce);
		enterRule(_localctx, 12, RULE_verb);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			((VerbContext)_localctx).WORD = match(WORD);
			_localctx.sentnce.addVerb((((VerbContext)_localctx).WORD!=null?((VerbContext)_localctx).WORD.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdverbContext extends ParserRuleContext {
		public Sentence s;
		public Adverb adv;
		public Token WORD;
		public TerminalNode WORD() { return getToken(EnglishGrammarParser.WORD, 0); }
		public AdverbContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AdverbContext(ParserRuleContext parent, int invokingState, Sentence s) {
			super(parent, invokingState);
			this.s = s;
		}
		@Override public int getRuleIndex() { return RULE_adverb; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).enterAdverb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).exitAdverb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnglishGrammarVisitor ) return ((EnglishGrammarVisitor<? extends T>)visitor).visitAdverb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdverbContext adverb(Sentence s) throws RecognitionException {
		AdverbContext _localctx = new AdverbContext(_ctx, getState(), s);
		enterRule(_localctx, 14, RULE_adverb);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			((AdverbContext)_localctx).WORD = match(WORD);

			    ((AdverbContext)_localctx).adv =  new Adverb((((AdverbContext)_localctx).WORD!=null?((AdverbContext)_localctx).WORD.getText():null));
			    _localctx.adv.setLine(_localctx.s.getLine());
			    _localctx.adv.setIndex(_localctx.s.getIndex());
			    _localctx.s.addAdverb(_localctx.adv);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\13\\\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\7\2\24\n\2\f"+
		"\2\16\2\27\13\2\3\2\3\2\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\6\3)\n\3\r\3\16\3*\6\3-\n\3\r\3\16\3.\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\5\4\67\n\4\3\4\3\4\5\4;\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4F\n\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5N\n\5\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\2\2^\2\25\3\2\2"+
		"\2\4\"\3\2\2\2\6\60\3\2\2\2\bM\3\2\2\2\nO\3\2\2\2\fR\3\2\2\2\16U\3\2\2"+
		"\2\20X\3\2\2\2\22\24\7\13\2\2\23\22\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2"+
		"\2\25\26\3\2\2\2\26\30\3\2\2\2\27\25\3\2\2\2\30\31\5\4\3\2\31\35\b\2\1"+
		"\2\32\34\7\13\2\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2"+
		"\2\2\36 \3\2\2\2\37\35\3\2\2\2 !\7\2\2\3!\3\3\2\2\2\",\b\3\1\2#$\5\6\4"+
		"\2$(\b\3\1\2%&\7\13\2\2&)\b\3\1\2\')\7\b\2\2(%\3\2\2\2(\'\3\2\2\2)*\3"+
		"\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,#\3\2\2\2-.\3\2\2\2.,\3\2\2\2./\3"+
		"\2\2\2/\5\3\2\2\2\60E\b\4\1\2\61\62\5\n\6\2\62\63\7\b\2\2\63\66\5\16\b"+
		"\2\64\65\7\b\2\2\65\67\5\f\7\2\66\64\3\2\2\2\66\67\3\2\2\2\67:\3\2\2\2"+
		"89\7\b\2\29;\5\20\t\2:8\3\2\2\2:;\3\2\2\2;F\3\2\2\2<=\5\20\t\2=>\7\6\2"+
		"\2>?\7\b\2\2?@\5\n\6\2@A\7\b\2\2AB\5\16\b\2BC\7\b\2\2CD\5\f\7\2DF\3\2"+
		"\2\2E\61\3\2\2\2E<\3\2\2\2FG\3\2\2\2GH\7\3\2\2H\7\3\2\2\2IN\5\n\6\2JN"+
		"\5\f\7\2KN\5\16\b\2LN\5\20\t\2MI\3\2\2\2MJ\3\2\2\2MK\3\2\2\2ML\3\2\2\2"+
		"N\t\3\2\2\2OP\7\4\2\2PQ\b\6\1\2Q\13\3\2\2\2RS\7\4\2\2ST\b\7\1\2T\r\3\2"+
		"\2\2UV\7\4\2\2VW\b\b\1\2W\17\3\2\2\2XY\7\4\2\2YZ\b\t\1\2Z\21\3\2\2\2\13"+
		"\25\35(*.\66:EM";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}