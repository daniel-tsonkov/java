package VerticalFarming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings  extends JFrame implements ActionListener {

    JButton ok;

    public MainScreen mainScreen;
    public Settings(VerticalFarming.MainScreen mainScreen) throws ClassNotFoundException {
        this.mainScreen = mainScreen;
        this.setLocationRelativeTo(null);
        this.setSize(650, 480);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("resources/gear.png")));
        this.setTitle("Настройки");
        this.setLayout(null);
        this.setVisible(true);

        ok = new JButton("Затвори");
        this.add(ok);
        ok.setBounds(500, 390, 120, 30);

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
