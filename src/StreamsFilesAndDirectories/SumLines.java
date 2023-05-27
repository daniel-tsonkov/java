package StreamsFilesAndDirectories;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SumLines {
    public static void main(String[] args) {
        String path = "C:\\Users\\Daniel\\IdeaProjects\\java\\src\\StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (FileReader fileReader = new FileReader(path)){
            Scanner scanner = new Scanner(fileReader);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                char[] chars = line.toCharArray();
                long sum = 0;

                for (char aChar : chars) {
                    sum += aChar;
                }
                System.out.println(sum);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        /*try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {

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
        }*/

    }
}
