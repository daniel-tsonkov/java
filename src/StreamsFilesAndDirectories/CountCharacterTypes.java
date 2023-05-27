package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Daniel\\IdeaProjects\\java\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        int vowelsCount = 0;
        int otherSymbolsCount = 0;
        int punctoationsCount = 0;
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');


        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputPath))) {
            String line = reader.readLine();

            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);


                }

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
