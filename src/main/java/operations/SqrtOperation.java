package operations;

import calculator.ExecutionContext;
import calculatorExceptions.CalculatorException;
import calculatorExceptions.argumentsExceptions.InvalidNumberOfArguments;
import calculatorExceptions.argumentsExceptions.InvalidSqrtArgument;
import calculatorExceptions.stackExceptions.NotEnoughElementsOnStack;

public class SqrtOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (args.length != 1) {
            throw new InvalidNumberOfArguments(args[0], args.length-1, 0);
        }
        if (executionContext.getStack().size() < 1) {
            throw new NotEnoughElementsOnStack();
        }
        Double arg = executionContext.getStack().pop();
        Double sqrtValue = Math.sqrt(arg);
        if (sqrtValue.isNaN()) {
            executionContext.getStack().push(arg);
            throw new InvalidSqrtArgument("Impossible to take the arithmetic root of a negative number " + arg);
        } else {
            executionContext.getStack().push(sqrtValue);
        }
    }
}
