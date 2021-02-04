package machine.repository;

import machine.model.Machine;
import machine.model.enumerated.Operation;
import machine.model.enumerated.Option;

public class MachineRepository {

    public void setOperation(String operation, Machine session) {
        switch (operation) {
            case "fill":
                session.setOperation(Operation.FILL);
                break;
            case "take":
                session.setOperation(Operation.TAKE);
                break;
            case "buy":
                session.setOperation(Operation.BUY);
                return;
            case "remaining":
                session.setOperation(Operation.REMAIN);
                return;
            case "exit":
                session.setOperation(Operation.EXIT);
                return;
            default:
        }
    }

    public void setOption(String option, Machine session) {
        switch (option) {
            case "1":
                session.setOption(Option.ESPRESSO);
                break;
            case "2":
                session.setOption(Option.LATTE);
                break;
            case "3":
                session.setOption(Option.CAPPUCCINO);
                break;
            case "back":
                session.setOption(Option.BACK);
                break;
            default:

        }
    }

    public void pay(Machine session) {
        session.prepare();
    }

}
