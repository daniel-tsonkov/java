package VDSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewEvidence implements ActionListener {
    JFrame newEvidence;
    JLabel add_evidence;
    JRadioButton add_gsm;
    JRadioButton add_sim;
    JRadioButton add_mmc;
    JRadioButton add_tablet;
    JRadioButton add_flash;
    JLabel other_evidence;
    JTextField field_dp_no;
    JButton ok;
    JButton cancel;

    public NewEvidence() {

        newEvidence = new JFrame();
        newEvidence.setLocationRelativeTo(null);
        newEvidence.setSize(800, 600);
        newEvidence.setLocationRelativeTo(null);
        //newEvidence.setResizable(false);
        newEvidence.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/icon.jpg")));
        newEvidence.setTitle("Нова експертиза");
        newEvidence.setLayout(null);

        add_evidence = new JLabel("Вид ВД");
        newEvidence.add(add_evidence);
        add_evidence.setBounds(50, 20, 200, 35);

        add_gsm = new JRadioButton("GSM");
        add_sim = new JRadioButton("SIM");
        add_mmc = new JRadioButton("SD");
        add_tablet = new JRadioButton("Таблет");
        add_flash = new JRadioButton("Флаш памет");

        ButtonGroup new_evidences = new ButtonGroup();

        new_evidences.add(add_gsm);
        new_evidences.add(add_sim);
        new_evidences.add(add_mmc);
        new_evidences.add(add_tablet);
        new_evidences.add(add_flash);

        //newEvidence.add(add_gsm);
        //newEvidence.add(new_evidences);

        add_gsm = new JRadioButton("GSM");
        //birdButton.setMnemonic(KeyEvent.VK_B);
        add_gsm.setActionCommand("GSM");
        add_gsm.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(add_gsm);

        add_gsm.addActionListener(this);

        other_evidence = new JLabel("Друго ВД");
        newEvidence.add(other_evidence);
        other_evidence.setBounds(50, 260, 200, 35);

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

        //newEvidence.pack();
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
