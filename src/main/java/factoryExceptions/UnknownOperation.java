package factoryExceptions;

public class UnknownOperation extends FactoryException {
    public UnknownOperation(String op) {
        super("Unknown operation " + op);
    }
}
