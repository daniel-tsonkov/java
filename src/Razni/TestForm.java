package Razni;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestForm {
    private JButton buttoncheButton;
    private JPanel panelMain;

    public TestForm() {
        buttoncheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Dura bura");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TestForm");
        frame.setContentPane(new TestForm().panelMain);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
