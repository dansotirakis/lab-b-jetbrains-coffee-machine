package machine.model.enumerated;
public enum Option {
    ESPRESSO(4, 1, 250, 16, 0),
    LATTE(7,2,350,20,75),
    CAPPUCCINO(6, 3,200,12,100);

    int price;
    int id;
    int watter;
    int coffee;
    int milk;

    Option(int price, int id, int watter, int coffee, int milk) {
        this.price = price;
        this.id = id;
        this.watter = watter;
        this.coffee = coffee;
        this.milk = milk;

    }

    public double getPrice() {
        return price;
    }

    public int getWatter() {
        return watter;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getMilk() {
        return milk;
    }

}