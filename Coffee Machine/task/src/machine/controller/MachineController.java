package machine.controller;

import machine.model.Machine;
import machine.repository.MachineRepository;
import machine.service.MachineService;

import java.util.Objects;
import java.util.Scanner;

public class MachineController {
    public static final String MESSAGE = "What do you want to buy? ";
    public static final String OPTIONS = "1 - espresso, 2 - latte, 3 - cappuccino:";
    public static final String WELCOME = "Write action (buy, fill, take): ";

    Scanner in = new Scanner(System.in);
    MachineRepository repository = new MachineRepository();
    MachineService service = new MachineService();

    public void welcomeToTheJungle(Machine session) {
        System.out.println("The coffee machine has:");
        System.out.println(session.getWatter() + " of water");
        System.out.println(session.getMilk() + " of milk");
        System.out.println(session.getCoffee() + " of coffee beans");
        System.out.println(session.getCup() + " of disposable cups");
        System.out.println(session.getMoney() + " of money");
    }

    public void postOperation(String operation, Machine session) {
        repository.setOperation(operation, session);
    }

    public void postOption(int option, Machine session) {
        repository.setOption(option, session);
        service.buy(session);
        this.welcomeToTheJungle(session);
    }

    public Machine postTransaction(String operation, Machine session) {
        this.postOperation(operation, session);
        switch (session.getOperation().getName()) {
            case "buy":
                return session;
            case "fill":
                this.welcomeToTheJungle(service.fill(session));
                break;
            case "take":
                this.welcomeToTheJungle(service.take(session));
                break;
            default:
                this.getStatus(session);
        }
        return null;
    }

    public void getStatus(Machine session) {
        welcomeToTheJungle(session);
        System.out.print(WELCOME);
        if (Objects.nonNull(this.postTransaction(in.next(), session))
                && session.getOperation().getName().equals("buy")) {
            System.out.println(MESSAGE + OPTIONS);
            this.postOption(in.nextInt(), session);
        }
    }


}