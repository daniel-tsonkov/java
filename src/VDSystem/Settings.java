package VDSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Settings extends JFrame implements ActionListener, KeyListener, WindowListener {
    JButton ok;
    JButton cancel;

    MainScreen mainScreen;

    public Settings(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
        this.setLocationRelativeTo(null);
        this.setSize(350, 480);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/favicon.png")));
        this.setTitle("Нова експертиза");
        this.setLayout(null);
        this.setVisible(true);

        ok = new JButton("Приложи");
        this.add(ok);
        ok.setBounds(40, 380, 120, 30);

        cancel = new JButton("Отказвам се");
        this.add(cancel);
        cancel.setBounds(170, 380, 120, 30);

        ok.addActionListener(this);
        cancel.addActionListener(this);
        this.addWindowListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            okButtonSettings();
        }
        if (e.getSource() == cancel) {
            mainScreen.setEnabled(true);
            this.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            okButtonSettings();
        }
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

    public void okButtonSettings() {
        mainScreen.setEnabled(true);
        this.dispose();
    }
}
