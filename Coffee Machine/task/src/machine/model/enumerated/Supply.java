package machine.model.enumerated;
public enum Supply {
    WATTER(200, 1),
    MILK(50, 2),
    COFFEE(15, 0);

    int defaultValue;
    int id;

    Supply(int defaultValue, int id) {
        this.defaultValue = defaultValue;
        this.id = id;
    }

    public int getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(int defaultValue) {
        this.defaultValue = defaultValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
