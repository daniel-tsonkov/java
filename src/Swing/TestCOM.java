package Swing;

import javax.swing.*;

public class TestCOM {
    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("/icon.jpg");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("COM Port Test");
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(icon.getImage());
    }
}
