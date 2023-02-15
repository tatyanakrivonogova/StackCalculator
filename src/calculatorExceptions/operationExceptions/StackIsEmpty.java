package calculatorExceptions.operationExceptions;

import calculatorExceptions.CalculatorException;

public class StackIsEmpty extends CalculatorException {
    public StackIsEmpty() {
        super("Stack is empty");
    }
}
