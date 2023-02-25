package VDSystem;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.*;

public class RenameObject extends JFrame implements ActionListener, KeyListener, WindowListener {
    JLabel newNameObjectLabel;
    JTextField newNameObjectText;
    JButton ok;
    JButton cancel;

    MainScreen mainScreen;

    public RenameObject(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
        this.setLocationRelativeTo(null);
        this.setSize(330, 240);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("resources/favicon.png")));
        this.setTitle("Преименуване на обект");
        this.setLayout(null);
        this.setVisible(true);

        newNameObjectLabel = new JLabel("Ново име");
        this.add(newNameObjectLabel);
        newNameObjectLabel.setBounds(30, 20, 200, 35);

        newNameObjectText = new JTextField();
        newNameObjectText.setText(MainScreen.myNode);
        newNameObjectText.setForeground(new Color(255, 0, 0));
        newNameObjectText.setFont(new Font(null, Font.PLAIN, 24));
        this.add(newNameObjectText);
        newNameObjectText.setBounds(30, 60, 250, 35);

        ok = new JButton("Преименувай");
        this.add(ok);
        ok.addActionListener(this);
        ok.setBounds(30, 140, 120, 30);

        cancel = new JButton("Отказвам се");
        this.add(cancel);
        cancel.addActionListener(this);
        cancel.setBounds(160, 140, 120, 30);

        newNameObjectText.addKeyListener(this);
        this.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            OkButton();
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
        System.out.println("From X");
        mainScreen.setEnabled(true);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //System.out.println("From button");
        /*frame.toFront();
        frame.requestFocus();
        frame.setEnabled(true);*/
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
            OkButton();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void OkButton() {
        mainScreen.setEnabled(true);
        this.dispose();

        DefaultMutableTreeNode nodeForRename = (DefaultMutableTreeNode) MainScreen.main_tree.getSelectionPath().getLastPathComponent();
        nodeForRename.setUserObject(newNameObjectText.getText());

        DefaultTreeModel model = (DefaultTreeModel) MainScreen.main_tree.getModel();
        model.reload();

        for (int i = 0; i < MainScreen.main_tree.getRowCount(); i++) {
            MainScreen.main_tree.expandRow(i);
        }
    }
}
