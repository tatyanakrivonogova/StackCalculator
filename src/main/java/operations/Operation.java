package operations;
import calculatorExceptions.CalculatorException;
import calculator.ExecutionContext;

public interface Operation {
    void execute(String[] args, ExecutionContext executionContext) throws CalculatorException;
}
