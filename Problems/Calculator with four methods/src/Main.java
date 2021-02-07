class SimpleCalculator {

    public static void subtractTwoNumbers(long a, long b){
        printCalculator(String.valueOf(a - b));
    }
    
    public static void sumTwoNumbers(long a, long b){
        printCalculator(String.valueOf(a + b));
    }

    public static void divideTwoNumbers(long a, long b){
        String r;
        r = b == 0 ? "Division by 0!" : String.valueOf(a / b);
        printCalculator(r);
    }

    public static void multiplyTwoNumbers(long a, long b){
        printCalculator(String.valueOf(a * b));
    }

    public static void printCalculator(String result){
        System.out.println(result);
    }
}