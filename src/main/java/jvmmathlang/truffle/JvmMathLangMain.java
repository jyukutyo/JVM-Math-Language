package jvmmathlang.truffle;

import java.util.Scanner;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.source.MissingNameException;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.vm.PolyglotEngine;

public class JvmMathLangMain {

    public static void main(String[] args) throws MissingNameException {
        PolyglotEngine engine = PolyglotEngine.newBuilder().setIn(System.in).setOut(System.out).build();

        System.out.println("==> running on " + Truffle.getRuntime().getName());
        System.out.println(engine.getLanguages());

        try(Scanner s = new Scanner(System.in)) {
            String program = null;
            while(true) {
                System.out.print("> ");
                program = s.nextLine().trim();
                if (program.equalsIgnoreCase("q")) {
                    break;
                }

                Source source = Source.newBuilder(program).name("<stdin>").mimeType(JvmMathLang.MIME_TYPE).build();
                PolyglotEngine.Value result = engine.eval(source);

                System.out.println(result.get().getClass().getSimpleName() + ": " + result.get());
                System.out.println();
            }
        }

    }
}
