package DefiningClasses.P04_RawData;

import java.util.*;
import java.util.stream.Collectors;

public class  Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");

            if (tokens.length == 13) {
                String model = tokens[0];
                int enginePower = Integer.parseInt(tokens[2]);
                
                Engine engine = new Engine(enginePower);

                String cargoType = tokens[4];
                Cargo cargo = new Cargo(cargoType);

                List<Tire> tires = new ArrayList<>();
                for (int j = 5; j <= 11; j += 2) {
                    double tirePressure = Double.parseDouble(tokens[j]);
                    Tire tire = new Tire(tirePressure);
                    tires.add(tire);
                }

                Car car = new Car(model, engine, cargo, tires);
                cars.add(car);
            }
        }

        String line = sc.nextLine();

        switch (line) {
            case "fragile":
                cars.stream()
                        .filter(car -> car.getTires()
                                .stream().filter(tire -> tire.getPressure() < 1)
                                .collect(Collectors.toList()).size() > 0)
                        .filter(car -> car.getCargo().getType().equals("fragile"))
                        .forEach(c -> System.out.println(c.getModel()));
                break;
            case "flamable":
                cars.stream()
                        .filter(car -> car.getEngine().getPower() > 250)
                        .filter(c -> c.getCargo().getType().equals("flamable"))
                        .forEach(car -> System.out.println(car.getModel()));
                break;
        }
    }
}
