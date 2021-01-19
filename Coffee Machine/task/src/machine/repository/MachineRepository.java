package machine.repository;

import machine.model.Machine;
import machine.model.enumerated.Operation;
import machine.model.enumerated.Option;

public class MachineRepository {

    public boolean setOperation(String operation, Machine session) {
        switch (operation) {
            case "fill":
                session.setOperation(Operation.FILL);
                break;
            case "take":
                session.setOperation(Operation.TAKE);
                break;
            case "buy":
                session.setOperation(Operation.BUY);
                return Boolean.TRUE;
            default:
        }
        return false;
    }

    public void setOption(int option, Machine session) {
        switch (option) {
            case 1:
                session.setOption(Option.ESPRESSO);
                break;
            case 2:
                session.setOption(Option.LATTE);
                break;
            case 3:
                session.setOption(Option.CAPPUCCINO);
                break;
            default:
                break;
        }
    }

    public void pay(Machine session) {
        session.prepare(session);
    }

}
