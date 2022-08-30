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
		WORD=1, DOT=2, COMMA=3, SEMICOLON=4, SPACE=5, EXCLAMATION=6, QUESTION=7, 
		NEWLINE=8;
	public static final int
		RULE_englishGrammar = 0, RULE_text = 1, RULE_firstSentence = 2, RULE_sentence = 3, 
		RULE_structure = 4, RULE_partOfSpeech = 5, RULE_subject = 6, RULE_object = 7, 
		RULE_verb = 8, RULE_adverb = 9, RULE_endpoint = 10, RULE_conjunction = 11, 
		RULE_present = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"englishGrammar", "text", "firstSentence", "sentence", "structure", "partOfSpeech", 
			"subject", "object", "verb", "adverb", "endpoint", "conjunction", "present"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'.'", "','", "';'", null, "'!'", "'?'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WORD", "DOT", "COMMA", "SEMICOLON", "SPACE", "EXCLAMATION", "QUESTION", 
			"NEWLINE"
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
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public EndpointContext endpoint() {
			return getRuleContext(EndpointContext.class,0);
		}
		public TerminalNode EOF() { return getToken(EnglishGrammarParser.EOF, 0); }
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
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(26);
				match(NEWLINE);
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
			((EnglishGrammarContext)_localctx).t = text();
			((EnglishGrammarContext)_localctx).whole =  ((EnglishGrammarContext)_localctx).t.textReturn;
			{
			setState(34);
			endpoint();
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(35);
				match(NEWLINE);
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			match(EOF);
			}
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
		public FirstSentenceContext fs;
		public SentenceContext s;
		public FirstSentenceContext firstSentence() {
			return getRuleContext(FirstSentenceContext.class,0);
		}
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{

			        int line = 1;
			        int senIndex = 1;
			        ((TextContext)_localctx).textReturn =  new Text();
			        
			{
			setState(44);
			((TextContext)_localctx).fs = firstSentence(line, senIndex);
			_localctx.textReturn.addSentence(((TextContext)_localctx).fs.s); senIndex++;
			}
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(47);
					((TextContext)_localctx).s = sentence(line, senIndex);
					_localctx.textReturn.addSentence(((TextContext)_localctx).s.s); senIndex++; line = ((TextContext)_localctx).s.indexRet;
					}
					} 
				}
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
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

	public static class FirstSentenceContext extends ParserRuleContext {
		public int line;
		public int index;
		public Sentence s;
		public StructureContext structure() {
			return getRuleContext(StructureContext.class,0);
		}
		public FirstSentenceContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FirstSentenceContext(ParserRuleContext parent, int invokingState, int line, int index) {
			super(parent, invokingState);
			this.line = line;
			this.index = index;
		}
		@Override public int getRuleIndex() { return RULE_firstSentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).enterFirstSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).exitFirstSentence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnglishGrammarVisitor ) return ((EnglishGrammarVisitor<? extends T>)visitor).visitFirstSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FirstSentenceContext firstSentence(int line,int index) throws RecognitionException {
		FirstSentenceContext _localctx = new FirstSentenceContext(_ctx, getState(), line, index);
		enterRule(_localctx, 4, RULE_firstSentence);
		try {
			enterOuterAlt(_localctx, 1);
			{

			    ((FirstSentenceContext)_localctx).s =  new Sentence();
			    _localctx.s.setLine(_localctx.line);
			    _localctx.s.setIndex(_localctx.index);
			    _localctx.s.capitalize();
			    
			setState(56);
			structure(_localctx.s);
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
		public int indexRet;
		public StructureContext structure() {
			return getRuleContext(StructureContext.class,0);
		}
		public EndpointContext endpoint() {
			return getRuleContext(EndpointContext.class,0);
		}
		public ConjunctionContext conjunction() {
			return getRuleContext(ConjunctionContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(EnglishGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(EnglishGrammarParser.NEWLINE, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(EnglishGrammarParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(EnglishGrammarParser.SPACE, i);
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
		enterRule(_localctx, 6, RULE_sentence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			        ((SentenceContext)_localctx).s =  new Sentence();
			        _localctx.s.setIndex(_localctx.index);
			        
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
			case EXCLAMATION:
			case QUESTION:
				{
				setState(59);
				endpoint();
				_localctx.s.capitalize();
				}
				break;
			case COMMA:
			case SEMICOLON:
				{
				setState(62);
				conjunction();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(69);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NEWLINE:
					{
					setState(65);
					match(NEWLINE);
					((SentenceContext)_localctx).indexRet =  _localctx.line + 1;
					}
					break;
				case SPACE:
					{
					setState(67);
					match(SPACE);
					((SentenceContext)_localctx).indexRet =  _localctx.line;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SPACE || _la==NEWLINE );
			_localctx.s.setLine(_localctx.indexRet);
			setState(74);
			structure(_localctx.s);
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

	public static class StructureContext extends ParserRuleContext {
		public Sentence s;
		public PresentContext present() {
			return getRuleContext(PresentContext.class,0);
		}
		public StructureContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public StructureContext(ParserRuleContext parent, int invokingState, Sentence s) {
			super(parent, invokingState);
			this.s = s;
		}
		@Override public int getRuleIndex() { return RULE_structure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).enterStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).exitStructure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnglishGrammarVisitor ) return ((EnglishGrammarVisitor<? extends T>)visitor).visitStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructureContext structure(Sentence s) throws RecognitionException {
		StructureContext _localctx = new StructureContext(_ctx, getState(), s);
		enterRule(_localctx, 8, RULE_structure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(76);
			present(_localctx.s);
			}
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
		public Boolean cap;
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
		public PartOfSpeechContext(ParserRuleContext parent, int invokingState, Sentence s, Boolean cap) {
			super(parent, invokingState);
			this.s = s;
			this.cap = cap;
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

	public final PartOfSpeechContext partOfSpeech(Sentence s,Boolean cap) throws RecognitionException {
		PartOfSpeechContext _localctx = new PartOfSpeechContext(_ctx, getState(), s, cap);
		enterRule(_localctx, 10, RULE_partOfSpeech);
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				subject(s, cap);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				object(s);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				verb(s);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				adverb(s, cap);
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
		public Boolean cap;
		public Subject sub;
		public Token WORD;
		public TerminalNode WORD() { return getToken(EnglishGrammarParser.WORD, 0); }
		public SubjectContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public SubjectContext(ParserRuleContext parent, int invokingState, Sentence sentnce, Boolean cap) {
			super(parent, invokingState);
			this.sentnce = sentnce;
			this.cap = cap;
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

	public final SubjectContext subject(Sentence sentnce,Boolean cap) throws RecognitionException {
		SubjectContext _localctx = new SubjectContext(_ctx, getState(), sentnce, cap);
		enterRule(_localctx, 12, RULE_subject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
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
		enterRule(_localctx, 14, RULE_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
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
		public Sentence s;
		public Verb ver;
		public Token WORD;
		public TerminalNode WORD() { return getToken(EnglishGrammarParser.WORD, 0); }
		public VerbContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public VerbContext(ParserRuleContext parent, int invokingState, Sentence s) {
			super(parent, invokingState);
			this.s = s;
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

	public final VerbContext verb(Sentence s) throws RecognitionException {
		VerbContext _localctx = new VerbContext(_ctx, getState(), s);
		enterRule(_localctx, 16, RULE_verb);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			((VerbContext)_localctx).WORD = match(WORD);

			        try{
			            ((VerbContext)_localctx).ver =  new Verb((((VerbContext)_localctx).WORD!=null?((VerbContext)_localctx).WORD.getText():null));
			            _localctx.ver.setLine(_localctx.s.getLine());
			            _localctx.s.addVerb(_localctx.ver);
			        }
			        catch(IOException e){
			            System.err.println("Verbs' data not Found!");
			            System.exit(0);
			        }
			     
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
		public Boolean capital;
		public Adverb adv;
		public Token WORD;
		public TerminalNode WORD() { return getToken(EnglishGrammarParser.WORD, 0); }
		public AdverbContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AdverbContext(ParserRuleContext parent, int invokingState, Sentence s, Boolean capital) {
			super(parent, invokingState);
			this.s = s;
			this.capital = capital;
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

	public final AdverbContext adverb(Sentence s,Boolean capital) throws RecognitionException {
		AdverbContext _localctx = new AdverbContext(_ctx, getState(), s, capital);
		enterRule(_localctx, 18, RULE_adverb);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			((AdverbContext)_localctx).WORD = match(WORD);

			        try{
			            ((AdverbContext)_localctx).adv =  new Adverb((((AdverbContext)_localctx).WORD!=null?((AdverbContext)_localctx).WORD.getText():null), capital);
			            _localctx.adv.setLine(_localctx.s.getLine());
			            _localctx.s.addAdverb(_localctx.adv);
			        }
			        catch(IOException e){
			            System.err.println("Adverbs' data not Found!");
			            System.exit(0);
			        }
			    
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

	public static class EndpointContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(EnglishGrammarParser.DOT, 0); }
		public TerminalNode EXCLAMATION() { return getToken(EnglishGrammarParser.EXCLAMATION, 0); }
		public TerminalNode QUESTION() { return getToken(EnglishGrammarParser.QUESTION, 0); }
		public EndpointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endpoint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).enterEndpoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).exitEndpoint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnglishGrammarVisitor ) return ((EnglishGrammarVisitor<? extends T>)visitor).visitEndpoint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndpointContext endpoint() throws RecognitionException {
		EndpointContext _localctx = new EndpointContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_endpoint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOT) | (1L << EXCLAMATION) | (1L << QUESTION))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class ConjunctionContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(EnglishGrammarParser.COMMA, 0); }
		public TerminalNode SEMICOLON() { return getToken(EnglishGrammarParser.SEMICOLON, 0); }
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).exitConjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnglishGrammarVisitor ) return ((EnglishGrammarVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_conjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_la = _input.LA(1);
			if ( !(_la==COMMA || _la==SEMICOLON) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class PresentContext extends ParserRuleContext {
		public Sentence s;
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
		public PresentContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PresentContext(ParserRuleContext parent, int invokingState, Sentence s) {
			super(parent, invokingState);
			this.s = s;
		}
		@Override public int getRuleIndex() { return RULE_present; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).enterPresent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EnglishGrammarListener ) ((EnglishGrammarListener)listener).exitPresent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EnglishGrammarVisitor ) return ((EnglishGrammarVisitor<? extends T>)visitor).visitPresent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PresentContext present(Sentence s) throws RecognitionException {
		PresentContext _localctx = new PresentContext(_ctx, getState(), s);
		enterRule(_localctx, 24, RULE_present);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(100);
				subject(_localctx.s, true);
				setState(101);
				match(SPACE);
				setState(102);
				verb(_localctx.s);
				setState(105);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(103);
					match(SPACE);
					setState(104);
					object(_localctx.s);
					}
					break;
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(107);
					match(SPACE);
					setState(108);
					adverb(_localctx.s, false);
					}
				}

				}
				break;
			case 2:
				{
				setState(111);
				adverb(_localctx.s, true);
				setState(112);
				match(COMMA);
				setState(113);
				match(SPACE);
				setState(114);
				subject(_localctx.s, true);
				setState(115);
				match(SPACE);
				setState(116);
				verb(_localctx.s);
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(117);
					match(SPACE);
					setState(118);
					object(_localctx.s);
					}
				}

				}
				break;
			}
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\n~\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\3\2\3\2\3\2"+
		"\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\65\n"+
		"\3\f\3\16\38\13\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5B\n\5\3\5\3\5\3\5"+
		"\3\5\6\5H\n\5\r\5\16\5I\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\5\7U\n\7\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\5\16l\n\16\3\16\3\16\5\16p\n\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\5\16z\n\16\5\16|\n\16\3\16\2\2\17\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\2\4\4\2\4\4\b\t\3\2\5\6\2}\2\37\3\2\2\2\4-\3\2\2"+
		"\2\69\3\2\2\2\b<\3\2\2\2\nN\3\2\2\2\fT\3\2\2\2\16V\3\2\2\2\20Y\3\2\2\2"+
		"\22\\\3\2\2\2\24_\3\2\2\2\26b\3\2\2\2\30d\3\2\2\2\32{\3\2\2\2\34\36\7"+
		"\n\2\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2"+
		"!\37\3\2\2\2\"#\5\4\3\2#$\b\2\1\2$(\5\26\f\2%\'\7\n\2\2&%\3\2\2\2\'*\3"+
		"\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+,\7\2\2\3,\3\3\2\2\2-."+
		"\b\3\1\2./\5\6\4\2/\60\b\3\1\2\60\66\3\2\2\2\61\62\5\b\5\2\62\63\b\3\1"+
		"\2\63\65\3\2\2\2\64\61\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2"+
		"\67\5\3\2\2\28\66\3\2\2\29:\b\4\1\2:;\5\n\6\2;\7\3\2\2\2<A\b\5\1\2=>\5"+
		"\26\f\2>?\b\5\1\2?B\3\2\2\2@B\5\30\r\2A=\3\2\2\2A@\3\2\2\2BG\3\2\2\2C"+
		"D\7\n\2\2DH\b\5\1\2EF\7\7\2\2FH\b\5\1\2GC\3\2\2\2GE\3\2\2\2HI\3\2\2\2"+
		"IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\b\5\1\2LM\5\n\6\2M\t\3\2\2\2NO\5\32\16"+
		"\2O\13\3\2\2\2PU\5\16\b\2QU\5\20\t\2RU\5\22\n\2SU\5\24\13\2TP\3\2\2\2"+
		"TQ\3\2\2\2TR\3\2\2\2TS\3\2\2\2U\r\3\2\2\2VW\7\3\2\2WX\b\b\1\2X\17\3\2"+
		"\2\2YZ\7\3\2\2Z[\b\t\1\2[\21\3\2\2\2\\]\7\3\2\2]^\b\n\1\2^\23\3\2\2\2"+
		"_`\7\3\2\2`a\b\13\1\2a\25\3\2\2\2bc\t\2\2\2c\27\3\2\2\2de\t\3\2\2e\31"+
		"\3\2\2\2fg\5\16\b\2gh\7\7\2\2hk\5\22\n\2ij\7\7\2\2jl\5\20\t\2ki\3\2\2"+
		"\2kl\3\2\2\2lo\3\2\2\2mn\7\7\2\2np\5\24\13\2om\3\2\2\2op\3\2\2\2p|\3\2"+
		"\2\2qr\5\24\13\2rs\7\5\2\2st\7\7\2\2tu\5\16\b\2uv\7\7\2\2vy\5\22\n\2w"+
		"x\7\7\2\2xz\5\20\t\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{f\3\2\2\2{q\3\2\2\2"+
		"|\33\3\2\2\2\r\37(\66AGITkoy{";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}