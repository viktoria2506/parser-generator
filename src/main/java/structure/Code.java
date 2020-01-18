package structure;

public class Code implements Production {

    String code;

    public Code(String code) {
        this.code = code.substring(1, code.length() - 1);
    }

    public String code() {
        return code;
    }
}
