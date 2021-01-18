package machine.model;

import machine.model.enumerated.Operation;
import machine.model.enumerated.Option;

public class MachineCoffee {
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

    public void setOption(Option option) {
        this.option = option;
    }
}
