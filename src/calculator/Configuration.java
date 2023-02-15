package calculator;

import configurationExceptions.*;
import operations.Operation;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Configuration {
    private final String configFile;
    private final Map<String, Operation> configurationMap;
    public Configuration(String _configFile) throws NotFoundConfigFile, IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        configFile = _configFile;
        configurationMap = new HashMap<>();
        readConfig();
    }
    public String getConfigFile() {
        return configFile;
    }
    public Map<String, Operation> getConfigurationMap() {
        return configurationMap;
    }
    private void readConfig() throws NotFoundConfigFile, IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        InputStream input = Configuration.class.getClassLoader().getResourceAsStream(configFile);
        Properties properties = new Properties();
        properties.load(input);
        for (String key : properties.stringPropertyNames()) {
            String className = properties.getProperty(key);
            Operation operation = (Operation) Class.forName(className).getDeclaredConstructor().newInstance();
            configurationMap.put(key, operation);
        }
    }
}
