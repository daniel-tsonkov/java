package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllCapitals {
    public static void main(String[] args) {

        String inputPath = "C:\\Users\\Daniel\\IdeaProjects\\java\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\Daniel\\IdeaProjects\\java\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
             //BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) // Трие и презаписва съдържание
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath, true))) {// Добавяне в файла без да трие съдържание
            String line = reader.readLine();

            while (line != null) {
                //System.out.println(line.toUpperCase());
                writer.write(line.toUpperCase() + "\n");

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
