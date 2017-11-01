package jvmmathlang.truffle;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.debug.DebuggerTags;
import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.instrumentation.StandardTags;
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
        name = "JVMMATHLANG",
        version = "0.0.1",
        mimeType = JvmMathLang.MIME_TYPE)
@ProvidedTags(
        {
                StandardTags.CallTag.class,
                StandardTags.StatementTag.class,
                StandardTags.RootTag.class,
                DebuggerTags.AlwaysHalt.class
        })
public class JvmMathLang extends TruffleLanguage<JvmMathLangContext> {

    public static final String MIME_TYPE = "application/x-jvmmathlang";

    protected JvmMathLangContext createContext(Env env) {
        return new JvmMathLangContext();
    }

    protected Object getLanguageGlobal(JvmMathLangContext context) {
        return context;
    }

    @Override
    protected CallTarget parse(ParsingRequest request) throws Exception {
        JvmMathLangRootNode main = parseSource(request.getSource());
        return Truffle.getRuntime().createCallTarget(main);
    }

    private JvmMathLangRootNode parseSource(Source source) throws IOException {
        // get user input
        //
        InputStream inputStream = source.getInputStream();
        byte[] byteArray = IOUtils.toByteArray(inputStream);

        System.out.println("inputed String: " + new String(byteArray, StandardCharsets.UTF_8));

        // convert user input to ANTLR character stream
        // java.lang.UnsupportedOperationException causes when use CharBuffer
        CharStream charStream = CodePointCharStream.fromBuffer(
                CodePointBuffer.withBytes(
                        ByteBuffer.wrap(
                                byteArray)));

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
