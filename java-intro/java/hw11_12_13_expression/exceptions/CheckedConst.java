package hw11_12_13_expression.exceptions;

import hw11_12_13_expression.Const;

public class CheckedConst extends Const {

    public CheckedConst(int c) {
        super(c);
    }

    @Override
    public int getPriority() {
        return 4;
    }
}
