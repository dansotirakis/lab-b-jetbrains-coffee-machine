import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine().trim();
        System.out.println(Arrays.toString(inputValue.split(" ")));
        int length = inputValue.length();
        char[] ch = new char[length];

        for (int i = 0; i < length; i++) {
            ch[i] = inputValue.charAt(i);
            if(i + 1 == length - 1){
                System.out.println(String.valueOf(ch[i])
                        .compareTo(String.valueOf(ch[i + 1])) <= 0);
            }
        }
    }
}