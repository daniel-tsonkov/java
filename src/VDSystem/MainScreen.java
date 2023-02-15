package VDSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu file_menu;
    JMenu edin_menu;
    JMenuItem exit_item;
    JMenuItem cut_item;
    JMenuItem copy_item;
    JMenuItem paste_item;

    public MainScreen() {
        //Screen property
        {
            this.setLocationRelativeTo(null);
            this.setSize(800, 600);
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);

            this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/icon.jpg")));
            this.setTitle("Onaya programa");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.getContentPane().setBackground(new Color(0, 0, 0));
        }
        //Menubar
        {
            menuBar = new JMenuBar();

            file_menu = new JMenu("File");
            edin_menu = new JMenu("Edit");

            exit_item = new JMenuItem("Exit");
            cut_item = new JMenuItem("Cut");
            copy_item = new JMenuItem("Copy");
            paste_item = new JMenuItem("Paste");

            this.setJMenuBar(menuBar);

            menuBar.add(file_menu);
            menuBar.add(edin_menu);

            file_menu.add(exit_item);
            edin_menu.add(cut_item);
            edin_menu.add(copy_item);
            edin_menu.add(paste_item);

            exit_item.addActionListener(this);
        }
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit_item){
            this.dispose();
        }
    }
}
