package VerticalFarming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JFrame implements ActionListener {

    public MainScreen mainScreen;

    JButton ok;

    public AdminPanel(VerticalFarming.MainScreen mainScreen) throws ClassNotFoundException {
        this.setUndecorated(true); //remove "Title bar"
        this.mainScreen = mainScreen;
        this.setSize(1600, 950);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("resources/admin.png")));
        this.setTitle("Admin");
        this.setLayout(null);
        this.setVisible(true);

        ok = new JButton("Затвори");
        this.add(ok);
        ok.setBounds(1450, 900, 120, 30);

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
