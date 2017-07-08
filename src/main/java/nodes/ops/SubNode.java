package nodes.ops;

import java.math.BigDecimal;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import nodes.BinaryNode;

@NodeInfo(shortName = "-")
public abstract class SubNode extends BinaryNode {

    @Specialization(rewriteOn = ArithmeticException.class)
    protected long sub(long left, long right) {
        return Math.subtractExact(left, right);
    }

    @Specialization
    @TruffleBoundary
    protected BigDecimal sub(BigDecimal left, BigDecimal right) {
        return left.subtract(right);
    }

    @Specialization
    @TruffleBoundary
    protected BigDecimal sub(Object left, Object right) {
        BigDecimal l = left instanceof BigDecimal ? (BigDecimal) left : BigDecimal.valueOf((long) left);
        BigDecimal r = right instanceof BigDecimal ? (BigDecimal) right : BigDecimal.valueOf((long) right);
        return l.subtract(r);
    }
}
