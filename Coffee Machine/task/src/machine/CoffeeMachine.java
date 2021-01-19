package machine;

import machine.controller.MachineController;
import machine.model.Machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args){
        MachineController controller = new MachineController();
        Machine session = new Machine();
        Scanner in = new Scanner(System.in);

        session.setMoney(550.00);
        session.setWatter(400);
        session.setMilk(540);
        session.setCoffee(120);
        session.setCup(9);

        controller.getStatus(session);
        System.out.print("Write action (buy, fill, take): ");
        if (controller.postTransaction(in.next(), session)) {
            System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
            controller.postOption(in.nextInt(), session);
        }
        controller.getStatus(session);
    }
}
