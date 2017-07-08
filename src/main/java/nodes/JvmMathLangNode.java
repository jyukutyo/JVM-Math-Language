package nodes;

import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import jvmmathlang.truffle.JvmMathLangTypes;
import jvmmathlang.truffle.JvmMathLangTypesGen;

@TypeSystemReference(JvmMathLangTypes.class)
@NodeInfo(language = "JVMMATHLANG", description = "")
public abstract class JvmMathLangNode extends Node {

    public abstract Object executeGeneric(VirtualFrame frame);

    public Object executeGeneric() {
        return null;
    }

    public long executeLong(VirtualFrame frame) throws UnexpectedResultException {
        return JvmMathLangTypesGen.expectLong(executeGeneric(frame));
    }

    public JvmMathLangFunction executeJvmMathLangFunction(VirtualFrame frame) throws UnexpectedResultException {
        return JvmMathLangTypesGen.expectJvmMathLangFunction(executeGeneric(frame));
    }

}
