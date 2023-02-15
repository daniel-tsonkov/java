package VDSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewExpertiсе implements ActionListener {
    JButton ok;
    JFrame newE;

    public NewExpertiсе() {
        newE = new JFrame();
        newE.setLocationRelativeTo(null);
        newE.setSize(800, 600);

        newE.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/icon.jpg")));
        newE.setTitle("Нова експертиза");
        //newE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ok = new JButton("OK");
        newE.add(ok);
        ok.addActionListener(this);
        newE.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            newE.setVisible(false);
        }
    }
}
