package calculator;

import operations.Operation;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class Configuration {
    private final String configFile;
    private final Map<String, Operation> configurationMap;
    public Configuration(String _configFile) throws ReflectiveOperationException, IOException {
        configFile = _configFile;
        configurationMap = new HashMap<>();
        readConfig();
    }
    public Map<String, Operation> getConfigurationMap() {
        return configurationMap;
    }
    private void readConfig() throws IOException, ReflectiveOperationException {
        InputStream input = Configuration.class.getClassLoader().getResourceAsStream(configFile);
        Properties properties = new Properties();
        properties.load(input);
        for (String nameOperation : properties.stringPropertyNames()) {
            String nameClassOperation = properties.getProperty(nameOperation);
            Operation operation = (Operation) Class.forName(nameClassOperation).getDeclaredConstructor().newInstance();
            configurationMap.put(nameOperation, operation);
        }
    }
}
