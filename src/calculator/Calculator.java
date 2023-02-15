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
    public void calculate() throws ClassNotFoundException, InstantiationException, IllegalAccessException, CalculatorException {
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
            Operation currentOperation = (Operation) Factory.createObject(currentArgs[0]);
            currentOperation.execute(currentArgs, factory.getExecutionContext());

//            if (scan.hasNext()) {
//                currentCommand = scan.nextLine();
//            } else {
//                break;
//            }
        }
    }
}
