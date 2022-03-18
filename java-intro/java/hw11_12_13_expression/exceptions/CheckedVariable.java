package hw11_12_13_expression.exceptions;

import hw11_12_13_expression.Variable;

public class CheckedVariable extends Variable {
    public CheckedVariable(String name) {
        super(name);
    }

    @Override
    public int getPriority() {
        return 4;
    }
}
