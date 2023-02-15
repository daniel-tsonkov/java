package VDSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewExpertiсе implements ActionListener {
    JFrame newE;
    JLabel no_expertise;
    JTextField field_experttise;
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

            field_experttise = new JTextField();
            newE.add(field_experttise);
            field_experttise.setBounds(50, 50, 300, 35);

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
            newE.setVisible(false);
        }
        if (e.getSource() == cancel) {
            newE.setVisible(false);
        }
    }
}
