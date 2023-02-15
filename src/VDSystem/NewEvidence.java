package VDSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewEvidence implements ActionListener {
    JFrame newEvidence;
    JLabel dp_no;
    JTextField field_dp_no;
    JButton ok;
    JButton cancel;

    public NewEvidence() {
        newEvidence = new JFrame();
        newEvidence.setLocationRelativeTo(null);
        newEvidence.setSize(800, 600);
        newEvidence.setLocationRelativeTo(null);
        newEvidence.setResizable(false);
        newEvidence.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/icon.jpg")));
        newEvidence.setTitle("Нова експертиза");
        newEvidence.setLayout(null);


        dp_no = new JLabel("Друго ВД");
        newEvidence.add(dp_no);
        dp_no.setBounds(50, 260, 200, 35);

        field_dp_no = new JTextField();
        newEvidence.add(field_dp_no);
        field_dp_no.setBounds(50, 290, 300, 35);

        ok = new JButton("Създай");
        newEvidence.add(ok);
        ok.addActionListener(this);
        ok.setBounds(250, 500, 120, 30);

        cancel = new JButton("Отказвам се");
        newEvidence.add(cancel);
        cancel.addActionListener(this);
        cancel.setBounds(450, 500, 120, 30);

        newEvidence.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            newEvidence.setVisible(false);
        }
        if (e.getSource() == cancel) {
            newEvidence.setVisible(false);
        }
    }
}
