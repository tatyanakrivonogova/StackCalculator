package configurationExceptions;

public class NotFoundConfigFile extends ConfigurationException {
    public NotFoundConfigFile(String configFile) {
        super("Config file " + configFile + " is not found");
    }
}
