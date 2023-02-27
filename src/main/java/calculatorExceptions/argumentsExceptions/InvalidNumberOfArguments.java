package calculatorExceptions.argumentsExceptions;

public class InvalidNumberOfArguments extends ArgumentsException {
    public InvalidNumberOfArguments(String operation, int badArgsNumber, int ExpectedArgsNumber) {
        super("operation " + operation + " expected " + ExpectedArgsNumber + " arguments instead of " + badArgsNumber);
    }
}
