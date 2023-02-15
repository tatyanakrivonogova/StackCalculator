import calculator.Calculator;
import calculator.ExecutionContext;
import calculator.Factory;
import calculatorExceptions.CalculatorException;
import configurationExceptions.ConfigurationException;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ConfigurationException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, CalculatorException {
        //InputStream input = (args.length > 0) ? new FileInputStream(args[0]) : System.in;
        InputStream input = new FileInputStream("D:/java/lab2/src/commands.txt");
        Calculator calculator = new Calculator(input, new Factory("config.properties", new ExecutionContext()));
        calculator.calculate();
    }
}