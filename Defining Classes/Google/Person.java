package DefiningClasses.P07_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.setCompany(new Company());
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.setCar(new Car());
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public void addChild(Child child) {
        this.children.add(child);
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        String output = String.format("%s%n%s%n%s%n", this.name, this.company.toString(), this.car.toString());
        output += "Pokemon:\n";
        if (this.pokemons.isEmpty()) {
            output += "";
        } else {
            for (Pokemon pokemon : pokemons) {
                output += pokemon.toString() + "\n";
            }
        }
        output += "Parents:\n";
        if (this.parents.isEmpty()) {
            output += "";
        } else {
            for (Parent parent : parents) {
                output += parent.toString() + "\n";
            }
        }
        output += "Children:\n";
        if (this.children.isEmpty()) {
            output += "";
        } else {
            for (Child child : children) {
                output += child.toString() + System.lineSeparator();
            }
        }
        return output;
    }
}
