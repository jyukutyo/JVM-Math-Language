package nodes.ops;


import java.math.BigDecimal;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import nodes.BinaryNode;

@NodeInfo(shortName = "+")
public abstract class AddNode extends BinaryNode {

    @Specialization(rewriteOn = ArithmeticException.class)
    protected long add(long left, long right) {
        System.out.println("add(long, long)");
        return Math.addExact(left, right);
    }

    @Specialization
    @TruffleBoundary
    protected BigDecimal add(BigDecimal left, BigDecimal right) {
        System.out.println("add(BigDecimal, BigDecimal)");
        return left.add(right);
    }

    @Specialization
    @TruffleBoundary
    protected BigDecimal add(Object left, Object right) {
        System.out.println("add(Object, Object)");
        BigDecimal l = left instanceof BigDecimal ? (BigDecimal) left : BigDecimal.valueOf((long) left);
        BigDecimal r = right instanceof BigDecimal ? (BigDecimal) right : BigDecimal.valueOf((long) right);
        return l.add(r);
    }
}
