package nodes;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

public class JvmMathLangRootNode extends RootNode {

    private JvmMathLangNode node;

    private String s;

    public JvmMathLangRootNode(TruffleLanguage<?> language, FrameDescriptor frameDescriptor, JvmMathLangNode node, String s) {
        super(language, frameDescriptor);
        this.node = node;
        this.s = s;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return null;
    }
}
