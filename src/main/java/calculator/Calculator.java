package calculator;

import calculatorExceptions.CalculatorException;
import operations.Operation;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Calculator {
    private final ExecutionContext executionContext;
    private final Logger logger;
    InputStream input;
    public Calculator(InputStream _input, ExecutionContext _executionContext, org.apache.log4j.Logger _logger) {
        input = _input;
        executionContext = _executionContext;
        logger = _logger;
    }

    public ExecutionContext getExecutionContext() {
        return executionContext;
    }

    public void calculate() {
        Scanner scan = new Scanner(input);

        String currentCommand;
        String[] currentArgs;

        while(scan.hasNext()) {
            currentCommand = scan.nextLine().trim();
            if (currentCommand.isEmpty()) {
                continue;
            }
            if (currentCommand.charAt(0) == '#') {
                continue;
            }
            currentArgs = currentCommand.split(" ");
            try {
                Operation currentOperation = (Operation) Factory.getOperation(currentArgs[0]);
                currentOperation.execute(currentArgs, executionContext);
                logger.log(Level.INFO, "Operation " + currentArgs[0] + " was executed successfully!");
            }
            catch (CalculatorException e) {
                logger.log(Level.INFO, e.getMessage());
            }
        }
    }
}
