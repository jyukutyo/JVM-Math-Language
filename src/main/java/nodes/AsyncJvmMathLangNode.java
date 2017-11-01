package nodes;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = "->")
public class AsyncJvmMathLangNode extends JvmMathLangNode {

    @Child private JvmMathLangNode expression;

    public AsyncJvmMathLangNode(JvmMathLangNode node) {
        this.expression = node;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        try {
            System.out.println("Running on another thread: " + expression);
            return CompletableFuture.supplyAsync(() -> expression.executeGeneric(frame)).get();
        } catch (InterruptedException|ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
