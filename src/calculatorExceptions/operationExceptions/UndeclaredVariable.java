package calculatorExceptions.operationExceptions;

import calculatorExceptions.CalculatorException;

public class UndeclaredVariable extends CalculatorException {
    public UndeclaredVariable(String var) {
        super("Undeclared variable " + var);
    }
}
