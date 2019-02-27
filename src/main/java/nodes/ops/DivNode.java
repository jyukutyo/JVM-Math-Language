package nodes.ops;

import java.math.BigDecimal;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import nodes.BinaryNode;
import nodes.literal.BigDecimalTruffleObject;

@NodeInfo(shortName = "/")
public abstract class DivNode extends BinaryNode {

    @Specialization(rewriteOn = ArithmeticException.class)
    protected long div(long left, long right) {
        long result = left / right;

        // leftがLong.MIN_VALUEでrightが-1だとオーバーフローとなる
        if ((left & right & result) < 0) {
            throw new ArithmeticException("long overflow");
        }
        return result;
    }

    @Specialization
    protected BigDecimalTruffleObject div(BigDecimalTruffleObject left, BigDecimalTruffleObject right) {
        return new BigDecimalTruffleObject(left.getValue().divide(right.getValue()));
    }

    @Specialization
    protected BigDecimalTruffleObject div(Object left, Object right) {
        BigDecimal l = left instanceof BigDecimalTruffleObject ? ((BigDecimalTruffleObject) left).getValue() : BigDecimal.valueOf((long) left);
        BigDecimal r = right instanceof BigDecimalTruffleObject ? ((BigDecimalTruffleObject) right).getValue() : BigDecimal.valueOf((long) right);
        return new BigDecimalTruffleObject(l.divide(r));
    }
}
