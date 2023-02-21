package calculatorExceptions.operationExceptions;

import calculatorExceptions.CalculatorException;

public class InvalidDefineArgument extends CalculatorException {
    public InvalidDefineArgument() {
        super("Argument is not Double");
    }
}
