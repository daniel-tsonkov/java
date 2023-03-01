package VDSystem;

import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String data = null;
        FileReader reader = new FileReader("C:/Users/Dani/IdeaProjects/java/tests/src/VDSystem/set.txt");
        Scanner myReader = new Scanner(reader);
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();

        try{
            MainScreen.setSkinTheme(data);
            UIManager.setLookAndFeel(new FlatArcOrangeIJTheme());
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainScreen mainScreen = new MainScreen();
    }
}
