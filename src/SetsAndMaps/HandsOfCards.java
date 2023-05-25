package SetsAndMaps;

import java.util.*;

public class HandsOfCards {
    private static final Map<String, Integer> multiplaiers = new HashMap<>();
    private static final Map<String, Integer> cardsPowers = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        multiplaiers.put("S", 4);
        multiplaiers.put("H", 3);
        multiplaiers.put("D", 2);
        multiplaiers.put("C", 1);

        cardsPowers.put("2", 2);
        cardsPowers.put("3", 3);
        cardsPowers.put("4", 4);
        cardsPowers.put("5", 5);
        cardsPowers.put("6", 6);
        cardsPowers.put("7", 7);
        cardsPowers.put("8", 8);
        cardsPowers.put("9", 9);
        cardsPowers.put("10", 10);
        cardsPowers.put("J", 11);
        cardsPowers.put("Q", 12);
        cardsPowers.put("K", 13);
        cardsPowers.put("A", 14);

        String input = scanner.nextLine();
        Map<String, HashSet<String>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");
            String name = tokens[0];

            if (!players.containsKey(name)) {
                players.put(name, new HashSet<>());
            }
            String[] cards = tokens[1].split(", ");

            for (String card : cards) {
                players.get(name).add(card);
            }

            input = scanner.nextLine();
        }

        players.forEach((k, v) -> {
            int points = calculatePoint(v);
            System.out.printf("%s: %d\n", k, points);
        });

    }

    private static int calculatePoint(HashSet<String> cards) {
        int point = 0;
        for (String card : cards) {
            String power = card.substring(0, card.length() - 1);
            String multiplayer = card.substring(card.length() - 1);
            point += cardsPowers.get(power) * multiplaiers.get(multiplayer);
        }
        return point;
    }
}
