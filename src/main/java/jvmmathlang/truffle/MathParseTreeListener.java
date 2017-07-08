package jvmmathlang.truffle;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.oracle.truffle.api.frame.FrameDescriptor;
import grammer.MathBaseListener;
import grammer.MathLexer;
import grammer.MathParser;
import nodes.AsyncJvmMathLangNode;
import nodes.JvmMathLangNode;
import nodes.JvmMathLangRootNode;
import nodes.ParenJvmMathLangNode;
import nodes.literal.BigDecimalNode;
import nodes.literal.LongNode;


public class MathParseTreeListener extends MathBaseListener {

    private Map<String, JvmMathLangRootNode> functions = new HashMap<>();

    private JvmMathLangNode node;

    private LinkedList<JvmMathLangNode> mathLangNodes = new LinkedList<>();

    public JvmMathLangNode getExpression() {
        return node;
    }

    @Override
    public void exitProg(MathParser.ProgContext ctx) {
        node = mathLangNodes.pop();
    }

    @Override
    public void exitNumberExpr(MathParser.NumberExprContext ctx) {
        String text = ctx.value.getText();
        try {
            mathLangNodes.push(new LongNode(Long.parseLong(text)));
        } catch(NumberFormatException e) {
            mathLangNodes.push(new BigDecimalNode(new BigDecimal(text)));
        }
    }

    @Override
    public void exitInfixExpr(MathParser.InfixExprContext ctx) {
        JvmMathLangNode right = mathLangNodes.pop();
        JvmMathLangNode left = mathLangNodes.pop();

        JvmMathLangNode current = null;
        switch (ctx.op.getType()) {
            case MathLexer.OP_ADD:
                current = nodes.ops.AddNodeGen.create(left, right);
                break;
            case MathLexer.OP_DIV:
                current = nodes.ops.DivNodeGen.create(left, right);
                break;
            case MathLexer.OP_MUL:
                current = nodes.ops.MulNodeGen.create(left, right);
                break;
            case MathLexer.OP_SUB:
                current = nodes.ops.SubNodeGen.create(left, right);
                break;
        }
        mathLangNodes.push(current);
    }

    @Override
    public void exitParensExpr(MathParser.ParensExprContext ctx) {
        mathLangNodes.push(new ParenJvmMathLangNode(mathLangNodes.pop()));
    }

    @Override
    public void exitAsyncExpr(MathParser.AsyncExprContext ctx) {
        mathLangNodes.push(new AsyncJvmMathLangNode(mathLangNodes.pop()));
    }

    public Map<String,JvmMathLangRootNode> getFunctions(JvmMathLang jvmMathLang) {
        functions.put("main", new JvmMathLangRootNode(jvmMathLang, new FrameDescriptor(), node, "main"));
        return functions;
    }
}
