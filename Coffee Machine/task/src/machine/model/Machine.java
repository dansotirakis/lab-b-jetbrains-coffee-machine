package machine.model;

import machine.model.DTO.ValidatorDTO;
import machine.model.enumerated.Operation;
import machine.model.enumerated.Option;

public class Machine {
    int coffee;
    int milk;
    int watter;
    int cup;
    int money;
    Operation operation;
    Option option;

    private static final String ERROR = "Sorry, not enough ";

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

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
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

    public void prepare() {
        this.setCoffee(this.getCoffee() - this.getOption().getCoffee());
        this.setMilk(this.getMilk() - this.getOption().getMilk());
        this.setWatter(this.getWatter() - this.getOption().getWatter());
        this.setMoney((int) (this.getMoney() + this.getOption().getPrice()));
        this.setCup(this.getCup() - 1);
    }

    public ValidatorDTO validate() {
        ValidatorDTO validator = new ValidatorDTO();
        if (this.getCoffee() < this.getOption().getCoffee()) {
            validator.setMessage(ERROR + "coffee!");
            validator.setError(Boolean.FALSE);
        } else if (this.getMilk() < this.getOption().getMilk()) {
            validator.setMessage(ERROR + "milk!");
            validator.setError(Boolean.FALSE);
        } else if (this.getWatter() < this.getOption().getWatter()) {
            validator.setMessage(ERROR + "watter!");
            validator.setError(Boolean.FALSE);
        } else if (this.getCup() < 1) {
            validator.setMessage(ERROR + "cups!");
            validator.setError(Boolean.FALSE);
        } else {
            validator.setMessage("I have enough resources, making you a coffee!");
            validator.setError(Boolean.TRUE);
        }
        return validator;
    }
}
