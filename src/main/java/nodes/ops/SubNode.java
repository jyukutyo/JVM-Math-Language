package nodes.ops;

import java.math.BigDecimal;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import nodes.BinaryNode;
import nodes.literal.BigDecimalTruffleObject;

@NodeInfo(shortName = "-")
public abstract class SubNode extends BinaryNode {

    @Specialization(rewriteOn = ArithmeticException.class)
    protected long sub(long left, long right) {
        return Math.subtractExact(left, right);
    }

    @Specialization
    protected BigDecimal sub(BigDecimal left, BigDecimal right) {
        return left.subtract(right);
    }

    @Specialization
    protected BigDecimalTruffleObject sub(Object left, Object right) {
        BigDecimal l = left instanceof BigDecimalTruffleObject ? ((BigDecimalTruffleObject) left).getValue() : BigDecimal.valueOf((long) left);
        BigDecimal r = right instanceof BigDecimalTruffleObject ? ((BigDecimalTruffleObject) right).getValue() : BigDecimal.valueOf((long) right);
        return new BigDecimalTruffleObject(l.subtract(r));
    }
}
