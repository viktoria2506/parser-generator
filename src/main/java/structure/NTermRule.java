package structure;

import java.util.ArrayList;
import java.util.List;

public class NTermRule {

    String name;
    String type;
    List<Argument> argList;
    List<Argument> retList;
    List<List<Production>> rules;

    public NTermRule(String name, List<Argument> argList, List<Argument> retList) {
        this.name = name;
        this.type = Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
        this.argList = argList;
        this.retList = retList;
        rules = new ArrayList<>();
    }

    public void addRule(List<Production> rule) {
        rules.add(rule);
    }

    public String retType() {
        if (retList == null) return "void";
        return type;
    }

    public List<Argument> retList() {
        return retList;
    }

    public String name() {
        return name;
    }

    public List<Argument> argList() {
        return argList;
    }

    public List<List<Production>> rules() {
        return rules;
    }
}
