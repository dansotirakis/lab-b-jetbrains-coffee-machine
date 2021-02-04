package machine;

import machine.controller.MachineController;
import machine.model.Machine;



public class CoffeeMachine {
    public static void main(String[] args){

        MachineController controller = new MachineController();
        Machine session = new Machine();

        session.setMoney(550);
        session.setWatter(400);
        session.setMilk(540);
        session.setCoffee(120);
        session.setCup(9);

        controller.getOperation(session);
    }
}
