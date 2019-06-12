package DefiningClasses.P05_CarSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public String getModel(){
        return this.model;
    }

    @Override
    public String toString() {
        String displacement = this.displacement + "";
        if (this.displacement == 0){
            displacement = "n/a";
        }

        String output = String.format("Power: %d\n" +
                                      "Displacement: %s\n" +
                                      "Efficiency: %s", this.power, displacement, this.efficiency);
        return output;
    }
}
