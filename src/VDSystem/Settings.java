package VDSystem;

import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatHighContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatLightOwlContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlContrastIJTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Settings extends JFrame implements ActionListener, KeyListener, WindowListener {
    JButton applay;
    JButton ok;
    JButton cancel;
    JComboBox select_theme;
    String selectet_theme_string = "";

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


        //FieldTest ft = new FieldTest();
        //Class ftClass = Class.forName("com.formdev.flatlaf.FlatLightLaf");//ft.getClass();
        /*Class c = Class.forName(".formdev.flatlaf.intellijthemes.FlatArcIJTheme");
        Method [] m = c.getDeclaredMethods();
        for (Method m1:m){
            System.out.println(m1.getName());
        }*/
        //Field[] fields = ftClass.getDeclaredFields();
        //String[] object = (com.formdev.flatlaf).tostring;
        String[] objects = {"FlatArcIJTheme", "FlatArcOrangeIJTheme", "FlatCarbonIJTheme", "FlatHighContrastIJTheme", "FlatLightOwlContrastIJTheme", "FlatNightOwlContrastIJTheme"};
        select_theme = new JComboBox(objects);

        //applay = new JButton("Приложи");

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

        panel1.add(select_theme);
        //panel1.add(applay);

        this.add(tabbedPane, BorderLayout.CENTER);

        tabbedPane.setVisible(true);
        this.add(tabbedPane);

        ok = new JButton("Затвори");
        this.add(ok);
        ok.setBounds(370, 390, 120, 30);

        cancel = new JButton("Отказвам се");
        this.add(cancel);
        cancel.setBounds(500, 390, 120, 30);

        select_theme.addActionListener(this);
        //applay.addActionListener(this);
        ok.addActionListener(this);
        cancel.addActionListener(this);
        this.addWindowListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == select_theme) {
            if (!selectet_theme_string.equals(select_theme.getSelectedItem().toString())) {
                switch (select_theme.getSelectedItem().toString()){
                    case "FlatArcIJTheme":
                        try{
                            System.out.println("select1");
                            UIManager.setLookAndFeel(new FlatArcIJTheme());
                        } catch (Exception s) {
                            s.printStackTrace();
                        }
                        break;
                    case "FlatArcOrangeIJTheme":
                        try{
                            System.out.println("select2");
                            UIManager.setLookAndFeel(new FlatArcOrangeIJTheme());
                        } catch (Exception s) {
                            s.printStackTrace();
                        }
                        break;
                    case "FlatCarbonIJTheme":
                        try{
                            UIManager.setLookAndFeel(new FlatCarbonIJTheme());
                        } catch (Exception s) {
                            s.printStackTrace();
                        }
                        break;
                    case "FlatHighContrastIJTheme":
                        try{
                            UIManager.setLookAndFeel(new FlatHighContrastIJTheme());
                        } catch (Exception s) {
                            s.printStackTrace();
                        }
                        break;
                    case "FlatLightOwlContrastIJTheme":
                        try{
                            UIManager.setLookAndFeel(new FlatLightOwlContrastIJTheme());
                        } catch (Exception s) {
                            s.printStackTrace();
                        }
                        break;
                    case "FlatNightOwlContrastIJTheme":
                        try{
                            UIManager.setLookAndFeel(new FlatNightOwlContrastIJTheme());
                        } catch (Exception s) {
                            s.printStackTrace();
                        }
                        break;
                }
                SwingUtilities.updateComponentTreeUI(this);
                SwingUtilities.updateComponentTreeUI(mainScreen);
                selectet_theme_string = select_theme.getSelectedItem().toString();
            }
        }

        if (e.getSource() == applay) {

        }

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

    public class FieldTest {

        private String pri;
        protected String pro;
        public String pub;

        public FieldTest() {
        }

        public FieldTest(String pri, String pro, String pub) {
            this.pri = pri;
            this.pro = pro;
            this.pub = pub;
        }

    }
}
