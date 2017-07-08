package nodes.ops;

import java.math.BigDecimal;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import nodes.BinaryNode;

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
    @TruffleBoundary
    protected BigDecimal div(BigDecimal left, BigDecimal right) {
        return left.divide(right);
    }

    @Specialization
    @TruffleBoundary
    protected BigDecimal div(Object left, Object right) {
        BigDecimal l = left instanceof BigDecimal ? (BigDecimal) left : BigDecimal.valueOf((long) left);
        BigDecimal r = right instanceof BigDecimal ? (BigDecimal) right : BigDecimal.valueOf((long) right);
        return l.divide(r);
    }
}
