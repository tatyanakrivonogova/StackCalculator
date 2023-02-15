package calculatorExceptions.operationExceptions;

import calculatorExceptions.CalculatorException;

public class DivisionByZero extends CalculatorException {
    public DivisionByZero() {
        super("Division by zero");
    }
}
