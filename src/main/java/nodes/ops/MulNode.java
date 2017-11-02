package nodes.ops;

import java.math.BigDecimal;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import nodes.BinaryNode;

@NodeInfo(shortName = "*")
public abstract class MulNode extends BinaryNode {

    @Specialization(rewriteOn = ArithmeticException.class)
    protected long mul(long left, long right) {
        return Math.multiplyExact(left, right);
    }

    @Specialization
    protected BigDecimal mul(BigDecimal left, BigDecimal right) {
        return left.multiply(right);
    }

    @Specialization
    protected BigDecimal mul(Object left, Object right) {
        BigDecimal l = left instanceof BigDecimal ? (BigDecimal) left : BigDecimal.valueOf((long) left);
        BigDecimal r = right instanceof BigDecimal ? (BigDecimal) right : BigDecimal.valueOf((long) right);
        return l.multiply(r);
    }

}
