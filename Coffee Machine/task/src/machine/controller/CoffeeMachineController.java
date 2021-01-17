package machine.controller;

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
}
