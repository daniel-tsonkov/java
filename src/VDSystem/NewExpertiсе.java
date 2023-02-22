package VDSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewExpertiсе implements ActionListener {
    JFrame newE;
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

    public NewExpertiсе() {
        //Screen property
        {
            newE = new JFrame();
            newE.setLocationRelativeTo(null);
            newE.setSize(800, 600);
            newE.setLocationRelativeTo(null);
            newE.setResizable(false);
            newE.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/icon.jpg")));
            newE.setTitle("Нова експертиза");
            newE.setLayout(null);

            no_expertise = new JLabel("Номер на експертизата");
            newE.add(no_expertise);
            no_expertise.setBounds(50, 20, 200, 35);

            field_expertise = new JTextField();
            newE.add(field_expertise);
            field_expertise.setBounds(50, 50, 300, 35);

            date_expertise = new JLabel("Дата");
            newE.add(date_expertise);
            date_expertise.setBounds(50, 100, 200, 35);

            field_date_expertise = new JTextField();
            newE.add(field_date_expertise);
            field_date_expertise.setBounds(50, 130, 300, 35);

            reg_no = new JLabel("Регистрационен номер");
            newE.add(reg_no);
            reg_no.setBounds(50, 180, 200, 35);

            field_reg_no = new JTextField();
            newE.add(field_reg_no);
            field_reg_no.setBounds(50, 210, 300, 35);

            dp_no = new JLabel("ДП номер");
            newE.add(dp_no);
            dp_no.setBounds(50, 260, 200, 35);

            field_dp_no = new JTextField();
            newE.add(field_dp_no);
            field_dp_no.setBounds(50, 290, 300, 35);

            ok = new JButton("Създай");
            newE.add(ok);
            ok.addActionListener(this);
            ok.setBounds(250,500, 120, 30);

            cancel = new JButton("Отказвам се");
            newE.add(cancel);
            cancel.addActionListener(this);
            cancel.setBounds(450,500, 120, 30);

            newE.setVisible(true);
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

            MainScreen.main_tree.setVisible(false);
            MainScreen.TreeView();
            newE.setVisible(false);
        }
        if (e.getSource() == cancel) {
            newE.setVisible(false);
        }
    }
}
