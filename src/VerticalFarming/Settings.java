package VerticalFarming;

import VDSystem.MainScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings  extends JFrame implements ActionListener {


    MainScreen mainScreen;
    public Settings(VDSystem.MainScreen mainScreen) throws ClassNotFoundException {
        this.mainScreen = mainScreen;
        this.setLocationRelativeTo(null);
        this.setSize(650, 480);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("resources/gear.png")));
        this.setTitle("Настройки");
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
