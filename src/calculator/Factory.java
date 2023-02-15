package calculator;
import configurationExceptions.ConfigurationException;

public class Factory {
    private static Configuration configuration;
    private final ExecutionContext executionContext;
    public Factory(String _configFile, ExecutionContext _executionContext) throws ConfigurationException,  ReflectiveOperationException {
        executionContext = _executionContext;
        configuration = new Configuration(_configFile);
    }
    ExecutionContext getExecutionContext() {
        return executionContext;
    }
    public static Object createOperation(final String selectedObject) {
        return configuration.getConfigurationMap().get(selectedObject);
    }
}
