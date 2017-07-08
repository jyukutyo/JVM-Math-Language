package nodes;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeField;
import jvmmathlang.truffle.JvmMathLangContext;

@NodeField(name = "context", type = JvmMathLangContext.class)
@GenerateNodeFactory
public abstract class BuiltinNode extends JvmMathLangNode {

    public abstract JvmMathLangContext getContext();

}
