package operations;

import calculator.ExecutionContext;
import calculatorExceptions.CalculatorException;
import calculatorExceptions.operationExceptions.InvalidNumberOfArguments;
import calculatorExceptions.operationExceptions.NotEnoughElementsOnStack;

public class SqrtOperation implements Operation {
    @Override
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException {
        if (args.length != 1) {
            throw new InvalidNumberOfArguments(args[0], args.length, 1);
        }
        if (executionContext.getStack().size() < 1) {
            throw new NotEnoughElementsOnStack();
        }
        Double arg = executionContext.getStack().pop();
        executionContext.getStack().push(Math.sqrt(arg));
    }
}
