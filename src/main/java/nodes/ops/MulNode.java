package nodes.ops;

import java.math.BigDecimal;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import nodes.BinaryNode;
import nodes.literal.BigDecimalTruffleObject;

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
    protected BigDecimalTruffleObject mul(Object left, Object right) {
        BigDecimal l = left instanceof BigDecimalTruffleObject ? ((BigDecimalTruffleObject) left).getValue() : BigDecimal.valueOf((long) left);
        BigDecimal r = right instanceof BigDecimalTruffleObject ? ((BigDecimalTruffleObject) right).getValue() : BigDecimal.valueOf((long) right);
        return new BigDecimalTruffleObject(l.multiply(r));
    }

}
