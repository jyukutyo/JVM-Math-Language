package jvmmathlang.truffle;

import java.io.IOException;
import java.nio.ByteBuffer;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.source.Source;
import grammer.MathLexer;
import grammer.MathParser;
import nodes.JvmMathLangRootNode;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CodePointBuffer;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * run code with ANTLR and Truffle.
 */
@TruffleLanguage.Registration(
        id = "jvmmathlang",
        name = "JVM Math Language",
        version = "0.0.2")
public class JvmMathLang extends TruffleLanguage<JvmMathLangContext> {

    protected JvmMathLangContext createContext(Env env) {
        return new JvmMathLangContext();
    }

    @Override
    protected CallTarget parse(ParsingRequest request) throws Exception {
        JvmMathLangRootNode main = parseSource(request.getSource());
        return Truffle.getRuntime().createCallTarget(main);
    }

    private JvmMathLangRootNode parseSource(Source source) throws IOException {
        // get user input
        String input = source.getCharacters().toString();

        System.out.println("inputed String: " + input);

        // convert user input to ANTLR character stream
        // java.lang.UnsupportedOperationException causes when use CharBuffer
        CharStream charStream = CodePointCharStream.fromBuffer(
                CodePointBuffer.withBytes(
                        ByteBuffer.wrap(
                                input.getBytes())));

        // lexing
        MathLexer mathLexer = new MathLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(mathLexer);

        // parsing
        MathParser mathParser = new MathParser(tokenStream);
        MathParser.ProgContext prog = mathParser.prog();

        // creates Truffle nodes from ANTLR parse result
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        MathParseTreeListener listener = new MathParseTreeListener();
        treeWalker.walk(listener, prog);

        return listener.getRoot(this);
    }

    protected boolean isObjectOfLanguage(Object object) {
        // return true if this language can deal with such object in "native way"
        return false;
    }
}
