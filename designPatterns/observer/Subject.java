package designPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject {
    private List<IObserver> observers;
    private String state;

    public Subject() {
        observers = new ArrayList<>();
        state = "INITIAL";
    }

    @Override
    public void changeState(String newState){
        this.state = newState;
        notifyObservers();
    }

    @Override
    public void registerObserver(IObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(IObserver observer) {
        if (observers.remove(observer)) {
            System.out.println("Observer removed successfully!");
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach(IObserver::update);
    }
}
