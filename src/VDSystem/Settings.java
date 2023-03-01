package VDSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Settings extends JFrame implements ActionListener, KeyListener, WindowListener {
    JButton ok;
    JButton cancel;
    JComboBox select_theme;

    MainScreen mainScreen;

    public Settings(MainScreen mainScreen) throws ClassNotFoundException {
        this.mainScreen = mainScreen;
        this.setLocationRelativeTo(null);
        this.setSize(650, 480);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("resources/gear.png")));
        this.setTitle("Настройки");
        this.setLayout(null);
        this.setVisible(true);

        JLabel theme = new JLabel("Тема(Skin) ");
        select_theme = new JComboBox(MainScreen.objects);
        select_theme.setSelectedIndex(findIndex(MainScreen.objects, MainScreen.valueOfSkin));

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
        tabbedPane.setBounds(5, 5, 630, 370);

        tabbedPane.add("Дисплей", panel1);
        tabbedPane.add("Дата", panel2);
        tabbedPane.add("Обстоятелства", panel3);
        tabbedPane.add("Обекти", panel4);
        tabbedPane.add("Задачи", panel5);

        panel1.add(theme);
        panel1.add(select_theme);

        this.add(tabbedPane, BorderLayout.CENTER);

        tabbedPane.setVisible(true);
        this.add(tabbedPane);

        ok = new JButton("Затвори");
        this.add(ok);
        ok.setBounds(500, 390, 120, 30);


        select_theme.addActionListener(this);
        ok.addActionListener(this);
        this.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == select_theme) {
            MainScreen.setSkinTheme(select_theme.getSelectedItem().toString());
            SwingUtilities.updateComponentTreeUI(this);
            SwingUtilities.updateComponentTreeUI(mainScreen);
        }

        if (e.getSource() == ok) {
            okButtonSettings();
        }
        if (e.getSource() == cancel) {
            mainScreen.setEnabled(true);
            this.dispose();
        }
    }

    /*private void nameTheme(Class nameTheme){
        //Class c = getName("nameTheme");"nameTheme".getClass();
        Class c = nameTheme;
        try {
            UIManager.setLookAndFeel(String.valueOf(c));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*///ZA SEGA NE SE POLZVA

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

    public static int findIndex(String objects[], String setTheme) {
        int i;
        for (i = 0; i < objects.length; i++) {
            if (objects[i].equals(setTheme)) {
                break;
            }
        }
        return i;
    }
}
