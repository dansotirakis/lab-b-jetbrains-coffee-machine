package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int WATTER = 200;
    static int MILK = 50;
    static int COFFEE = 15;


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Write how many ml of water the coffee machine has");
        int watterDisposable = in.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has");
        int milkDisposable = in.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has");
        int coffeeDisposable = in.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cupsRequired = in.nextInt();
        int received = isPossible(cupsRequired, watterDisposable, milkDisposable,coffeeDisposable);
        switch (received){
            case 0:
                System.out.println("No, I can make only " + possibilities(watterDisposable, milkDisposable,coffeeDisposable) + " cup(s) of coffee");
                break;
            case 2:
                System.out.println("Yes, I can make that amount of coffee");
                break;
            case 3:
                if(surplus(cupsRequired, watterDisposable, milkDisposable,coffeeDisposable) > 0){
                    System.out.println("Yes, I can make that amount of coffee (and even "
                            +surplus(cupsRequired, watterDisposable, milkDisposable,coffeeDisposable)+" more than that)");
                    break;
                }
                System.out.println("Yes, I can make that amount of coffee");
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    public static int isPossible(int cups, int water, int milk , int coffee){
        if(have(cups, water, 1) || have(cups, milk, 2) || have(cups, coffee, 0)){
            return 0;
        }else if(left(cups, water, 1) && left(cups, milk, 2) && left(cups, coffee, 0)){
            return 3;
        }else{
            return 2;
        }
    }

    public static boolean have(int cups, int supply, int type){
        switch (type){
            case 1:
                return (cups * WATTER) - supply > 0;
            case 2:
                return (cups * MILK) - supply > 0;
            default:
                return (cups * COFFEE) - supply > 0;
        }
    }

    public static boolean left(int cups, int supply, int type){
        switch (type){
            case 1:
                return supply - (cups * WATTER)  > 0;
            case 2:
                return supply - (cups * MILK) > 0;
            default:
                return supply - (cups * COFFEE) > 0;

        }
    }

    public static int possibilities(int water, int milk , int coffee){
        int waterPossible = 0;
        int milkPossible = 0;
        int coffeePossible = 0;
        for (int i = WATTER; i <= water; i += WATTER){
            waterPossible++;
        }
        for (int i = MILK; i <= milk; i += MILK){
            milkPossible++;
        }
        for (int i = COFFEE; i <= coffee; i += COFFEE){
            coffeePossible++;
        }
        return hasLess(waterPossible, milkPossible, coffeePossible);
    }

    public static int surplus(double cups, double water, double milk , double coffee){
        return hasLess((water - (cups * WATTER)) / WATTER,
                (milk - (cups * MILK)) / MILK,
                (coffee - (cups * COFFEE)) / COFFEE);
    }

    public static int hasLess(double water, double milk , double coffee){
        double[] values = new double[3];
        values[0] = water;
        values[1] = milk;
        values[2] = coffee;
        double minimum = Double.MIN_VALUE;
        double maximo = Double.MAX_VALUE;
        for (Double value : values) {
            if (minimum <= value && value > 0) {
                minimum = value;
            }
        }
        for (Double value : values) {
            if (maximo >= value && value > 0) {
                maximo = value;
            }
        }
        return Math.min((int) minimum, (int) maximo);
    }


}
