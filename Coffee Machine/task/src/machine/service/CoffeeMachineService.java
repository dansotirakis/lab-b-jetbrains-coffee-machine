package machine.service;

import machine.model.MachineCoffee;
import machine.model.enumerated.Option;
import machine.model.enumerated.Supply;

public class CoffeeMachineService {


    public int isPossible(int cups, int water, int milk, int coffee) {
        if (have(cups, water, 1) || have(cups, milk, 2) || have(cups, coffee, 0)) {
            return 0;
        } else if (left(cups, water, 1) && left(cups, milk, 2) && left(cups, coffee, 0)) {
            return 3;
        } else {
            return 2;
        }
    }

    public boolean have(int cups, int item, int type) {

        switch (type) {
            case 1:
                return (cups * Supply.WATTER.getDefaultValue()) - item > 0;
            case 2:
                return (cups * Supply.MILK.getDefaultValue()) - item > 0;
            default:
                return (cups * Supply.COFFEE.getDefaultValue()) - item > 0;
        }
    }

    public boolean left(int cups, int item, int type) {
        switch (type) {
            case 1:
                return item - (cups * Supply.WATTER.getDefaultValue()) > 0;
            case 2:
                return item - (cups * Supply.MILK.getDefaultValue()) > 0;
            default:
                return item - (cups * Supply.COFFEE.getDefaultValue()) > 0;

        }
    }

    public int possibilities(int water, int milk, int coffee) {
        int waterPossible = 0;
        int milkPossible = 0;
        int coffeePossible = 0;
        for (int i = Supply.WATTER.getDefaultValue(); i <= water; i += Supply.WATTER.getDefaultValue()) {
            waterPossible++;
        }
        for (int i = Supply.MILK.getDefaultValue(); i <= milk; i += Supply.MILK.getDefaultValue()) {
            milkPossible++;
        }
        for (int i = Supply.COFFEE.getDefaultValue(); i <= coffee; i += Supply.COFFEE.getDefaultValue()) {
            coffeePossible++;
        }
        return hasLess(waterPossible, milkPossible, coffeePossible);
    }

    public int surplus(double cups, double water, double milk, double coffee) {

        return hasLess((water - (cups * Supply.WATTER.getDefaultValue())) / Supply.WATTER.getDefaultValue(),
                (milk - (cups * Supply.MILK.getDefaultValue())) / cups * Supply.MILK.getDefaultValue(),
                (coffee - (cups * Supply.COFFEE.getDefaultValue())) / Supply.COFFEE.getDefaultValue());
    }

    public int hasLess(double water, double milk, double coffee) {
        double[] values = new double[3];
        values[0] = water;
        values[1] = milk;
        values[2] = coffee;
        double minimum = Double.MIN_VALUE;
        double maximo = Double.MAX_VALUE;
        for (Double value : values) {
            if (minimum <= value && value > 0) {
                minimum = value;
            }
        }
        for (Double value : values) {
            if (maximo >= value && value > 0) {
                maximo = value;
            }
        }
        return Math.min((int) minimum, (int) maximo);
    }

    public void processTransaction(int received, int capacity, int whatLeft) {
        switch (received) {
            case 0:
                System.out.println("No, I can make only " + capacity + " cup(s) of coffee");
                break;
            case 2:
                System.out.println("Yes, I can make that amount of coffee");
                break;
            case 3:
                if (whatLeft > 0) {
                    System.out.println("Yes, I can make that amount of coffee (and even "
                            + whatLeft
                            + " more than that)");
                    break;
                }
                System.out.println("Yes, I can make that amount of coffee");
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    public MachineCoffee buy(Option option, MachineCoffee session) {
        session.setMoney(session.getMoney() + option.getPrice());
        return null;
    }

    public MachineCoffee take() {
        return null;
    }

    public void fill(int watter, int milk, int coffee) {

    }
}
