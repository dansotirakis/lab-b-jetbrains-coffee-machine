import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] display = new int[scanner.nextInt()];
        int[] displayC = new int[display.length];


        for (int i = 0; i <= display.length - 1; i++) {
            display[i] = Integer.parseInt(scanner.next());
        }

        for (int i = 1; i <= display.length; i++) {
            if (i == 1) {
                displayC[i - 1] = display[display.length - i];
            } else {
                displayC[i - 1] = display[i - 2];
            }
        }


        String responde = Arrays.toString(displayC);
        responde = responde
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
        System.out.println(responde);
    }
}