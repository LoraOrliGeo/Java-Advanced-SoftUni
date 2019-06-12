package DefiningClasses.P06_PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = "";

        Map<String, Trainer> trainersMap = new LinkedHashMap<>();

        while (!"Tournament".equals(line = sc.nextLine())) {
            String[] tokens = line.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (!trainersMap.containsKey(trainerName)) {
                trainersMap.put(trainerName, new Trainer(trainerName, 0, new ArrayList<>()));
                trainersMap.get(trainerName).addPokemon(pokemon);
            } else {
                trainersMap.get(trainerName).addPokemon(pokemon);
            }
        }

        String type = "";

        while (!"End".equals(type = sc.nextLine())) {
            for (Trainer trainer : trainersMap.values()) {
                if (trainer.pokemonHasElement(type)) {
                    trainer.increaseBadgesWithOne();
                } else {
                    trainer.decreasePokemonsHealth();
                }
            }
        }

        List<Trainer> trainers = trainersMap.values().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getNumberOfBadges(), t1.getNumberOfBadges()))
                .collect(Collectors.toList());

        for (Trainer trainer : trainers) {
            trainer.print();
        }
    }
}
