package VDSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class NewExpertiсе extends JFrame implements ActionListener, WindowListener {
    //JFrame newE;
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
            this.setSize(800, 600);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/icon.jpg")));
            this.setTitle("Нова експертиза");
            this.setLayout(null);

            no_expertise = new JLabel("Номер на експертизата");
            this.add(no_expertise);
            no_expertise.setBounds(50, 20, 200, 35);

            field_expertise = new JTextField();
            this.add(field_expertise);
            field_expertise.setBounds(50, 50, 300, 35);

            date_expertise = new JLabel("Дата");
            this.add(date_expertise);
            date_expertise.setBounds(50, 100, 200, 35);

            field_date_expertise = new JTextField();
            this.add(field_date_expertise);
            field_date_expertise.setBounds(50, 130, 300, 35);

            reg_no = new JLabel("Регистрационен номер");
            this.add(reg_no);
            reg_no.setBounds(50, 180, 200, 35);

            field_reg_no = new JTextField();
            this.add(field_reg_no);
            field_reg_no.setBounds(50, 210, 300, 35);

            dp_no = new JLabel("ДП номер");
            this.add(dp_no);
            dp_no.setBounds(50, 260, 200, 35);

            field_dp_no = new JTextField();
            this.add(field_dp_no);
            field_dp_no.setBounds(50, 290, 300, 35);

            ok = new JButton("Създай");
            this.add(ok);
            ok.addActionListener(this);
            ok.setBounds(250,500, 120, 30);

            cancel = new JButton("Отказвам се");
            this.add(cancel);
            cancel.addActionListener(this);
            cancel.setBounds(450,500, 120, 30);

            this.setVisible(true);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            MainScreen.expertise = field_expertise.getText();
            String nameProgram = MainScreen.nameProgram + " " + field_expertise.getText();
            MainScreen.nameProgram = nameProgram;
            //MainScreen.setTitle(nameProgram);// ne raboti?????
            //MainScreen.se
            MainScreen.new_object.setEnabled(true);
            MainScreen.new_evidence.setEnabled(true);
            MainScreen.select_object.setEnabled(true);
            MainScreen.rename_object.setEnabled(true);
            MainScreen.remove_evidence.setEnabled(true);
            MainScreen.generate_expertise.setEnabled(true);
            MainScreen.expand_tree.setEnabled(true);
            MainScreen.colapse_tree.setEnabled(true);

            MainScreen.main_tree.setVisible(false);
            MainScreen.TreeView();
            mainScreen.setEnabled(true);
            this.dispose();
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
}
