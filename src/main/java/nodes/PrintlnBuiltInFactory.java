package nodes;

import java.util.List;

import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.nodes.Node;

public class PrintlnBuiltInFactory implements NodeFactory<BuiltinNode> {

    private static final PrintlnBuiltInFactory factory = new PrintlnBuiltInFactory();

    public static PrintlnBuiltInFactory getInstance() {
        return factory;
    }

    @Override
    public BuiltinNode createNode(Object... arguments) {
        return null;
    }

    @Override
    public Class<BuiltinNode> getNodeClass() {
        return null;
    }

    @Override
    public List<List<Class<?>>> getNodeSignatures() {
        return null;
    }

    @Override
    public List<Class<? extends Node>> getExecutionSignature() {
        return null;
    }
}
