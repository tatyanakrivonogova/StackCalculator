package operations;
import calculatorExceptions.*;
import calculator.ExecutionContext;
import calculatorExceptions.operationExceptions.InvalidArgument;
import calculatorExceptions.operationExceptions.InvalidNumberOfArguments;

public class DefineOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (args.length != 3) {
            throw new InvalidNumberOfArguments((String) args[0], args.length, 3);
        }
        try {
            double value = Double.parseDouble(args[2].replace(",", "."));
            executionContext.getVariables().put((String) args[1], value);
        }
        catch (NumberFormatException e) {
            throw new InvalidArgument();
        }
    }
}
