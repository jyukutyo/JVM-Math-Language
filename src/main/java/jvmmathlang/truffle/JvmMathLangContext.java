package jvmmathlang.truffle;

import java.util.HashMap;
import java.util.Map;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import nodes.BuiltinNode;
import nodes.JvmMathLangFunction;
import nodes.JvmMathLangNode;
import nodes.JvmMathLangReadArgumenNode;
import nodes.PrintlnBuiltInFactory;

public class JvmMathLangContext {

    private final Map<String, JvmMathLangFunction> functions = new HashMap<>();

    private final FrameDescriptor globalFrameDescriptor;

    private final MaterializedFrame globalFrame;

    public JvmMathLangContext() {
        this.globalFrameDescriptor = new FrameDescriptor();
        installBuiltIn(PrintlnBuiltInFactory.getInstance());

        this.globalFrame = this.initGlobalFrame();
    }

    private void installBuiltIn(NodeFactory<? extends BuiltinNode> factory) {
        int argumentCount = factory.getExecutionSignature().size();
        JvmMathLangNode[] argumentNodes = new JvmMathLangNode[argumentCount];

        for (int i = 0; i < argumentCount; i++) {
            argumentNodes[i] = new JvmMathLangReadArgumenNode(i);
        }

        BuiltinNode builtinBodyNode = factory.createNode(argumentNodes, this);
        String name = lookupNodeInfo(builtinBodyNode.getClass()).shortName();

    }

    private static NodeInfo lookupNodeInfo(Class<?> aClass) {
        if (aClass == null) {
            return null;
        }
        NodeInfo info = aClass.getAnnotation(NodeInfo.class);
        if (info == null) {
            return info;
        }
        return lookupNodeInfo(aClass.getSuperclass());
    }

    private MaterializedFrame initGlobalFrame() {
        VirtualFrame frame = Truffle.getRuntime().createVirtualFrame(null, this.globalFrameDescriptor);
        return frame.materialize();
    }
}
