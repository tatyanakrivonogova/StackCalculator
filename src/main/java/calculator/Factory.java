package calculator;

import java.io.IOException;

public class Factory {
    private static Factory INSTANCE;
    private static final String configFile = "config.properties";
    private static Configuration configuration;
    private Factory() throws ReflectiveOperationException, IOException {
        configuration = new Configuration(configFile);
    }

    public static Object getOperation(final String selectedObject) {
        return configuration.getConfigurationMap().get(selectedObject);
    }

    public static Factory getInstance() throws ReflectiveOperationException, IOException {
        if (INSTANCE == null) {
            INSTANCE = new Factory();
        }
        return INSTANCE;
    }
}