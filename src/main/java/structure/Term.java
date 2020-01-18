package structure;

public class Term implements Production {

    String name;

    public Term(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}
