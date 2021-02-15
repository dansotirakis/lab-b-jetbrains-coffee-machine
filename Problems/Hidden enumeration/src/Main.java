import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger();
        Arrays.stream(Secret.values()).iterator().forEachRemaining(secret -> {
            if (secret.toString().toLowerCase(Locale.ROOT).subSequence(0, 4).equals("star")) {
                count.getAndIncrement();
            }
        });
        System.out.println(count);
    }
}

/* sample enum for inspiration
enum Secret {
    STAR, CRASH, START
}
*/
