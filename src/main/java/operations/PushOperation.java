package operations;
import calculatorExceptions.*;
import calculator.ExecutionContext;
import calculatorExceptions.operationExceptions.InvalidNumberOfArguments;
import calculatorExceptions.operationExceptions.UndeclaredVariable;

public class PushOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (args.length != 2) {
            throw new InvalidNumberOfArguments(args[0], args.length-1, 1);
        }

        try {
            double value = Double.parseDouble(args[1].replace(",", "."));
            executionContext.getStack().push(value);
        }
        catch (NumberFormatException e) {
            if (executionContext.getVariables().get(args[1]) == null) {
                throw new UndeclaredVariable(args[1]);
            } else {
                executionContext.getStack().push(executionContext.getVariables().get(args[1]));
            }
        }
    }
}
