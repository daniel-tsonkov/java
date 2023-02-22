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
        newNameObject.setSize(370, 330);
        newNameObject.setLocationRelativeTo(null);
        newNameObject.setResizable(false);
        newNameObject.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/icon.jpg")));
        newNameObject.setTitle("Преименуване на обект");
        newNameObject.setLayout(null);
        newNameObject.setVisible(true);

        oldNameObject = new JLabel("Старо име");
        oldNameObject.setHorizontalAlignment(SwingConstants.CENTER);
        //oldNameObject.setVerticalAlignment(20);
        newNameObject.add(oldNameObject);
        oldNameObject.setBounds(0, 20, 200, 35);

        oldNameObject = new JLabel(MainScreen.myNode);
        newNameObject.add(oldNameObject);
        oldNameObject.setForeground(new Color(255, 0, 0));
        oldNameObject.setBounds(150, 50, 200, 35);
        oldNameObject.setFont(new Font(null, Font.PLAIN, 24));

        newNameObjectLabel = new JLabel("Ново име");
        newNameObject.add(newNameObjectLabel);
        newNameObjectLabel.setBounds(50, 100, 200, 35);

        newNameObjectText = new JTextField();
        newNameObject.add(newNameObjectText);
        newNameObjectText.setBounds(50, 130, 250, 35);

        ok = new JButton("Създай");
        newNameObject.add(ok);
        ok.addActionListener(this);
        ok.setBounds(50,200, 120, 30);

        cancel = new JButton("Отказвам се");
        newNameObject.add(cancel);
        cancel.addActionListener(this);
        cancel.setBounds(180,200, 120, 30);
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
