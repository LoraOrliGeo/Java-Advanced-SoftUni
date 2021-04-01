package designPatterns.strategy;

public class Main {
    public static void main(String[] args) {


        Context context = new Context(new StrategyAdd());
        System.out.println(context.executeStrategy(5, 4));

        context = new Context(new StrategySubtract());
        System.out.println(context.executeStrategy(5, 4));

        context = new Context(new StrategyMultiply());
        System.out.println(context.executeStrategy(5, 4));
    }
}
