package VDSystem;

import javax.swing.*;
import java.awt.*;

public class NewExpertiсе{
    JButton ok;

    public NewExpertiсе(){
        JFrame newE = new JFrame();
        newE.setLocationRelativeTo(null);
        newE.setSize(800, 600);

        newE.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/icon.jpg")));
        newE.setTitle("Нова експертиза");
        //newE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ok = new JButton("OK");
        //ok.addActionListener((ActionListener) newE);
        newE.setVisible(true);
    }
}
