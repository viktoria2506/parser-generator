package structure;

public class Argument {

    String name;
    String type;

    public Argument(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String type() {
        return type;
    }

    public String name() {
        return name;
    }
}
