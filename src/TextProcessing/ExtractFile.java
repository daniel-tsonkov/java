package TextProcessing;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filePath = scanner.nextLine();
        int lastIndex = filePath.lastIndexOf("\\");
        int dotIndex = filePath.indexOf('.');

        System.out.printf("File name: %s%n", filePath.substring(lastIndex + 1, dotIndex));
        System.out.printf("File extension: %s", filePath.substring(dotIndex + 1));
    }
}
