package DefiningClasses.P07_Google;

public class Car {
    private String model;
    private int speed;

    public Car() {
        this.model = "";
        this.speed = 0;
    }

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        String output = this.model.equals("") ? "Car:" : String.format("Car:%n%s %d", this.model, this.speed);
        return output;
    }
}
