package VDSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Manual extends JFrame implements ActionListener, KeyListener, WindowListener {
    JButton ok;

    MainScreen mainScreen;
    public Manual(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
        this.setLocationRelativeTo(null);
        this.setSize(600, 580);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/icon.jpg")));
        this.setTitle("Нова експертиза");
        this.setLayout(null);
        this.setVisible(true);

        ok = new JButton("OK");
        this.add(ok);
        ok.setBounds(240, 450, 120, 30);

        ok.addActionListener(this);
        this.addKeyListener(this);
        this.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            mainScreen.setEnabled(true);
            this.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("aaa");
        if (e.getKeyCode() == 27) {
            mainScreen.setEnabled(true);
            this.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        mainScreen.setEnabled(true);
        this.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
