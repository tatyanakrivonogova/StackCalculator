package operations;
import calculatorExceptions.CalculatorException;
import calculator.ExecutionContext;

public interface Operation {
    public void execute(String[] args, ExecutionContext executionContext) throws CalculatorException;
}
