package DefiningClasses.P05_CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public String getModel(){
        return this.model;
    }

    public Engine getEngine(){
        return this.engine;
    }

    @Override
    public String toString() {
        String weight = this.weight + "";
        if (this.weight == 0){
            weight = "n/a";
        }

        String output = String.format("Weight: %s\n" +
                "Color: %s", weight, this.color);
        return output;
    }
}
