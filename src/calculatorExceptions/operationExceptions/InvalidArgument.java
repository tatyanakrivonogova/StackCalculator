package calculatorExceptions.operationExceptions;

import calculatorExceptions.CalculatorException;

public class InvalidArgument extends CalculatorException {
    public InvalidArgument() {
        super("Argument is not Double");
    }
}
