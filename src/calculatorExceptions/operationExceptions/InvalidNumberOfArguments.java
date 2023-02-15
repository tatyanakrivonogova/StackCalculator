package calculatorExceptions.operationExceptions;

import calculatorExceptions.CalculatorException;

public class InvalidNumberOfArguments extends CalculatorException {
    public InvalidNumberOfArguments(String operation, int badArgsNumber, int ExpectedArgsNumber) {
        super("operation " + operation + " expected " + ExpectedArgsNumber + " arguments instead of " + badArgsNumber);
    }
}
