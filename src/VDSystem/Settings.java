package VDSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Settings extends JFrame implements ActionListener, KeyListener, WindowListener {
    JTextField generate_expertise_field;
    JButton path_expertise;
    JButton ok;
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

        JPanel skin_panel = new JPanel();
        skin_panel.setBorder(BorderFactory.createLineBorder(Color.black));
        skin_panel.setPreferredSize(new Dimension(500, 100));
        //skin_panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        skin_panel.setBackground(new Color(250, 250, 250));

        JPanel generate_expertise_panel = new JPanel();
        generate_expertise_panel.setBorder(BorderFactory.createLineBorder(Color.black));
        generate_expertise_panel.setPreferredSize(new Dimension(500, 100));
        generate_expertise_panel.setBackground(new Color(250, 250, 250));

        JLabel theme = new JLabel("Тема(Skin) ");
        select_theme = new JComboBox(MainScreen.objects);
        select_theme.setSelectedIndex(findIndex(MainScreen.objects, MainScreen.valueOfSkin));

        JLabel generate_expertise_label = new JLabel("Директория на експертизата ");
        generate_expertise_field = new JTextField("");
        generate_expertise_field.setPreferredSize(new Dimension(280, 25));
        path_expertise = new JButton("...");

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

        panel1.add(skin_panel);
        skin_panel.add(theme);
        skin_panel.add(select_theme);
        panel1.add(generate_expertise_panel);
        generate_expertise_panel.add(generate_expertise_label);
        generate_expertise_panel.add(generate_expertise_field);
        generate_expertise_panel.add(path_expertise);

        this.add(tabbedPane, BorderLayout.CENTER);

        tabbedPane.setVisible(true);
        this.add(tabbedPane);

        ok = new JButton("Затвори");
        this.add(ok);
        ok.setBounds(500, 390, 120, 30);

        path_expertise.addActionListener(this);
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

        if (e.getSource() == path_expertise) {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("C:\\"));//(new java.io.File(".")); //tekushta direktoria
            chooser.setDialogTitle("Директория за експертизи");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
               /* System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
                System.out.println("getSelectedFile() : " + chooser.getSelectedFile());*///  dane se triqt za sega!!!!
                generate_expertise_field.setText(chooser.getSelectedFile().toString());
            } else {
                System.out.println("No Selection ");
            }
        }

        if (e.getSource() == ok) {
            okButtonSettings();
        }
        /*if (e.getSource() == cancel) {
            mainScreen.setEnabled(true);
            this.dispose();
        }*/

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
