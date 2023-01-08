package Swing;

import javax.swing.*;
import java.awt.*;

public class TestCOM {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(52, 73, 94));
        frame.setTitle("COM Port Test");
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TestCOM.class.getResource("/icon.jpg")));
    }
}
