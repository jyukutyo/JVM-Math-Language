package nodes;

import com.oracle.truffle.api.instrumentation.InstrumentableFactory;
import com.oracle.truffle.api.instrumentation.ProbeNode;

public class JvmMathLangNodeWrapper implements InstrumentableFactory<JvmMathLangNode> {

    @Override
    public WrapperNode createWrapper(JvmMathLangNode node, ProbeNode probe) {
        return null;
    }
}
