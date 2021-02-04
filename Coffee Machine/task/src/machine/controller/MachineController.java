package machine.controller;

import machine.model.Machine;
import machine.model.enumerated.Option;
import machine.repository.MachineRepository;
import machine.service.MachineService;

import java.util.Objects;
import java.util.Scanner;

public class MachineController {
    public static final String MESSAGE = "What do you want to buy? ";
    public static final String OPTIONS = "1 - espresso, 2 - latte, 3 - cappuccino:";
    public static final String WELCOME = "Write action (buy, fill, take, remaining, exit): ";

    Scanner in = new Scanner(System.in);
    MachineRepository repository = new MachineRepository();
    MachineService service = new MachineService();

    public void welcomeToTheJungle(Machine session) {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(session.getWatter() + " of water");
        System.out.println(session.getMilk() + " of milk");
        System.out.println(session.getCoffee() + " of coffee beans");
        System.out.println(session.getCup() + " of disposable cups");
        System.out.println(session.getMoney() + " of money");
        this.getOperation(session);
    }

    public void postOperation(String operation, Machine session) {
        repository.setOperation(operation, session);
    }

    public void postOption(String option, Machine session) {
        repository.setOption(option, session);
        if (session.getOption().equals(Option.BACK)){
            this.getOperation(session);
        }else {
            service.buy(session);
            this.getOperation(session);
        }
    }

    public Machine postTransaction(String operation, Machine session) {
        this.postOperation(operation, session);
        switch (session.getOperation().getName()) {
            case "buy":
                return session;
            case "fill":
                service.fill(session);
                this.getOperation(session);
                break;
            case "take":
                service.take(session);
                this.getOperation(session);
                break;
            case "remaining":
                this.welcomeToTheJungle(session);
                break;
            default:
                return null;
        }
        return null;
    }

    public void getOperation(Machine session) {
        System.out.println();
        System.out.println(WELCOME);
        if (Objects.nonNull(this.postTransaction(in.next(), session))
                && Objects.nonNull(session.getOperation())
                && session.getOperation().getName().equals("buy")) {
            System.out.println();
            System.out.println(MESSAGE + OPTIONS);
            this.postOption(in.next(), session);
            System.out.println();
        }
    }

}