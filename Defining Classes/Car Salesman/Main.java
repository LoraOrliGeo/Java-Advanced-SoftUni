package DefiningClasses.P05_CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfEngines = Integer.parseInt(sc.nextLine());

        Map<String, Engine> engines = new LinkedHashMap<>();

        for (int i = 0; i < numberOfEngines; i++) {
            String[] tokens = sc.nextLine().split("\\s+");

            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            if (tokens.length == 2) {
                Engine engine = new Engine(model, power);
                engines.putIfAbsent(model, engine);
            } else {
                int displacement;
                String efficiency;

                if (tokens.length == 3) {
                    if (Character.isDigit(tokens[2].charAt(0))) {
                        displacement = Integer.parseInt(tokens[2]);
                        Engine engine = new Engine(model, power, displacement);
                        engines.putIfAbsent(model, engine);
                    } else {
                        efficiency = tokens[2];
                        Engine engine = new Engine(model, power, efficiency);
                        engines.putIfAbsent(model, engine);
                    }
                } else {
                    displacement = Integer.parseInt(tokens[2]);
                    efficiency = tokens[3];
                    Engine engine = new Engine(model, power, displacement, efficiency);
                    engines.putIfAbsent(model, engine);
                }
            }
        }

        int numberOfCars = Integer.parseInt(sc.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] tokens = sc.nextLine().split("\\s+");

            String model = tokens[0];
            String engine = tokens[1];

            if (tokens.length == 2) {
                Car car = new Car(model, engines.get(engine));
                cars.add(car);
            } else {
                int weight;
                String color;

                if (tokens.length == 3) {
                    if (Character.isDigit(tokens[2].charAt(0))) {
                        weight = Integer.parseInt(tokens[2]);
                        Car car = new Car(model, engines.get(engine), weight);
                        cars.add(car);
                    } else {
                        color = tokens[2];
                        Car car = new Car(model, engines.get(engine), color);
                        cars.add(car);
                    }
                } else {
                    weight = Integer.parseInt(tokens[2]);
                    color = tokens[3];
                    Car car = new Car(model, engines.get(engine), weight, color);
                    cars.add(car);
                }
            }
        }

        cars.stream().forEach(car -> {
            System.out.println(String.format("%s:", car.getModel()));

            String engineModel = car.getEngine().getModel();
            System.out.println(String.format("%s:", engineModel));

            System.out.println(engines.get(engineModel).toString());
            System.out.println(car.toString());
        });
    }
}
