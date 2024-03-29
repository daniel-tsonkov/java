package DefiningClasses.PokemonTrainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!line.equals("Tournament")) {
            String[] tokens = line.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer trainer;
            if (trainers.containsKey(trainerName)) {
                trainer = trainers.get(trainerName);
            } else {
                trainer = new Trainer(trainerName);
            }
            trainer.addPokemon(pokemon);
            trainers.putIfAbsent(trainerName, trainer);

            line = scanner.nextLine();
        }
        line = scanner.nextLine();

        while (!line.equals("End")) {
            String element = line;
            trainers.values().forEach(trainer -> {
                if (trainer.hasPokemonWithGivenElement(element)) {
                    trainer.icreaseBadges();
                } else {
                    trainer.decreasePokemonsHealth();
                    trainer.removeDiedPokemon();
                }
            });
            line = scanner.nextLine();
        }

        trainers.values().stream().sorted((t1, t2) -> Integer.compare(t2.getBadges(), t1.getBadges()))
                .forEach(System.out::println);
    }
}
