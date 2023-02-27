package VDSystem;

import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try{
            //FlatArcDarkIJTheme.setup();
            UIManager.setLookAndFeel(new FlatArcOrangeIJTheme());
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainScreen mainScreen = new MainScreen();
    }
}
