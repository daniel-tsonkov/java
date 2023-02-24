package VDSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewExpertiсе extends JFrame implements ActionListener, KeyListener, WindowListener {
    JLabel no_expertise, date_expertise, reg_no, dp_no, worket_label;
    JTextField field_expertise, field_date_expertise, field_reg_no, field_dp_no, worker_field;
    JButton ok;
    JButton cancel;

    MainScreen mainScreen;

    public NewExpertiсе(MainScreen mainScreen) {
        //Screen property
        {
            this.mainScreen = mainScreen;
            //newE = new JFrame();
            this.setLocationRelativeTo(null);
            this.setSize(350, 480);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/icon.jpg")));
            this.setTitle("Нова експертиза");
            this.setLayout(null);

            no_expertise = new JLabel("Номер на експертизата");
            this.add(no_expertise);
            no_expertise.setBounds(40, 15, 200, 35);

            field_expertise = new JTextField();
            this.add(field_expertise);
            field_expertise.setBounds(40, 40, 250, 35);

            date_expertise = new JLabel("Дата");
            this.add(date_expertise);
            date_expertise.setBounds(40, 80, 200, 35);

            field_date_expertise = new JTextField();
            this.add(field_date_expertise);
            field_date_expertise.setBounds(40, 105, 250, 35);

            reg_no = new JLabel("Регистрационен номер");
            this.add(reg_no);
            reg_no.setBounds(40, 145, 200, 35);

            field_reg_no = new JTextField();
            this.add(field_reg_no);
            field_reg_no.setBounds(40, 170, 250, 35);

            dp_no = new JLabel("ДП номер");
            this.add(dp_no);
            dp_no.setBounds(40, 215, 200, 35);

            field_dp_no = new JTextField();
            this.add(field_dp_no);
            field_dp_no.setBounds(40, 240, 250, 35);

            worket_label = new JLabel("Назначена от");
            this.add(worket_label);
            worket_label.setBounds(40, 285, 200, 35);

            worker_field = new JTextField();
            this.add(worker_field);
            worker_field.setBounds(40, 310, 250, 35);

            ok = new JButton("Създай");
            this.add(ok);
            ok.setBounds(40, 380, 120, 30);

            field_expertise.addKeyListener(this);
            field_date_expertise.addKeyListener(this);
            field_reg_no.addKeyListener(this);
            field_dp_no.addKeyListener(this);
            worker_field.addKeyListener(this);
            ok.addActionListener(this);

            cancel = new JButton("Отказвам се");
            this.add(cancel);
            cancel.addActionListener(this);
            cancel.setBounds(170, 380, 120, 30);

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
        //System.out.println("from X");
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
        String originalName = " - Onaya programa v1.0.0 ";
        if(field_expertise.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Попълни полетата", "Информация", JOptionPane.OK_OPTION);
        }else{
            MainScreen.expertise = field_expertise.getText();
            String nameProgram = field_expertise.getText() + originalName;
            MainScreen.nameProgram = field_expertise.getText();
            mainScreen.setTitle(nameProgram);

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
}
