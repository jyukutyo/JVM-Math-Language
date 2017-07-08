package nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

@NodeInfo
public class ParenJvmMathLangNode extends JvmMathLangNode {

    @Child private JvmMathLangNode expression;

    public ParenJvmMathLangNode(JvmMathLangNode node) {
        this.expression = node;
    }

    public void setExpression(JvmMathLangNode node) {
        this.expression = node;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        try {
            return this.expression.executeLong(frame);
        } catch (UnexpectedResultException e) {
            throw new ArithmeticException();
        }
    }
}
