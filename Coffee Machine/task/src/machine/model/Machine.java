package machine.model;

import machine.exception.MachineException;
import machine.model.enumerated.Operation;
import machine.model.enumerated.Option;

public class Machine {
    int coffee;
    int milk;
    int watter;
    int cup;
    double money;
    Operation operation;
    Option option;

    public int getCoffee() {
        return coffee;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getWatter() {
        return watter;
    }

    public void setWatter(int watter) {
        this.watter = watter;
    }

    public int getCup() {
        return cup;
    }

    public void setCup(int cup) {
        this.cup = cup;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public Option getOption() {
        return option;
    }

    public boolean isBuy(Machine session) {
        return session.operation.getName().equals(Operation.BUY.getName());
    }

    public void prepare(Machine session) {
        session.setCoffee(session.getCoffee() - session.getOption().getCoffee());
        session.setMilk(session.getMilk() - session.getOption().getMilk());
        session.setWatter(session.getWatter() - session.getOption().getWatter());
        session.setMoney(session.getMoney() + session.getOption().getPrice());
    }

    public boolean validate(Machine session) throws MachineException {
        if(session.getCoffee() > session.getOption().getCoffee()
                || session.getMilk() > session.getOption().getMilk()
                || session.getWatter() > session.getOption().getWatter()){
            throw new MachineException();
        }
        return Boolean.TRUE;
    }
}
