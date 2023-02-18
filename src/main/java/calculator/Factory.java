package calculator;

import java.io.IOException;

public class Factory {
    private static Configuration configuration;
    public Factory(String _configFile) throws ReflectiveOperationException, IOException {
        configuration = new Configuration(_configFile);
    }

    public static Object getOperation(final String selectedObject) {
        return configuration.getConfigurationMap().get(selectedObject);
    }
}
