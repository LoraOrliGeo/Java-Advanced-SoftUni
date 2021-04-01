package designPatterns.builder;

public class Main {
    public static void main(String[] args) {

        Car newCar = new Car().withFancyRims(true).withColor("purple").withFancyRims(false);
        System.out.println(newCar.toString());

        Car car = new Car().withElectricCharge(true).withLightsColor("white");
        System.out.println(car);
    }
}
