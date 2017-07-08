package jvmmathlang.truffle;

import java.util.HashMap;
import java.util.Map;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import nodes.JvmMathLangFunction;
import nodes.JvmMathLangRootNode;

public class JvmMathLangContext {

    private final Map<String, JvmMathLangFunction> functions = new HashMap<>();

    private final FrameDescriptor globalFrameDescriptor;

    private final MaterializedFrame globalFrame;

    public JvmMathLangContext() {
        this.globalFrameDescriptor = new FrameDescriptor();
        this.globalFrame = this.initGlobalFrame();
    }

    public static NodeInfo lookupNodeInfo(Class<?> aClass) {
        if (aClass == null) {
            return null;
        }
        NodeInfo info = aClass.getAnnotation(NodeInfo.class);
        if (info == null) {
            return info;
        }
        return lookupNodeInfo(aClass.getSuperclass());
    }

    public void register(Map<String, JvmMathLangRootNode> newFunctions) {
        for (Map.Entry<String, JvmMathLangRootNode> entry: newFunctions.entrySet()) {
            register(entry.getKey(), entry.getValue());
        }
    }

    private JvmMathLangFunction register(String name, JvmMathLangRootNode rootNode) {
        System.out.println("Registering function: " + name);
        RootCallTarget callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        JvmMathLangFunction function = new JvmMathLangFunction(callTarget);
        functions.put(name, function);
        return function;
    }

    private MaterializedFrame initGlobalFrame() {
        VirtualFrame frame = Truffle.getRuntime().createVirtualFrame(null, this.globalFrameDescriptor);
        return frame.materialize();
    }
}
