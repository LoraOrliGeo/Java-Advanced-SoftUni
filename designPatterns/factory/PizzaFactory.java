package designPatterns.factory;

public class PizzaFactory {

    public Pizza createPizza(PizzaType type, int diameter) {
        Pizza pizza = null;

        switch (type) {
            case ITALIAN:
                pizza = new ItalianPizza(diameter);
                break;
            case CHEESE:
                pizza = new CheesePizza(diameter);
                break;
            case MEAT:
                pizza = new MeatPizza(diameter);
                break;
        }

        return pizza;
    }
}
