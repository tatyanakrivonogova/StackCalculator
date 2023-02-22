package calculator;

import factoryExceptions.ConfigFileNotFound;
import factoryExceptions.FactoryException;
import java.io.IOException;

public class Factory {
    private static Factory INSTANCE;
    private static final String configFile = "config.properties";
    private static Configuration configuration;
    private Factory() throws FactoryException {
        try {
            configuration = new Configuration(configFile);
        }
        catch (IOException e) {
            throw new ConfigFileNotFound(configFile);
        }
    }

    public static Object getOperation(final String selectedObject) {
        return configuration.getConfigurationMap().get(selectedObject);
    }

    public static Factory getInstance() throws FactoryException {
        if (INSTANCE == null) {
            INSTANCE = new Factory();
        }
        return INSTANCE;
    }
}