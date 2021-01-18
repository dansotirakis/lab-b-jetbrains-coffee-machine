package machine.model.enumerated;
public enum Option {
    ESPRESSO(4, 1, 250, 16, 0),
    LATTE(7,2,350,20,75),
    CAPPUCCINO(6, 3,200,12,100);

    double price;
    int id;
    int watter;
    int coffee;
    int milk;

    Option(double price, int id, int watter, int coffee, int milk) {
        this.price = price;
        this.id = id;
        this.watter = watter;
        this.coffee = coffee;
        this.milk = milk;

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWatter() {
        return watter;
    }

    public void setWatter(int watter) {
        this.watter = watter;
    }

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
}