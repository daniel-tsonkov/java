package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LineNumbers {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Daniel\\IdeaProjects\\java\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath = "C:\\Users\\Daniel\\IdeaProjects\\java\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\output.txt";
        int counter = 1;

        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {// Трие и презаписва съдържание
            //BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath, true))) {// Добавяне в файла без да трие съдържание
            String line = reader.readLine();

            while (line != null) {
                writer.write(counter + ". " + line + "\n");
                counter++;
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
