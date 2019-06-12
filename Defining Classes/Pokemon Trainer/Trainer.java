package DefiningClasses.P06_PokemonTrainer;

import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name, int numberOfBadges, List<Pokemon> pokemons) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.pokemons = pokemons;
    }

    public String getName() {
        return this.name;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    boolean pokemonHasElement(String element) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(element)) {
                return true;
            }
        }

        return false;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void increaseBadgesWithOne() {
        this.numberOfBadges += 1;
    }

    public void decreasePokemonsHealth() {
        pokemons = pokemons.stream().filter(p -> p.getHealth() - 10 > 0).collect(Collectors.toList());
        pokemons.forEach(p -> p.setHealth(p.getHealth() - 10));
    }

    public void print() {
        System.out.println(String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemons.size()));
    }
}
