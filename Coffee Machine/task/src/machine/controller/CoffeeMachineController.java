package machine.controller;

import machine.model.MachineCoffee;
import machine.model.enumerated.Operation;
import machine.model.enumerated.Option;
import machine.service.CoffeeMachineService;

public class CoffeeMachineController {

    CoffeeMachineService service = new CoffeeMachineService();

    public int findByStatus(int cupsRequired, int watterDisposable, int milkDisposable, int coffeeDisposable) {
        return service.isPossible(cupsRequired, watterDisposable, milkDisposable , coffeeDisposable);
    }

    public int findByCapacity(int watterDisposable, int milkDisposable, int coffeeDisposable) {
     return service.possibilities(watterDisposable, milkDisposable, coffeeDisposable);
    }

    public int surplus(int cupsRequired, int watterDisposable, int milkDisposable, int coffeeDisposable) {
        return service.surplus(cupsRequired, watterDisposable, milkDisposable , coffeeDisposable);
    }

    public void processTransaction(int received, int capacity, int whatLeft) {
        service.processTransaction(received, capacity, whatLeft);
    }

    public MachineCoffee buy (Option option, MachineCoffee session) {
        return service.buy(option, session);
    }

    public void fill (int watter, int milk, int coffee) {
        service.fill(watter,milk,coffee);
    }

    public MachineCoffee take () {
        return service.take();
    }

    public Operation operation (String inputUserOption) {
        switch (inputUserOption){
            case "fill":
                return Operation.FILL;
            case "take":
                return Operation.TAKE;
            case  "buy":
                return Operation.BUY;
            default:
                return null;
        }
    }

    public Option option (int inputUserOption) {
        switch (inputUserOption){
            case 1:
                return Option.ESPRESSO;
            case 2:
                return Option.LATTE;
            case  3:
                return Option.CAPPUCCINO;
            default:
                return null;

        }
    }
}