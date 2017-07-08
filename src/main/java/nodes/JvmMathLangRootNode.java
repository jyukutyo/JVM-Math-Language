package nodes;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.RootNode;

@NodeInfo(language = "JVMMATHLANG", description = "")
public class JvmMathLangRootNode extends RootNode {

    /** The function body that is executed, and specialized during execution. */
    private JvmMathLangNode bodyNode;

    /** The name of the function, for printing purposes only. */
    private String name;

    public JvmMathLangRootNode(TruffleLanguage<?> language, FrameDescriptor frameDescriptor, JvmMathLangNode node, String name) {
        super(language, frameDescriptor);
        this.bodyNode = node;
        this.name = name;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return bodyNode.executeGeneric(frame);
    }

    public JvmMathLangNode getBodyNode() {
        return bodyNode;
    }
}
