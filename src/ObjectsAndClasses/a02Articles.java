package ObjectsAndClasses;

import java.util.Scanner;

public class a02Articles {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

    }

    static class Article {
        String title;
        String content;
        String author;

        public Article (String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;

        }
    }
}
