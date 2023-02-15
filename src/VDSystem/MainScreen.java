package VDSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame implements ActionListener {
    {

    }
    JMenuBar menuBar;
    JMenu file_menu;
    JMenu edin_menu;
    JMenuItem new_item;
    JMenuItem open_item;
    JMenuItem exit_item;
    JMenuItem cut_item;
    JMenuItem copy_item;
    JMenuItem paste_item;
    JToolBar toolBar;
    JButton new_work;
    JButton opern_work;
    JButton generate_expertise;

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
            this.setVisible(true);
        }
        //Menubar
        {
            menuBar = new JMenuBar();

            file_menu = new JMenu("File");
            edin_menu = new JMenu("Edit");

            new_item = new JMenuItem("Нова експертиза");
            open_item = new JMenuItem("Отвори експертиза");
            exit_item = new JMenuItem("Exit");
            cut_item = new JMenuItem("Cut");
            copy_item = new JMenuItem("Copy");
            paste_item = new JMenuItem("Paste");

            this.setJMenuBar(menuBar);

            menuBar.add(file_menu);
            menuBar.add(edin_menu);

            file_menu.add(new_item);
            file_menu.add(open_item);
            file_menu.add(exit_item);
            edin_menu.add(cut_item);
            edin_menu.add(copy_item);
            edin_menu.add(paste_item);

            exit_item.addActionListener(this);
        }
        //Toolbar
        {
            toolBar = new JToolBar();
            new_work = new JButton("Нова експертиза");
            //new_work = new JButton("<html>" + "Нова" + "<br>" + "експертиза" + "</html>");
            //new_work.setSize(new Dimension(120, 40));
            opern_work = new JButton("Отвори експертиза");
            generate_expertise = new JButton("Генерирай експертиза");
            toolBar.add(new_work);
            toolBar.add(opern_work);
            toolBar.addSeparator(new Dimension(500, 45));
            toolBar.add(Box.createHorizontalGlue());
            toolBar.add(generate_expertise);

            Container pane = this.getContentPane(); //add to JPane toolbar
            pane.add(toolBar, BorderLayout.NORTH);
        }
        //Tree view
        {

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit_item){
            this.dispose();
        }
    }
}
