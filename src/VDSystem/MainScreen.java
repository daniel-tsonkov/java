package VDSystem;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame implements ActionListener{//, MouseListener {
    static String nameProgram = "Onaya programa v1.0.0";
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
    JButton rename_object;
    JButton remove_evidence;
    JButton generate_expertise;
    static JTree main_tree;
    JButton expand_tree;
    JButton colapse_tree;
    static JPanel tree_panell;
    static JTabbedPane protocol;
    public static String expertise = "No Name";
    String s_item;
    int numberObject = 1;
    static String myNode;

    static DefaultMutableTreeNode new_expertise;

    public MainScreen() {
        //Screen property
        {
            this.setLocationRelativeTo(null);
            this.setSize(1024, 768);
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            //this.setResizable(false);
            this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/icon.jpg")));
            this.setTitle(nameProgram);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            new_work.setFocusable(false);
            toolBar.add(new_work);
            open_work = new JButton("Отвори експертиза");
            open_work.setFocusable(false);
            toolBar.add(open_work);
            toolBar.addSeparator(new Dimension(20, 25));
            new_object = new JButton("Нов обект");
            new_object.setFocusable(false);
            toolBar.add(new_object);
            new_evidence = new JButton("Ново ВД");
            new_evidence.setFocusable(false);
            toolBar.add(new_evidence);
            String[] objects = {"GSM", "SIM", "MMC", "Tablet", "Флаш", "GSM Рутер", "GPS", "Друго"};
            //select_object.setFocusable(false);!!!!!
            select_object = new JComboBox(objects);
            toolBar.add(select_object);
            other_object = new JTextField();
            other_object.getText();
            other_object.setText("Друг обект");
            toolBar.add(other_object);
            other_object.setEditable(false);
            rename_object = new JButton("Преименувай обект");
            rename_object.setFocusable(false);
            toolBar.add(rename_object);
            remove_evidence = new JButton("Премахни обект");
            remove_evidence.setFocusable(false);
            toolBar.add(remove_evidence);
            toolBar.add(Box.createHorizontalGlue());
            toolBar.addSeparator(new Dimension(20, 25));
            //ekspertiza = new JLabel();
            //toolBar.add(ekspertiza);
            generate_expertise = new JButton("Генерирай експертиза");
            generate_expertise.setFocusable(false);
            toolBar.add(generate_expertise);
            Container pane = this.getContentPane(); //add to JPane toolbar
            pane.add(toolBar, BorderLayout.NORTH);
            select_object.addActionListener(this);
            new_object.addActionListener(this);
            new_evidence.addActionListener(this);
            new_work.addActionListener(this);
            rename_object.addActionListener(this);
            remove_evidence.addActionListener(this);
            generate_expertise.addActionListener(this);
        }
        //Tree view
        {
            tree_panell = new JPanel();
            tree_panell.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
            tree_panell.setPreferredSize(new Dimension(170, 900));
            tree_panell.setBorder(BorderFactory.createLineBorder(Color.black));
            tree_panell.setBackground(Color.white);//Da ne se trie!!!
            this.add(tree_panell, BorderLayout.WEST);

            JPanel buttons_tree = new JPanel();
            //buttons_tree.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            //buttons_tree.setBorder(BorderFactory.createLineBorder(Color.black));
            tree_panell.add(buttons_tree);


            expand_tree = new JButton("Разтегли");
            expand_tree.setFocusable(false);
            buttons_tree.add(expand_tree);
            colapse_tree = new JButton("Свий");
            buttons_tree.add(colapse_tree);

            //JSeparator separator = new JSeparator();
            tree_panell.add(new JSeparator());

            TreeView();
            expand_tree.addActionListener(this);
            colapse_tree.addActionListener(this);
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
            protocol.setVisible(false);
        }
        this.setVisible(true);
        //addMouseListener(this);
        //treeNodeSelect();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit_item) {
            this.dispose();
        }

        if (e.getSource() == new_object) {

            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) new_expertise;
            DefaultMutableTreeNode evidence1 = new DefaultMutableTreeNode("Обект " + numberObject);
            selectedNode.add(evidence1);

            DefaultMutableTreeNode infoFile = new DefaultMutableTreeNode("Инфо");
            evidence1.add(infoFile);
            s_item = select_object.getSelectedItem().toString();

            DefaultTreeModel model = (DefaultTreeModel) main_tree.getModel();
            model.reload();
            numberObject++;
            for (int i = 0; i < main_tree.getRowCount(); i++) {
                main_tree.expandRow(i);
            }
        }

        if (e.getSource() == new_work) {
            NewExpertiсе newExpertiсе = new NewExpertiсе();
            //this.setEnabled(false);
            numberObject = 1;
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
                DefaultMutableTreeNode evidence1 = new DefaultMutableTreeNode(s_item);
                selectedNode.add(evidence1);
            }else{
                s_item = select_object.getSelectedItem().toString();
                DefaultMutableTreeNode evidence1 = new DefaultMutableTreeNode(s_item);
                selectedNode.add(evidence1);
            }

            DefaultTreeModel model = (DefaultTreeModel) main_tree.getModel();
            model.reload();

            for (int i = 0; i < main_tree.getRowCount(); i++) {
                main_tree.expandRow(i);
            }
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
            if(confirm_delete == 0){
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) main_tree.getSelectionPath().getLastPathComponent();
                DefaultTreeModel model = (DefaultTreeModel) main_tree.getModel();
                model.removeNodeFromParent(selectedNode);
            }
        }

        if(e.getSource() == version_item){
            JOptionPane.showMessageDialog(null, "Версия 1.0.0", "За програмата", JOptionPane.OK_OPTION);
        }

        if(e.getSource() == generate_expertise){
        }

        if(e.getSource() == expand_tree){
            for (int i = 0; i < main_tree.getRowCount(); i++) {
                main_tree.expandRow(i);
            }
        }

        if(e.getSource() == colapse_tree){
            for (int i = 0; i < main_tree.getRowCount(); i++) {
                main_tree.collapseRow(i);
            }
        }
    }

    /*@Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("mouse double");
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) main_tree.getSelectionPath().getLastPathComponent();
        String mySelectedNode = selectedNode.getUserObject().toString();
        //System.out.println(mySelectedNode);
        if(mySelectedNode.equals("Протокол")) {
            protocol.setVisible(true);
        }else{
            protocol.setVisible(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("mouse pres");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("mouse real");
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }*/

    public static void TreeView(){
        new_expertise = new DefaultMutableTreeNode(expertise);
        DefaultMutableTreeNode protokol = new DefaultMutableTreeNode("Протокол");
        new_expertise.add(protokol);
        main_tree = new JTree(new_expertise);

        main_tree.setRowHeight(25);
        main_tree.setBounds(0, 0, 150, 900);
        tree_panell.add(main_tree, BorderLayout.WEST);
        main_tree.setVisible(true);
        main_tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //DefaultMutableTreeNode node = (DefaultMutableTreeNode) main_tree.getLastSelectedPathComponent();
                if(main_tree.getLastSelectedPathComponent() != null){
                    myNode = main_tree.getLastSelectedPathComponent().toString();
                    //System.out.println(myNode);
                    if(myNode.equals("Протокол")){
                        protocol.setVisible(true);//
                    }else {
                        protocol.setVisible(false);
                    }
                }
            }
        });

    }

    public static void treeNodeSelect(){
        main_tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                        main_tree.getLastSelectedPathComponent();
                //System.out.println(node);
                String myNode = node.toString();
                if(myNode.equals("Протокол")){
                    protocol.setVisible(true);
                }else {
                    protocol.setVisible(false);
                }
            }
        });
    }//Ne se polzva za sega!!!
}
