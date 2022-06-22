import java.util.*;
import java.util.Scanner;

public class classes {
    static class Asd {
        String name;
        String def = "NA";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameObj = scanner.nextLine();
        Asd.nameObj = new Asd();
        //ime.name = "vvv";

        //System.out.println(ime.name);
        //System.out.println(ime.def);
    }
}
