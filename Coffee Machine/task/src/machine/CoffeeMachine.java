package machine;

import machine.controller.CoffeeMachineController;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args){
        CoffeeMachineController controller = new CoffeeMachineController();
        Scanner in = new Scanner(System.in);
        System.out.print("Write how many ml of water the coffee machine has");
        int watterDisposable = in.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has");
        int milkDisposable = in.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has");
        int coffeeDisposable = in.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cupsRequired = in.nextInt();
        int received = controller.findByStatus(cupsRequired, watterDisposable, milkDisposable,coffeeDisposable);
        switch (received){
            case 0:
                System.out.println("No, I can make only " + controller.findByCapacity(watterDisposable, milkDisposable,coffeeDisposable) + " cup(s) of coffee");
                break;
            case 2:
                System.out.println("Yes, I can make that amount of coffee");
                break;
            case 3:
                if(controller.surplus(cupsRequired, watterDisposable, milkDisposable,coffeeDisposable) > 0){
                    System.out.println("Yes, I can make that amount of coffee (and even "
                            + controller.surplus(cupsRequired, watterDisposable, milkDisposable,coffeeDisposable)+" more than that)");
                    break;
                }
                System.out.println("Yes, I can make that amount of coffee");
                break;
            default:
                System.out.println("Error");
                break;
        }
    }
}
