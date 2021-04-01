package designPatterns.observer;

public class Main {
    public static void main(String[] args) {

        ISubject site = new Subject();

        IObserver pesho = new Observer();
        IObserver mimi = new Observer();

        site.registerObserver(pesho);
        site.registerObserver(mimi);

        site.changeState("NEW STATE");

        site.removeObserver(mimi);
    }
}
