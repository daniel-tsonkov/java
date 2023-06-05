package DefiningClasses.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public boolean hasPokemonWithGivenElement(String element) {
        return this.pokemons.stream().map(Pokemon::getElement).collect(Collectors.toList()).contains(element);
    }

    public void icreaseBadges() {
        this.badges += 1;
    }

    public void decreasePokemonsHealth() {
        this.pokemons.forEach(p -> p.setHealth(p.getHealth() - 10));
    }

    public void removeDiedPokemon() {
        this.pokemons.removeIf(p -> p.getHealth() <= 0);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", name, badges, pokemons.size());
    }
}
