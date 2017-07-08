package jvmmathlang.truffle;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.oracle.truffle.api.frame.FrameDescriptor;
import grammer.MathBaseListener;
import grammer.MathLexer;
import grammer.MathParser;
import nodes.AddNodeGen;
import nodes.AsyncJvmMathLangNode;
import nodes.DivNodeGen;
import nodes.JvmMathLangNode;
import nodes.JvmMathLangRootNode;
import nodes.MulNodeGen;
import nodes.ParenJvmMathLangNode;
import nodes.SubNodeGen;
import nodes.literal.BigDecimalNode;
import nodes.literal.LongNode;


public class MathParseTreeListener extends MathBaseListener {

    private Map<String, JvmMathLangRootNode> functions = new HashMap<>();

    private JvmMathLangNode node;

    private LinkedList<JvmMathLangNode> nodes = new LinkedList<>();

    public JvmMathLangNode getExpression() {
        return node;
    }

    @Override
    public void exitProg(MathParser.ProgContext ctx) {
        node = nodes.pop();
    }

    @Override
    public void exitNumberExpr(MathParser.NumberExprContext ctx) {
        String text = ctx.value.getText();
        try {
            nodes.push(new LongNode(Long.parseLong(text)));
        } catch(NumberFormatException e) {
            nodes.push(new BigDecimalNode(new BigDecimal(text)));
        }
    }

    @Override
    public void exitInfixExpr(MathParser.InfixExprContext ctx) {
        JvmMathLangNode right = nodes.pop();
        JvmMathLangNode left = nodes.pop();

        JvmMathLangNode current = null;
        switch (ctx.op.getType()) {
            case MathLexer.OP_ADD:
                current = AddNodeGen.create(left, right);
                break;
            case MathLexer.OP_DIV:
                current = DivNodeGen.create(left, right);
                break;
            case MathLexer.OP_MUL:
                current = MulNodeGen.create(left, right);
                break;
            case MathLexer.OP_SUB:
                current = SubNodeGen.create(left, right);
                break;
        }
        nodes.push(current);
    }

    @Override
    public void exitParensExpr(MathParser.ParensExprContext ctx) {
        nodes.push(new ParenJvmMathLangNode(nodes.pop()));
    }

    @Override
    public void exitAsyncExpr(MathParser.AsyncExprContext ctx) {
        nodes.push(new AsyncJvmMathLangNode(nodes.pop()));
    }

    public Map<String,JvmMathLangRootNode> getFunctions() {
        functions.put("main", new JvmMathLangRootNode(new JvmMathLang(), new FrameDescriptor(), node, "main"));
        return functions;
    }
}
