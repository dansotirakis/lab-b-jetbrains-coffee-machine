package machine.model.enumerated;
public enum Operation {
    BUY("buy",1),
    FILL("fill",2),
    TAKE("take",3);

    String name;
    int id;

    Operation(String name, int id) {
        this.name = name;
        this.id = id;
    }
}