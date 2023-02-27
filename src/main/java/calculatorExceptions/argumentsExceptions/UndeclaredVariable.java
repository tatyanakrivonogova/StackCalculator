package calculatorExceptions.argumentsExceptions;

public class UndeclaredVariable extends ArgumentsException {
    public UndeclaredVariable(String var) {
        super("Undeclared variable " + var);
    }
}
