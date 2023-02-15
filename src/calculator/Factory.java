package calculator;
import configurationExceptions.ConfigurationException;
import operations.Operation;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Factory {
    private static Configuration configuration;
    private final ExecutionContext executionContext;
    public Factory(String _configFile, ExecutionContext _executionContext) throws ConfigurationException, IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        executionContext = _executionContext;
        configuration = new Configuration(_configFile);
    }
    ExecutionContext getExecutionContext() {
        return executionContext;
    }
    public static Operation createObject(final String selectedObject) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return configuration.getConfigurationMap().get(selectedObject);
    }
}
