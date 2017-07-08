package jvmmathlang.truffle;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

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
import org.apache.commons.io.IOUtils;

@TruffleLanguage.Registration(name = "JVMMATHLANG", version = "0.0.1", mimeType = JvmMathLang.MIME_TYPE)
@ProvidedTags({StandardTags.CallTag.class, StandardTags.StatementTag.class, StandardTags.RootTag.class, DebuggerTags.AlwaysHalt.class})
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
        Map<String, JvmMathLangRootNode> functions = parseSource(request.getSource());

        JvmMathLangRootNode main = functions.get("main");

        JvmMathLangRootNode evalMain = new JvmMathLangRootNode(this, main.getFrameDescriptor(), main.getBodyNode(), "main");
        return Truffle.getRuntime().createCallTarget(evalMain);
    }

    private Map<String, JvmMathLangRootNode> parseSource(Source source) throws IOException {
        InputStream inputStream = source.getInputStream();
        CharStream charStream = CodePointCharStream.fromBuffer(CodePointBuffer.withBytes(ByteBuffer.wrap(IOUtils.toByteArray(inputStream))));
        MathLexer mathLexer = new MathLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(mathLexer);
        MathParser mathParser = new MathParser(tokenStream);

        MathParser.ProgContext prog = mathParser.prog();

        ParseTreeWalker treeWalker = new ParseTreeWalker();
        MathParseTreeListener listener = new MathParseTreeListener();
        treeWalker.walk(listener, prog);

        return listener.getFunctions(this);
    }

    protected Object findExportedSymbol(JvmMathLangContext context, String globalName, boolean onlyExplicit) {
        return null;
    }

    protected boolean isObjectOfLanguage(Object object) {
        return false;
    }
}
