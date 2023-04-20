package VerticalFarming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JFrame implements ActionListener {

    public MainScreen mainScreen;

    JButton ok;

    public AdminPanel(VerticalFarming.MainScreen mainScreen) throws ClassNotFoundException {
        this.mainScreen = mainScreen;
        this.setLocationRelativeTo(null);
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("resources/admin.png")));
        this.setTitle("Admin");
        this.setLayout(null);
        this.setVisible(true);

        ok = new JButton("Затвори");
        this.add(ok);
        ok.setBounds(850, 650, 120, 30);

        ok.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            mainScreen.setEnabled(true);
            this.dispose();
        }
    }
}
