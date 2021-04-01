package designPatterns.builder;

public class Car {
    private String color;
    private boolean hasGasBottle;
    private String lightColor;
    private boolean hasFancyRims;
    private boolean isElectric;
    private int tyres;

    public Car withFancyRims(boolean fancyRims){
        this.hasFancyRims = fancyRims;
        return this;
    }

    public Car withColor(String color){
        this.color = color;
        return this;
    }

    public Car withElectricCharge(boolean isElectric){
        this.isElectric = isElectric;
        return this;
    }

    public Car withLightsColor(String lightColor){
        this.lightColor = lightColor;
        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", hasGasBottle=" + hasGasBottle +
                ", lightColor='" + lightColor + '\'' +
                ", hasFancyRims=" + hasFancyRims +
                ", isElectric=" + isElectric +
                ", tyres=" + tyres +
                '}';
    }
}
