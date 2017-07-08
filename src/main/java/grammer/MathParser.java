// Generated from Math.g4 by ANTLR 4.7
package grammer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MathParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, ID=4, OP_ADD=5, OP_SUB=6, OP_MUL=7, OP_DIV=8, 
		NUM=9, WS=10, COMMA=11, NEWLINE=12;
	public static final int
		RULE_prog = 0, RULE_expr = 1, RULE_functionName = 2, RULE_argument = 3;
	public static final String[] ruleNames = {
		"prog", "expr", "functionName", "argument"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'->'", null, "'+'", "'-'", "'*'", "'/'", null, null, 
		"','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "ID", "OP_ADD", "OP_SUB", "OP_MUL", "OP_DIV", 
		"NUM", "WS", "COMMA", "NEWLINE"
	};
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
	public String getGrammarFileName() { return "Math.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MathParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MathParser.EOF, 0); }
		public TerminalNode NEWLINE() { return getToken(MathParser.NEWLINE, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			expr(0);
			setState(9);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==NEWLINE) ) {
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AsyncExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AsyncExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterAsyncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitAsyncExpr(this);
		}
	}
	public static class InfixExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public InfixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterInfixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitInfixExpr(this);
		}
	}
	public static class NumberExprContext extends ExprContext {
		public Token value;
		public TerminalNode NUM() { return getToken(MathParser.NUM, 0); }
		public NumberExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterNumberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitNumberExpr(this);
		}
	}
	public static class InvokeContext extends ExprContext {
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public InvokeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterInvoke(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitInvoke(this);
		}
	}
	public static class ParensExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterParensExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitParensExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				_localctx = new ParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(12);
				match(T__0);
				setState(13);
				expr(0);
				setState(14);
				match(T__1);
				}
				break;
			case ID:
				{
				_localctx = new InvokeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(16);
				functionName();
				setState(17);
				match(T__0);
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << ID) | (1L << NUM))) != 0)) {
					{
					setState(18);
					argument();
					}
				}

				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(21);
					match(COMMA);
					setState(22);
					argument();
					}
					}
					setState(27);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(28);
				match(T__1);
				}
				break;
			case T__2:
				{
				_localctx = new AsyncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(30);
				match(T__2);
				setState(31);
				expr(4);
				}
				break;
			case NUM:
				{
				_localctx = new NumberExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(32);
				((NumberExprContext)_localctx).value = match(NUM);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(41);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(35);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(36);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_MUL || _la==OP_DIV) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(37);
						((InfixExprContext)_localctx).right = expr(4);
						}
						break;
					case 2:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(38);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(39);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_ADD || _la==OP_SUB) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(40);
						((InfixExprContext)_localctx).right = expr(3);
						}
						break;
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FunctionNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MathParser.ID, 0); }
		public FunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterFunctionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitFunctionName(this);
		}
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(ID);
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

	public static class ArgumentContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathListener ) ((MathListener)listener).exitArgument(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			expr(0);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16\65\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\26"+
		"\n\3\3\3\3\3\7\3\32\n\3\f\3\16\3\35\13\3\3\3\3\3\3\3\3\3\3\3\5\3$\n\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\7\3,\n\3\f\3\16\3/\13\3\3\4\3\4\3\5\3\5\3\5\2"+
		"\3\4\6\2\4\6\b\2\5\3\3\16\16\3\2\t\n\3\2\7\b\2\67\2\n\3\2\2\2\4#\3\2\2"+
		"\2\6\60\3\2\2\2\b\62\3\2\2\2\n\13\5\4\3\2\13\f\t\2\2\2\f\3\3\2\2\2\r\16"+
		"\b\3\1\2\16\17\7\3\2\2\17\20\5\4\3\2\20\21\7\4\2\2\21$\3\2\2\2\22\23\5"+
		"\6\4\2\23\25\7\3\2\2\24\26\5\b\5\2\25\24\3\2\2\2\25\26\3\2\2\2\26\33\3"+
		"\2\2\2\27\30\7\r\2\2\30\32\5\b\5\2\31\27\3\2\2\2\32\35\3\2\2\2\33\31\3"+
		"\2\2\2\33\34\3\2\2\2\34\36\3\2\2\2\35\33\3\2\2\2\36\37\7\4\2\2\37$\3\2"+
		"\2\2 !\7\5\2\2!$\5\4\3\6\"$\7\13\2\2#\r\3\2\2\2#\22\3\2\2\2# \3\2\2\2"+
		"#\"\3\2\2\2$-\3\2\2\2%&\f\5\2\2&\'\t\3\2\2\',\5\4\3\6()\f\4\2\2)*\t\4"+
		"\2\2*,\5\4\3\5+%\3\2\2\2+(\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\5\3"+
		"\2\2\2/-\3\2\2\2\60\61\7\6\2\2\61\7\3\2\2\2\62\63\5\4\3\2\63\t\3\2\2\2"+
		"\7\25\33#+-";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}