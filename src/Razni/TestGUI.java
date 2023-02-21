package Razni;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestGUI extends JFrame {

    private JTextField textField1;
    private JTextField textField2;
    private JButton OKButton;
    private JButton cancelButton;
    private JPanel mainPanel;

    public static void main(String[] args) {
        TestGUI testGUI = new TestGUI();
    }

    public TestGUI() {
        this.setContentPane(mainPanel);
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
