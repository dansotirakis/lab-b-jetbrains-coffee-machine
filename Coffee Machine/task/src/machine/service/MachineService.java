package machine.service;

import machine.model.Machine;
import machine.repository.MachineRepository;

public class MachineService {

    MachineRepository repository = new MachineRepository();

    public void buy(Machine session) {
        try {
            session.validate(session);
        } catch (Exception e){
            System.out.println("Error : " + e.getMessage()+ "\n Causa : " + e.getCause());
        }
        repository.pay(session);
    }

    public void take(Machine session) {

    }

    public void fill(Machine session) {

    }
}