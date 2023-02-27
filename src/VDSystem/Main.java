package VDSystem;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatLightOwlContrastIJTheme;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try{
            //FlatArcDarkIJTheme.setup();
            UIManager.setLookAndFeel(new FlatLightOwlContrastIJTheme());
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainScreen mainScreen = new MainScreen();
    }
}
