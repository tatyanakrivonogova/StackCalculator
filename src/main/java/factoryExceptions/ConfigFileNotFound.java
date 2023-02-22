package factoryExceptions;

public class ConfigFileNotFound extends FactoryException {
    public ConfigFileNotFound(String fileName) {
        super("Config file \"" + fileName + "\" is not found");
    }
}
