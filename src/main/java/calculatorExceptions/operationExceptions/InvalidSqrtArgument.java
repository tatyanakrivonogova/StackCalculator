package calculatorExceptions.operationExceptions;

import calculatorExceptions.CalculatorException;

public class InvalidSqrtArgument extends CalculatorException {
    public InvalidSqrtArgument(String msg) {
        super(msg);
    }
}
