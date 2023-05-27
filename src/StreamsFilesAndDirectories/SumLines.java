package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) {
        String path = "C:\\Users\\Daniel\\IdeaProjects\\java\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {

            String line = reader.readLine();

            while (line != null) {
                char[] chars = line.toCharArray();
                long sum = 0;

                for (char aChar : chars) {
                    sum += aChar;
                }
                System.out.println(sum);

                line = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
