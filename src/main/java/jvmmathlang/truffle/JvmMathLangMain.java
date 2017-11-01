package jvmmathlang.truffle;

import java.util.Scanner;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.source.MissingNameException;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.vm.PolyglotEngine;

/**
 * Main class.
 *
 * <p>
 *     waiting for user input.
 * </p>
 */
public class JvmMathLangMain {

    public static void main(String[] args) throws MissingNameException {
        System.out.println("Truffle runtime: " + Truffle.getRuntime().getName());

        PolyglotEngine engine = PolyglotEngine.newBuilder().setIn(System.in).setOut(System.out).build();
        System.out.println("Language: " + engine.getLanguages());

        try (Scanner s = new Scanner(System.in)) {
            while (true) {
                System.out.print("> ");
                String program = s.nextLine().trim();

                if (program.equalsIgnoreCase("quit")) {
                    break;
                }

                Object answer = runCode(engine, program);
                System.out.println("answer: " + answer + " (" + answer.getClass().getSimpleName() + ")");
                System.out.println();
            }
        }
    }

    private static Object runCode(PolyglotEngine engine, String program) {
        Source source = Source.newBuilder(program).name("MATH").mimeType(JvmMathLang.MIME_TYPE).build();
        PolyglotEngine.Value result = engine.eval(source);

        return result.get();
    }
}
