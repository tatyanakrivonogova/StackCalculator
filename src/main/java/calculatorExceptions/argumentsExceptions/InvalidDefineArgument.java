package calculatorExceptions.argumentsExceptions;

public class InvalidDefineArgument extends ArgumentsException {
    public InvalidDefineArgument(int number, String arg) {
        super((number == 1) ? "Argument " + arg + " is not char or string" : "Argument " + arg + " is not Double");
    }
}
