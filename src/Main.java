import calculator.Calculator;
import calculator.ExecutionContext;
import calculator.Factory;
import calculatorExceptions.CalculatorException;
import calculatorExceptions.inputStreamExceptions.InputStreamException;
import calculatorExceptions.inputStreamExceptions.NotFoundInputStream;
import configurationExceptions.ConfigurationException;

import java.io.*;

public class Main {
    public static void main(String[] args) throws ConfigurationException, IOException, ReflectiveOperationException, CalculatorException, InputStreamException {
        InputStream input = (args.length > 0) ? new FileInputStream(args[0]) : System.in;
        if (input == null) {
            throw new NotFoundInputStream();
        }
        Calculator calculator = new Calculator(input, new Factory("config.txt", new ExecutionContext()));
        calculator.calculate();
    }
}