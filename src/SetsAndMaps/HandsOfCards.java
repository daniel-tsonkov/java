package SetsAndMaps;

import java.util.*;

public class HandsOfCards {
    private  static Map<String, Integer> multiplaiers = new HashMap<>();
    //private static LinkedList<String> cardPowers = (LinkedList<String>) Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
    private static Map<String, String> cardsPowers = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        multiplaiers.put("S", 4);
        multiplaiers.put("H", 3);
        multiplaiers.put("D", 2);
        multiplaiers.put("C", 1);

        String input = scanner.nextLine();
        Map<String, HashSet<String>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");
            String name = tokens[0];

            if(!players.containsKey(name)) {
                players.put(name, new HashSet<>());
            }
            String[] cards = tokens[1].split(", ");
            for (String card : cards) {
                players.get(name).add(card);
            }

            input = scanner.nextLine();
        }

        players.forEach((k, v) -> {
          String player = k;
          calculatePoint(v);
        });
    }

    private static void calculatePoint(HashSet<String> cards) {
        int point = 0;
        for(String card : cards) {
            String power =  card.substring(card.length() - 1);
            String multiplayer = card.substring(card.length() - 1);
        }
    }
}
