package calculator;

import calculatorExceptions.CalculatorException;
import operations.Operation;

import java.io.InputStream;
import java.util.Scanner;

public class Calculator {
    private final Factory factory;
    InputStream input;
    public Calculator(InputStream _input, Factory _factory) {
        input = _input;
        factory = _factory;
    }
    public void calculate() throws CalculatorException {
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
            Operation currentOperation = (Operation) Factory.createOperation(currentArgs[0]);
            currentOperation.execute(currentArgs, factory.getExecutionContext());
        }
    }
}
