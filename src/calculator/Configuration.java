package calculator;

import configurationExceptions.NotFoundConfigFile;
import operations.Operation;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Configuration {
    private final String configFile;
    private final Map<String, Operation> configurationMap;
    public Configuration(String _configFile) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NotFoundConfigFile {
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
    private void readConfig() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NotFoundConfigFile {
        InputStream input = Configuration.class.getClassLoader().getResourceAsStream(configFile);
        if (input == null) {
            throw new NotFoundConfigFile(configFile);
        }
        Scanner scan = new Scanner(input);
        String line;
        while (scan.hasNext()) {
            line = scan.nextLine();
            String[] splitLine = line.split(" ");
            Operation operation = (Operation) Class.forName(splitLine[1]).getDeclaredConstructor().newInstance();
            configurationMap.put(splitLine[0], operation);
        }
        scan.close();
    }
}
