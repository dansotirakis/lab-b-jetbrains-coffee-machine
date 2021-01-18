package machine;

import machine.controller.CoffeeMachineController;
import machine.model.MachineCoffee;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args){

        CoffeeMachineController controller = new CoffeeMachineController();
        MachineCoffee session = new MachineCoffee();
        Scanner in = new Scanner(System.in);

        session.setMoney(550.00);
        session.setWatter(400);
        session.setMilk(540);
        session.setCoffee(120);
        session.setCup(9);


        System.out.print("Write action (buy, fill, take):");
        session.setOperation(controller.operation(in.nextLine()));
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        session.setOption(controller.option(in.nextInt()));

        int received = controller.findByStatus(
                session.getCup(), session.getWatter(), session.getMilk(), session.getCoffee()
        );
        int capacity = controller.findByCapacity(
                session.getWatter(), session.getMilk(), session.getCoffee()
        );
        int whatLeft = controller.surplus(
                session.getCup(), session.getWatter(), session.getMilk(),session.getCoffee()
        );

        controller.processTransaction(received, capacity, whatLeft);

    }
}
