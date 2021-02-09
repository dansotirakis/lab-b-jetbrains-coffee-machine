import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        for (int i = scanner.nextInt(); i >= 1; i--) {
            result += Integer.parseInt(scanner.next());
        }
        System.out.println(result);
    }
}