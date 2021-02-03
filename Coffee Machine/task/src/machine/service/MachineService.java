package machine.service;

import machine.model.Machine;
import machine.repository.MachineRepository;
import java.util.Scanner;

public class MachineService {

    private static final String ITEM_1 = "Write how many ml of water do you want to add";
    private static final String ITEM_2 = "Write how many ml of milk do you want to add";
    private static final String ITEM_3 = "Write how many grams of coffee beans do you want to add";
    private static final String ITEM_4 = "Write how many disposable cups of coffee do you want to add";

    Scanner in = new Scanner(System.in);
    MachineRepository repository = new MachineRepository();

    public void buy(Machine session) {
        try {
            session.validate(session);
            repository.pay(session);
        } catch (Exception e){
            System.out.println("Error : " + e.getMessage()+"\nCausa : " + e.getCause());
        }
    }

    public Machine take(Machine session) {
        System.out.println("I gave you $" + session.getMoney());
        session.setMoney(0);
        return session;
    }

    public Machine fill(Machine session) {

        System.out.println(ITEM_1);
        session.setWatter(in.nextInt()+ session.getWatter());

        System.out.println(ITEM_2);
        session.setMilk(in.nextInt()+ session.getMilk());

        System.out.println(ITEM_3);
        session.setCoffee(in.nextInt()+ session.getCoffee());

        System.out.println(ITEM_4);
        session.setCup(in.nextInt()+ session.getCup());

        return session;
    }
}