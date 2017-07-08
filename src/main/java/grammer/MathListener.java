// Generated from Math.g4 by ANTLR 4.7
package grammer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MathParser}.
 */
public interface MathListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MathParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MathParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MathParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code asyncExpr}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAsyncExpr(MathParser.AsyncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code asyncExpr}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAsyncExpr(MathParser.AsyncExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInfixExpr(MathParser.InfixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInfixExpr(MathParser.InfixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(MathParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(MathParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code invoke}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInvoke(MathParser.InvokeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code invoke}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInvoke(MathParser.InvokeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParensExpr(MathParser.ParensExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParensExpr(MathParser.ParensExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MathParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(MathParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(MathParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MathParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(MathParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(MathParser.ArgumentContext ctx);
}