package nodes.ops;


import java.math.BigDecimal;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import nodes.BinaryNode;
import nodes.literal.BigDecimalTruffleObject;

@NodeInfo(shortName = "+")
public abstract class AddNode extends BinaryNode {

    @Specialization(rewriteOn = ArithmeticException.class)
    protected long add(long left, long right) {
        System.out.println("add(long, long)");
        return Math.addExact(left, right);
    }

    @Specialization
    @TruffleBoundary
    protected BigDecimalTruffleObject add(BigDecimalTruffleObject left, BigDecimalTruffleObject right) {
        System.out.println("add(BigDecimal, BigDecimal)");
        return new BigDecimalTruffleObject(left.getValue().add(right.getValue()));
    }

    @Specialization
    @TruffleBoundary
    protected BigDecimalTruffleObject add(Object left, Object right) {
        System.out.println("add(Object, Object)");
        BigDecimal l = left instanceof BigDecimalTruffleObject ? ((BigDecimalTruffleObject) left).getValue() : BigDecimal.valueOf((long) left);
        BigDecimal r = right instanceof BigDecimalTruffleObject ? ((BigDecimalTruffleObject) right).getValue() : BigDecimal.valueOf((long) right);
        return new BigDecimalTruffleObject(l.add(r));
    }
}
