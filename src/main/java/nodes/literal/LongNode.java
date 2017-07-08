package nodes.literal;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import nodes.JvmMathLangNode;

@NodeInfo(shortName = "const")
public class LongNode extends JvmMathLangNode {

    private final long value;

    public LongNode(long l) {
        this.value = l;
    }

    public long executeLong(VirtualFrame frame) {
        return this.value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return this.value;
    }
}
