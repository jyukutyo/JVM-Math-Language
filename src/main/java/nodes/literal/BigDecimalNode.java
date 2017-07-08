package nodes.literal;

import java.math.BigDecimal;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import nodes.JvmMathLangNode;

@NodeInfo(shortName = "const")
public class BigDecimalNode extends JvmMathLangNode {

    private final BigDecimal value;

    public BigDecimalNode(BigDecimal bigDecimal) {
        this.value = bigDecimal;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return this.value;
    }
}
