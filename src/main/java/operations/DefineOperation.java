package operations;
import calculatorExceptions.*;
import calculator.ExecutionContext;
import calculatorExceptions.argumentsExceptions.InvalidDefineArgument;
import calculatorExceptions.argumentsExceptions.InvalidNumberOfArguments;

public class DefineOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (args.length != 3) {
            throw new InvalidNumberOfArguments(args[0], args.length-1, 2);
        }

        try {
            Double.parseDouble(args[1].replace(",", "."));
            throw new InvalidDefineArgument(1, args[1]);
        }
        catch (NumberFormatException ignored) {}

        try {
            double value = Double.parseDouble(args[2].replace(",", "."));
            executionContext.getVariables().put(args[1], value);
        }
        catch (NumberFormatException e) {
            throw new InvalidDefineArgument(2, args[2]);
        }
    }
}
