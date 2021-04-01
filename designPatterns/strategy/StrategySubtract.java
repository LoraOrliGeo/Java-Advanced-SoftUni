package designPatterns.strategy;

public class StrategySubtract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 > num2 ? num1 - num2 : num2 - num1;
    }
}
