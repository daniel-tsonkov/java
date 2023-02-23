package VDSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RenameObject implements ActionListener {
    JFrame newNameObject;
    JLabel oldNameObject;
    JLabel newNameObjectLabel;
    JTextField newNameObjectText;
    JButton ok;
    JButton cancel;
    public RenameObject(){
        newNameObject = new JFrame();
        newNameObject.setLocationRelativeTo(null);
        newNameObject.setSize(330, 240);
        newNameObject.setLocationRelativeTo(null);
        newNameObject.setResizable(false);
        newNameObject.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/icon.jpg")));
        newNameObject.setTitle("Преименуване на обект");
        newNameObject.setLayout(null);
        newNameObject.setVisible(true);

        newNameObjectLabel = new JLabel("Ново име");
        newNameObject.add(newNameObjectLabel);
        newNameObjectLabel.setBounds(30, 20, 200, 35);

        newNameObjectText = new JTextField();
        newNameObjectText.setText(MainScreen.myNode);
        newNameObjectText.setForeground(new Color(255, 0, 0));
        newNameObjectText.setFont(new Font(null, Font.PLAIN, 24));
        newNameObject.add(newNameObjectText);
        newNameObjectText.setBounds(30, 60, 250, 35);

        ok = new JButton("Преименувай");
        newNameObject.add(ok);
        ok.addActionListener(this);
        ok.setBounds(30,140, 120, 30);

        cancel = new JButton("Отказвам се");
        newNameObject.add(cancel);
        cancel.addActionListener(this);
        cancel.setBounds(160,140, 120, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            newNameObject.setVisible(false);
        }
        if (e.getSource() == cancel) {
            newNameObject.setVisible(false);
        }
    }
}
