package nodes;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;
import com.oracle.truffle.api.nodes.NodeInfo;
import jvmmathlang.truffle.JvmMathLangContext;

@NodeChildren({@NodeChild("leftNode"), @NodeChild("righrNode")})
public abstract class BinaryNode extends JvmMathLangNode {
    @Override
    public String toString() {
        NodeInfo nodeInfo = JvmMathLangContext.lookupNodeInfo(getClass());
        return "'" + nodeInfo.shortName();
    }
}
