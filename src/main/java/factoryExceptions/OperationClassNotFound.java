package factoryExceptions;

public class OperationClassNotFound extends FactoryException {
    public OperationClassNotFound(String className) {
        super("Class \"" + className + "\" is not found");
    }
}
