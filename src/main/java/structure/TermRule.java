package structure;

public class TermRule {

    String name;
    String value;
    boolean isRegex;

    public TermRule(boolean isRegex, String name, String value) {
        this.name = name;
        this.value = value;
        this.isRegex = isRegex;
    }

    public String name() {
        return name;
    }

    public String value() {
        return value;
    }

    public boolean isRegex() {
        return isRegex;
    }
}
