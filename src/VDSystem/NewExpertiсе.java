package VDSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewExpertiсе extends JFrame implements ActionListener, KeyListener, WindowListener {
    JLabel no_expertise;
    JTextField field_expertise;
    JLabel date_expertise;
    JTextField field_date_expertise;
    JLabel reg_no;
    JTextField field_reg_no;
    JLabel dp_no;
    JTextField field_dp_no;
    JButton ok;
    JButton cancel;

    MainScreen mainScreen;

    public NewExpertiсе(MainScreen mainScreen) {
        //Screen property
        {
            this.mainScreen = mainScreen;
            //newE = new JFrame();
            this.setLocationRelativeTo(null);
            this.setSize(350, 450);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/icon.jpg")));
            this.setTitle("Нова експертиза");
            this.setLayout(null);

            no_expertise = new JLabel("Номер на експертизата");
            this.add(no_expertise);
            no_expertise.setBounds(40, 25, 200, 35);

            field_expertise = new JTextField();
            this.add(field_expertise);
            field_expertise.setBounds(40, 50, 250, 35);

            date_expertise = new JLabel("Дата");
            this.add(date_expertise);
            date_expertise.setBounds(40, 90, 200, 35);

            field_date_expertise = new JTextField();
            this.add(field_date_expertise);
            field_date_expertise.setBounds(40, 115, 250, 35);

            reg_no = new JLabel("Регистрационен номер");
            this.add(reg_no);
            reg_no.setBounds(40, 155, 200, 35);

            field_reg_no = new JTextField();
            this.add(field_reg_no);
            field_reg_no.setBounds(40, 180, 250, 35);

            dp_no = new JLabel("ДП номер");
            this.add(dp_no);
            dp_no.setBounds(40, 225, 200, 35);

            field_dp_no = new JTextField();
            this.add(field_dp_no);
            field_dp_no.setBounds(40, 250, 250, 35);

            ok = new JButton("Създай");
            this.add(ok);
            field_expertise.addKeyListener(this);
            field_date_expertise.addKeyListener(this);
            ok.addActionListener(this);
            ok.setBounds(40, 350, 120, 30);

            cancel = new JButton("Отказвам се");
            this.add(cancel);
            cancel.addActionListener(this);
            cancel.setBounds(170, 350, 120, 30);

            this.setVisible(true);
            this.addWindowListener(this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            okButton();
        }
        if (e.getSource() == cancel) {
            mainScreen.setEnabled(true);
            this.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("from X");
        mainScreen.setEnabled(true);
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            okButton();
        }
        if (e.getKeyCode() == 27) {
            mainScreen.setEnabled(true);
            this.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void okButton() {
        MainScreen.expertise = field_expertise.getText();
        String nameProgram = MainScreen.nameProgram + " " + field_expertise.getText();
        MainScreen.nameProgram = nameProgram;
        MainScreen.new_object.setEnabled(true);
        MainScreen.new_evidence.setEnabled(true);
        MainScreen.select_object.setEnabled(true);
        MainScreen.rename_object.setEnabled(true);
        MainScreen.remove_evidence.setEnabled(true);
        MainScreen.generate_expertise.setEnabled(true);
        MainScreen.expand_tree.setEnabled(true);
        MainScreen.colapse_tree.setEnabled(true);

        MainScreen.color_buton.setEnabled(true);
        MainScreen.bold_buton.setEnabled(true);
        MainScreen.italic_buton.setEnabled(true);
        MainScreen.underline_buton.setEnabled(true);
        MainScreen.font_box.setEnabled(true);

        MainScreen.main_tree.setModel(null);
        MainScreen.TreeView();
        mainScreen.setEnabled(true);
        this.dispose();
    }
}
