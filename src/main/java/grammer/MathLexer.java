// Generated from Math.g4 by ANTLR 4.7
package grammer;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MathLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, ID=4, OP_ADD=5, OP_SUB=6, OP_MUL=7, OP_DIV=8, 
		NUM=9, WS=10, COMMA=11, NEWLINE=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "ID", "OP_ADD", "OP_SUB", "OP_MUL", "OP_DIV", 
		"NUM", "WS", "COMMA", "NEWLINE"
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


	public MathLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Math.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16L\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\7\5%\n\5\f\5\16"+
		"\5(\13\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\6\n\63\n\n\r\n\16\n\64\3"+
		"\n\3\n\6\n9\n\n\r\n\16\n:\5\n=\n\n\3\13\6\13@\n\13\r\13\16\13A\3\13\3"+
		"\13\3\f\3\f\3\r\5\rI\n\r\3\r\3\r\2\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\3\2\6\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\4"+
		"\2\13\13\"\"\2Q\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5\35\3\2\2\2\7\37\3\2\2\2\t\""+
		"\3\2\2\2\13)\3\2\2\2\r+\3\2\2\2\17-\3\2\2\2\21/\3\2\2\2\23\62\3\2\2\2"+
		"\25?\3\2\2\2\27E\3\2\2\2\31H\3\2\2\2\33\34\7*\2\2\34\4\3\2\2\2\35\36\7"+
		"+\2\2\36\6\3\2\2\2\37 \7/\2\2 !\7@\2\2!\b\3\2\2\2\"&\t\2\2\2#%\t\3\2\2"+
		"$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\n\3\2\2\2(&\3\2\2\2)*\7-\2"+
		"\2*\f\3\2\2\2+,\7/\2\2,\16\3\2\2\2-.\7,\2\2.\20\3\2\2\2/\60\7\61\2\2\60"+
		"\22\3\2\2\2\61\63\t\4\2\2\62\61\3\2\2\2\63\64\3\2\2\2\64\62\3\2\2\2\64"+
		"\65\3\2\2\2\65<\3\2\2\2\668\7\60\2\2\679\t\4\2\28\67\3\2\2\29:\3\2\2\2"+
		":8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<\66\3\2\2\2<=\3\2\2\2=\24\3\2\2\2>@\t\5"+
		"\2\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\b\13\2\2D\26"+
		"\3\2\2\2EF\7.\2\2F\30\3\2\2\2GI\7\17\2\2HG\3\2\2\2HI\3\2\2\2IJ\3\2\2\2"+
		"JK\7\f\2\2K\32\3\2\2\2\t\2&\64:<AH\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}