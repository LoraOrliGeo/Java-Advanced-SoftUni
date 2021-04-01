package designPatterns.observer;

public class Observer implements IObserver {

    @Override
    public void update() {
        System.out.println("Hurray, I'm updated!");
    }
}
