package machine.service;

import machine.model.DTO.ValidatorDTO;
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
        ValidatorDTO validate = session.validate();
        if(validate.isError()){
            repository.pay(session);
        }
        System.out.println(validate.getMessage());
    }

    public void take(Machine session) {
        System.out.println("I gave you $" + session.getMoney());
        session.setMoney(0);
    }

    public void fill(Machine session) {

        System.out.println();
        System.out.println(ITEM_1);
        session.setWatter(in.nextInt()+ session.getWatter());

        System.out.println(ITEM_2);
        session.setMilk(in.nextInt()+ session.getMilk());

        System.out.println(ITEM_3);
        session.setCoffee(in.nextInt()+ session.getCoffee());

        System.out.println(ITEM_4);
        session.setCup(in.nextInt()+ session.getCup());

    }
}