package Razni;

import VDSystem.MainScreen;

import javax.swing.*;
import java.awt.*;

public class TestGUIEdno {
    private JTree tree1;
    private JPanel panel1;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1024, 768);
        frame.setLocationRelativeTo(null);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setResizable(false);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/icon.jpg")));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
