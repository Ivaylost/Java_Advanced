package Advance.OOP_Exercise.PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String input = sc.nextLine();

        while (!input.equals("Tournament")){
            String[]tokens = input.split("\\s+");
            String trainerName = tokens[0];;
            String name = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            Pokemon pok = new Pokemon(name,element,health);
            Trainer trainer = trainers.get(trainerName);
            trainer.getPokes().add(pok);

            input = sc.nextLine();
        }
        String command = sc.nextLine();
        while (!command.equals("End")){
            String finalCommand = command;
            for (Trainer trainer : trainers.values()) {
                if(trainer.containsElement(command)){
                    trainer.increaseBadge();
                } else {
                    trainer.getPokes().forEach(Pokemon::reduceHealth);
                }
            }
            command = sc.nextLine();
        }

        trainers.values().stream()
                .sorted(Comparator.comparing(Trainer::getBadges).reversed())
                .forEach(System.out::println);
    }
}
