import calculator.Calculator;
import calculator.ExecutionContext;
import calculator.Factory;

import java.io.*;

import factoryExceptions.FactoryException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        InputStream input = null;
        if (args.length == 0) {
            input = System.in;
        } else {
            try {
                input = new FileInputStream(args[0]);
            }
            catch (IOException e) {
                logger.log(Level.ERROR, "Input file \"" + args[0] + "\" is not found");
                System.exit(-1);
            }
        }

        try {
            Factory.getInstance();
        }
        catch (FactoryException e) {
            logger.log(Level.ERROR, e.getMessage());
            System.exit(-1);
        }

        Calculator calculator = new Calculator(input, new ExecutionContext(), logger);
        calculator.calculate();
    }
}