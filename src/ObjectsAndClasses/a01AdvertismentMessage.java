package ObjectsAndClasses;

import java.util.Random;
import java.util.Scanner;

public class a01AdvertismentMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int mesages = Integer.parseInt(scanner.nextLine());

        Message message = new Message();
        message.printMessages(mesages);
    }

    static class Message {

        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] autors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random random = new Random();

        void printMessages(int messages) {
            for (int i = 0; i < messages; i++) {
                int radomPhrases = random.nextInt(this.phrases.length);
                int radomEvents = random.nextInt(this.events.length);
                int radomAutors = random.nextInt(this.autors.length);
                int radomCities = random.nextInt(this.cities.length);

                System.out.printf("%s %s %s - %s%n", this.phrases[radomPhrases], this.events[radomEvents], this.autors[radomAutors], this.cities[radomCities]);
            }
        }
    }
}
