package VDSystem;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu file_menu;
    JMenu edin_menu;
    JMenu help_menu;
    JMenuItem new_item;
    JMenuItem open_item;
    JMenuItem exit_item;
    JMenuItem cut_item;
    JMenuItem copy_item;
    JMenuItem paste_item;
    JMenuItem version_item;
    JToolBar toolBar;
    JButton new_work;
    JButton open_work;
    JButton new_object;
    JButton new_evidence;
    JComboBox select_object;
    JTextField other_object;
    JButton remove_evidence;
    JButton generate_expertise;
    JTree main_tree;
    JTabbedPane protocol;
    String expertise = "Няма име";
    String s_item;
    int numberObject = 1;

    DefaultMutableTreeNode new_expertise;

    public MainScreen() {

        //Screen property
        {
            this.setLocationRelativeTo(null);
            this.setSize(1024, 768);
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            //this.setResizable(false);
            this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/icon.jpg")));
            this.setTitle("Onaya programa v1.0.0");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //this.getContentPane().setBackground(new Color(0, 0, 0));
            //this.setLayout(null);
        }
        // Menubar
        {
            menuBar = new JMenuBar();

            file_menu = new JMenu("File");
            edin_menu = new JMenu("Edit");
            help_menu = new JMenu("Help");

            new_item = new JMenuItem("Нова експертиза");
            open_item = new JMenuItem("Отвори експертиза");
            exit_item = new JMenuItem("Exit");
            cut_item = new JMenuItem("Cut");
            copy_item = new JMenuItem("Copy");
            paste_item = new JMenuItem("Paste");
            version_item = new JMenuItem("Версия");

            this.setJMenuBar(menuBar);

            menuBar.add(file_menu);
            menuBar.add(edin_menu);
            menuBar.add(help_menu);

            file_menu.add(new_item);
            file_menu.add(open_item);
            file_menu.add(exit_item);
            edin_menu.add(cut_item);
            edin_menu.add(copy_item);
            edin_menu.add(paste_item);
            help_menu.add(version_item);


            exit_item.addActionListener(this);
            version_item.addActionListener(this);
        }
        //Toolbar
        {
            toolBar = new JToolBar();
            new_work = new JButton("Нова експертиза");
            toolBar.add(new_work);
            open_work = new JButton("Отвори експертиза");
            toolBar.add(open_work);
            toolBar.addSeparator(new Dimension(20, 25));
            new_object = new JButton("Нов обект");
            toolBar.add(new_object);
            new_evidence = new JButton("Ново ВД");
            toolBar.add(new_evidence);
            String[] objects = {"GSM", "SIM", "MMC", "Tablet", "Флаш", "GSM Рутер", "GPS", "Друго"};
            select_object = new JComboBox(objects);
            toolBar.add(select_object);
            other_object = new JTextField();
            other_object.getText();
            other_object.setText("Друг обект");
            toolBar.add(other_object);
            other_object.setEditable(false);
            remove_evidence = new JButton("Премахни обект");
            toolBar.add(remove_evidence);
            toolBar.add(Box.createHorizontalGlue());
            toolBar.addSeparator(new Dimension(20, 25));
            generate_expertise = new JButton("Генерирай експертиза");
            toolBar.add(generate_expertise);
            Container pane = this.getContentPane(); //add to JPane toolbar
            pane.add(toolBar, BorderLayout.NORTH);
            select_object.addActionListener(this);
            new_object.addActionListener(this);
            new_evidence.addActionListener(this);
            new_work.addActionListener(this);
            remove_evidence.addActionListener(this);
        }
        //Tree view
        {
            new_expertise = new DefaultMutableTreeNode(expertise);
            /*new_expertise = new DefaultMutableTreeNode(expertise);
            DefaultMutableTreeNode protokol = new DefaultMutableTreeNode("Протокол");
            DefaultMutableTreeNode evidence = new DefaultMutableTreeNode("Обект " + numberObject);
            DefaultMutableTreeNode PUK = new DefaultMutableTreeNode("ПУК код");

            new_expertise.add(protokol);
            new_expertise.add(PUK);
            new_expertise.add(evidence);

            DefaultMutableTreeNode info = new DefaultMutableTreeNode("Инфо");
            DefaultMutableTreeNode GSM = new DefaultMutableTreeNode("Телефон");
            DefaultMutableTreeNode SIM = new DefaultMutableTreeNode("СИМ карта");

            evidence.add(info);
            evidence.add(GSM);
            evidence.add(SIM);*/

            main_tree = new JTree(new_expertise);
            main_tree.setShowsRootHandles(true);

            main_tree.setRowHeight(30);
            this.add(main_tree);
            main_tree.setBounds(0, 60, 200, 900);
            main_tree.setVisible(true);
        }
        //Tabs protokol
        {
            JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();
            JPanel panel3 = new JPanel();
            JPanel panel4 = new JPanel();
            JPanel panel5 = new JPanel();

            protocol = new JTabbedPane();

            protocol.add("Възложител", panel1);
            protocol.add("Дата на получаване", panel2);
            protocol.add("Обстоятелства по делото", panel3);
            protocol.add("Обекти на експертизата", panel4);
            protocol.add("Задачи на експертизата", panel5);

            this.add(protocol);
            protocol.setBounds(300, 80, 1000, 900);
            protocol.setVisible(true);
        }
        this.setVisible(true);


    }
    /*public MainScreen(String expertise){
        this.expertise = expertise;
    }*/
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit_item) {
            this.dispose();
        }

        if (e.getSource() == new_object) {
            numberObject++;

            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) new_expertise;
            DefaultMutableTreeNode evidence1 = new DefaultMutableTreeNode("Обект " + numberObject);
            selectedNode.add(evidence1);

            DefaultTreeModel model = (DefaultTreeModel) main_tree.getModel();
            model.reload();
        }

        if (e.getSource() == new_work) {
            NewExpertiсе newExpertiсе = new NewExpertiсе();
        }

        if (e.getSource() == new_evidence) {
            /*DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) main_tree.getSelectionPath().getLastPathComponent();
            DefaultMutableTreeNode evidence1 = new DefaultMutableTreeNode("Обект " + numberObject);
            selectedNode.add(evidence1);
            DefaultTreeModel model = (DefaultTreeModel) main_tree.getModel();
            model.reload();*/
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) main_tree.getSelectionPath().getLastPathComponent();
            if (select_object.getSelectedItem().toString().equals("Друго")) {
                s_item = other_object.getText();
            }else{
                s_item = select_object.getSelectedItem().toString();
            }
            DefaultMutableTreeNode evidence1 = new DefaultMutableTreeNode(s_item);
            selectedNode.add(evidence1);

            DefaultTreeModel model = (DefaultTreeModel) main_tree.getModel();
            model.reload();
        }

        if (e.getSource() == select_object) {
            if (select_object.getSelectedItem().toString().equals("Друго")) {
                other_object.setEditable(true);
            }else{
                other_object.setEditable(false);
            }
        }

        if(e.getSource() == remove_evidence){
            int confirm_delete = JOptionPane.showConfirmDialog(null, "Сигурен ли си че искаш да го изтриеш?", "Изтриване", JOptionPane.YES_NO_OPTION);
            //System.out.println(confirm_delete);
            if(confirm_delete == 0){
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) main_tree.getSelectionPath().getLastPathComponent();
                DefaultTreeModel model = (DefaultTreeModel) main_tree.getModel();
                model.removeNodeFromParent(selectedNode);
            }

        }

        if(e.getSource() == version_item){
            JOptionPane.showMessageDialog(null, "Версия 1.0.0", "За програмата", JOptionPane.OK_OPTION);
        }
    }
}
