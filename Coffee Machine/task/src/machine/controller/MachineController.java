package machine.controller;

import machine.model.Machine;
import machine.repository.MachineRepository;
import machine.service.MachineService;

public class MachineController {

    MachineRepository repository = new MachineRepository();
    MachineService service = new MachineService();

    public boolean postOperation(String operation, Machine session) {
        return repository.setOperation(operation, session);
    }

    public void postOption(int option, Machine session) {
        repository.setOption(option, session);
        service.buy(session);
    }

    public boolean postTransaction(String operation, Machine session) {
        this.postOperation(operation, session);
        switch (session.getOperation().getName()) {
            case "buy":
                return Boolean.TRUE;
            case "fill":
                service.fill(session);
                break;
            case "take":
                service.take(session);
                break;
            default:
                break;
        }
        return Boolean.FALSE;
    }

    public void getStatus(Machine session) {
        System.out.println("The coffee machine has:");
        System.out.println(session.getWatter() + " of water");
        System.out.println(session.getMilk() + " of milk");
        System.out.println(session.getCoffee() + " of coffee beans");
        System.out.println(session.getCup() + " of disposable cups");
        System.out.println(session.getMoney() + " of money");
    }


}