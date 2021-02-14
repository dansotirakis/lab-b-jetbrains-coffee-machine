import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        int[] aryOne = processor(input);
        var rpm = scanner.nextInt();
        var rota = rpm % aryOne.length;
        display(rotation(aryOne, rota));

    }

    private static int[] processor(String input) {
        int[] ary = new int[input.length()];
        for (int i = 0; i <= input.length() - 1; i++) {
            ary = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return ary;
    }

    private static String rotation(int[] aryOne, int rota) {
        for (int i = 0; i < rota; i++) {
            int j;
            int last;
            last = aryOne[aryOne.length - 1];
            for (j = aryOne.length - 1; j > 0; j--) {
                aryOne[j] = aryOne[j - 1];
            }
            aryOne[0] = last;
        }
        return Arrays.toString(aryOne);
    }

    private static void display(String aryOne) {
        System.out.println(
                aryOne
                        .replace("[", "")
                        .replace("]", "")
                        .replace(",", "")
        );
    }

}