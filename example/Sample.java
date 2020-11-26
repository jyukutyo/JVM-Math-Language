import org.graalvm.polyglot.*;

class Sample {
    public static void main(String... args) {
        try (var context = Context.newBuilder("jvmmathlang").build()) {
            Value answer = context.eval("jvmmathlang", "(1+2)*3");
            System.out.println(answer);
        }
    }
}