package calculatorExceptions.operationExceptions;

import calculatorExceptions.CalculatorException;

public class NotEnoughElementsOnStack extends CalculatorException {
    public NotEnoughElementsOnStack() {
        super("Not enough elements on stack");
    }
}
