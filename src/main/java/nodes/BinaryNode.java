package nodes;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;

@NodeChildren({ @NodeChild("leftNode"), @NodeChild("righrNode") })
public abstract class BinaryNode extends JvmMathLangNode {

}
