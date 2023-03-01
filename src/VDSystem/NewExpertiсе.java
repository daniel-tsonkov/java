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
            this.setLocationRelativeTo(null);
            this.setSize(350, 480);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("resources/favicon.png")));
            this.setTitle("Нова експертиза");
            this.setLayout(null);

            no_expertise = new JLabel("Номер на експертизата");
            this.add(no_expertise);
            no_expertise.setBounds(40, 15, 200, 35);

            field_expertise = new JTextField("N/A");
            field_expertise.setBounds(40, 40, 250, 35);
            field_expertise.setForeground(new Color(250, 80, 80));
            field_expertise.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (field_expertise.getText().equals("N/A")) {
                        field_expertise.setText("");
                        field_expertise.setForeground(new Color(0, 0, 0));
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    field_expertise.setText(field_expertise.getText());
                    if (field_expertise.getText().equals("")) {
                        field_expertise.setText("N/A");
                        field_expertise.setForeground(new Color(250, 80, 80));
                    } else {
                        field_expertise.setForeground(new Color(0, 0, 0));
                    }
                }
            });
            this.add(field_expertise);

            date_expertise = new JLabel("Дата");
            date_expertise.setBounds(40, 80, 200, 35);
            this.add(date_expertise);

            field_date_expertise = new JTextField("N/A");
            field_date_expertise.setBounds(40, 105, 250, 35);
            field_date_expertise.setForeground(new Color(250, 80, 80));
            field_date_expertise.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (field_date_expertise.getText().equals("N/A")) {
                        field_date_expertise.setText("");
                        field_date_expertise.setForeground(new Color(0, 0, 0));
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    field_date_expertise.setText(field_date_expertise.getText());
                    if (field_date_expertise.getText().equals("")) {
                        field_date_expertise.setText("N/A");
                        field_date_expertise.setForeground(new Color(250, 80, 80));
                    } else {
                        field_date_expertise.setForeground(new Color(0, 0, 0));
                    }
                }
            });
            this.add(field_date_expertise);

            reg_no = new JLabel("Регистрационен номер");
            reg_no.setBounds(40, 145, 200, 35);
            this.add(reg_no);

            field_reg_no = new JTextField("N/A");
            field_reg_no.setBounds(40, 170, 250, 35);
            field_reg_no.setForeground(new Color(250, 80, 80));
            field_reg_no.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (field_reg_no.getText().equals("N/A")) {
                        field_reg_no.setText("");
                        field_reg_no.setForeground(new Color(0, 0, 0));
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    field_reg_no.setText(field_reg_no.getText());
                    if (field_reg_no.getText().equals("")) {
                        field_reg_no.setText("N/A");
                        field_reg_no.setForeground(new Color(250, 80, 80));
                    } else {
                        field_reg_no.setForeground(new Color(0, 0, 0));
                    }
                }
            });
            this.add(field_reg_no);

            dp_no = new JLabel("ДП номер");
            dp_no.setBounds(40, 215, 200, 35);
            this.add(dp_no);

            field_dp_no = new JTextField("N/A");
            field_dp_no.setBounds(40, 240, 250, 35);
            field_dp_no.setForeground(new Color(250, 80, 80));
            field_dp_no.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (field_dp_no.getText().equals("N/A")) {
                        field_dp_no.setText("");
                        field_dp_no.setForeground(new Color(0, 0, 0));
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    field_dp_no.setText(field_dp_no.getText());
                    if (field_dp_no.getText().equals("")) {
                        field_dp_no.setText("N/A");
                        field_dp_no.setForeground(new Color(250, 80, 80));
                    } else {
                        field_dp_no.setForeground(new Color(0, 0, 0));
                    }
                }
            });
            this.add(field_dp_no);

            worket_label = new JLabel("Назначена от");
            worket_label.setBounds(40, 285, 200, 35);
            this.add(worket_label);

            worker_field = new JTextField("N/A");
            worker_field.setBounds(40, 310, 250, 35);
            worker_field.setForeground(new Color(250, 80, 80));
            worker_field.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (worker_field.getText().equals("N/A")) {
                        worker_field.setText("");
                        worker_field.setForeground(new Color(0, 0, 0));
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    worker_field.setText(worker_field.getText());
                    if (worker_field.getText().equals("")) {
                        worker_field.setText("N/A");
                        worker_field.setForeground(new Color(250, 80, 80));
                    } else {
                        worker_field.setForeground(new Color(0, 0, 0));
                    }
                }
            });
            this.add(worker_field);

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
        if (field_expertise.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Попълни полетата", "Информация", JOptionPane.OK_OPTION);
        } else {
            String nameProgram = field_expertise.getText() + originalName;
            MainScreen.nameProgram = field_expertise.getText();
            mainScreen.setTitle(nameProgram);
            MainScreen.expertise = field_expertise.getText();
            MainScreen.date_expertise = field_date_expertise.getText();
            MainScreen.reg_no = field_reg_no.getText();
            MainScreen.dp_no = field_dp_no.getText();
            MainScreen.name_contractor = worker_field.getText();

            MainScreen.new_object.setEnabled(true);
            MainScreen.new_evidence.setEnabled(true);
            MainScreen.select_object.setEnabled(true);
            MainScreen.rename_object.setEnabled(true);
            MainScreen.remove_evidence.setEnabled(true);
            MainScreen.generate_expertise.setEnabled(true);
            MainScreen.expand_tree.setEnabled(true);
            MainScreen.colapse_tree.setEnabled(true);

            MainScreen.font_size_spiner.setEnabled(true);
            MainScreen.color_buton.setEnabled(true);
            MainScreen.bold_buton.setEnabled(true);
            MainScreen.italic_buton.setEnabled(true);
            MainScreen.underline_buton.setEnabled(true);
            MainScreen.font_box.setEnabled(true);

            MainScreen.main_tree.setModel(null);
            MainScreen.TreeView();
            mainScreen.setEnabled(true);
            this.dispose();

            SwingUtilities.updateComponentTreeUI(this);
            SwingUtilities.updateComponentTreeUI(mainScreen);
        }
    }
}
