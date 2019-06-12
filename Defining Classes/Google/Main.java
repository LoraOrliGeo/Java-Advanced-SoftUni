package DefiningClasses.P07_Google;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = "";

        Map<String, Person> googleInfo = new LinkedHashMap<>();

        while (!"End".equals(line = sc.nextLine())) {
            List<String> tokens = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
            String personName = tokens.get(0);

            if (!googleInfo.containsKey(personName)) {
                googleInfo.putIfAbsent(personName, new Person(personName));
            }

            if (tokens.contains("company")) {
                String companyName = tokens.get(2);
                String department = tokens.get(3);
                double salary = Double.parseDouble(tokens.get(4));

                Company company = new Company(companyName, department, salary);
                googleInfo.get(personName).setCompany(company);
            } else if (tokens.contains("pokemon")) {
                String pokemonName = tokens.get(2);
                String pokemonType = tokens.get(3);

                Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                googleInfo.get(personName).addPokemon(pokemon);
            } else if (tokens.contains("parents")) {
                String parentName = tokens.get(2);
                String parentBirthday = tokens.get(3);

                Parent parent = new Parent(parentName, parentBirthday);
                googleInfo.get(personName).addParent(parent);
            } else if (tokens.contains("children")) {
                String childName = tokens.get(2);
                String childBirthday = tokens.get(3);

                Child child = new Child(childName, childBirthday);
                googleInfo.get(personName).addChild(child);
            } else if (tokens.contains("car")){
                String carModel = tokens.get(2);
                int carSpeed = Integer.parseInt(tokens.get(3));

                Car car = new Car(carModel, carSpeed);
                googleInfo.get(personName).setCar(car);
            }
        }

        String name = sc.nextLine();

        System.out.println(googleInfo.get(name).toString());
    }
}
