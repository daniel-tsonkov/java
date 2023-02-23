package VDSystem;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class MainScreen extends JFrame implements ActionListener {//, MouseListener {
    static String nameProgram = "Onaya programa v1.0.0";
    JMenuBar menuBar;
    JMenu file_menu, edin_menu, help_menu;
    JMenuItem new_item, open_item, save_item, exit_item, cut_item, copy_item, paste_item, manual_item, version_item;
    JToolBar toolBar;
    JButton new_work, open_work;
    static JButton new_object, new_evidence, rename_object, remove_evidence, generate_expertise, expand_tree, colapse_tree;
    static JComboBox select_object;
    static JTextField other_object;
    static JTree main_tree;
    static JPanel tree_panell;
    static JTabbedPane protocol;
    public static String expertise = "No Name";
    String s_item;
    int numberObject = 1;
    static String myNode;
    static DefaultMutableTreeNode new_expertise;
    ImageIcon new_file_icon;
    ImageIcon open_file_icon;
    ImageIcon save_file_icon;
    ImageIcon exit_program_icon;

    public MainScreen() {
        ScreenProperty();
        Menubar();
        ToolbarMenu();
        TreeViewMenu();
        TabsProtokol();
        //addMouseListener(this);
        //treeNodeSelect();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == new_item) {
            NewWork();
        }

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
            NewWork();
        }

        if (e.getSource() == new_evidence) {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) main_tree.getSelectionPath().getLastPathComponent();

            if (select_object.getSelectedItem().toString().equals("Друго")) {
                s_item = other_object.getText();
                DefaultMutableTreeNode evidence1 = new DefaultMutableTreeNode(s_item);
                selectedNode.add(evidence1);
            } else {
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
            } else {
                other_object.setEditable(false);
            }
        }

        if (e.getSource() == rename_object) {
            RenameObject renameObject = new RenameObject(this);
            this.setEnabled(false);
        }

        if (e.getSource() == remove_evidence) {
            if ((myNode.equals("Протокол")) || (myNode.equals("Инфо"))) {
                JOptionPane.showConfirmDialog(null, "Не можеш да изтриеш този файл!", "Изтриване", JOptionPane.DEFAULT_OPTION, 2, null);
            } else {
                int confirm_delete = JOptionPane.showConfirmDialog(null, "Сигурен ли си че искаш да го изтриеш?", "Изтриване", JOptionPane.YES_NO_OPTION);
                if (confirm_delete == 0) {
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) main_tree.getSelectionPath().getLastPathComponent();
                    DefaultTreeModel model = (DefaultTreeModel) main_tree.getModel();
                    model.removeNodeFromParent(selectedNode);
                }
            }
        }

        if (e.getSource() == generate_expertise) {
        }

        if (e.getSource() == expand_tree) {
            for (int i = 0; i < main_tree.getRowCount(); i++) {
                main_tree.expandRow(i);
            }
        }

        if (e.getSource() == colapse_tree) {
            for (int i = 0; i < main_tree.getRowCount(); i++) {
                main_tree.collapseRow(i);
            }
        }

        if (e.getSource() == version_item) {
            JOptionPane.showMessageDialog(null, "Версия 1.0.0", "За програмата", JOptionPane.OK_OPTION);
        }
    }

    /*@Override
    public void mouseClicked(MouseEvent e) {
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

    public static void TreeView() {
        new_expertise = new DefaultMutableTreeNode(expertise);
        if (!expertise.equals("No Name")) {
            DefaultMutableTreeNode protokol = new DefaultMutableTreeNode("Протокол");
            new_expertise.add(protokol);
        }
        main_tree = new JTree(new_expertise);
        main_tree.setRowHeight(25);
        main_tree.setBounds(0, 0, 150, 900);
        tree_panell.add(main_tree, BorderLayout.WEST);
        main_tree.setVisible(true);
        main_tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //DefaultMutableTreeNode node = (DefaultMutableTreeNode) main_tree.getLastSelectedPathComponent();
                if (main_tree.getLastSelectedPathComponent() != null) {
                    myNode = main_tree.getLastSelectedPathComponent().toString();
                    //System.out.println(myNode);
                    if (myNode.equals("Протокол")) {
                        protocol.setVisible(true);//
                    } else {
                        protocol.setVisible(false);
                    }
                }
            }
        });
    }

    private void ScreenProperty() {
        this.setSize(1280, 900);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/favicon.png")));
        this.setTitle(nameProgram);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void Menubar() {
        new_file_icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/newfile.png")));
        open_file_icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/openfile.png")));
        save_file_icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/savefile.png")));
        exit_program_icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/exit.png")));
        menuBar = new JMenuBar();

        file_menu = new JMenu("File");
        file_menu.setMnemonic(KeyEvent.VK_F);
        edin_menu = new JMenu("Edit");
        edin_menu.setMnemonic(KeyEvent.VK_E);
        help_menu = new JMenu("Help");
        help_menu.setMnemonic(KeyEvent.VK_H);

        new_item = new JMenuItem("Нова експертиза");
        new_item.setIcon(new_file_icon);
        open_item = new JMenuItem("Отвори експертиза");
        open_item.setIcon(open_file_icon);
        save_item = new JMenuItem("Запиши експертиза");
        save_item.setIcon(save_file_icon);
        exit_item = new JMenuItem("Exit");
        exit_item.setIcon(exit_program_icon);
        cut_item = new JMenuItem("Cut");
        copy_item = new JMenuItem("Copy");
        paste_item = new JMenuItem("Paste");
        manual_item = new JMenuItem("Ръководство");
        version_item = new JMenuItem("Версия");

        this.setJMenuBar(menuBar);

        menuBar.add(file_menu);
        menuBar.add(edin_menu);
        menuBar.add(help_menu);

        file_menu.add(new_item);
        file_menu.add(open_item);
        file_menu.add(save_item);
        file_menu.add(new JSeparator());
        file_menu.add(exit_item);
        edin_menu.add(cut_item);
        edin_menu.add(copy_item);
        edin_menu.add(paste_item);
        help_menu.add(manual_item);
        help_menu.add(version_item);

        new_item.addActionListener(this);
        exit_item.addActionListener(this);
        version_item.addActionListener(this);
    }

    private void NewWork() {
        if (expertise.equals("No Name")) {
            NewExpertiсе newExpertiсе = new NewExpertiсе(this);
            this.setEnabled(false);
        } else {
            int confirm_new = JOptionPane.showConfirmDialog(null, "Сигурен ли си че искаш нова експертиза", "Нова експериза", JOptionPane.YES_NO_OPTION);
            if (confirm_new == 0) {
                NewExpertiсе newExpertiсе = new NewExpertiсе(this);
                numberObject = 1;
                this.setEnabled(false);
            }
        }
    }

    private void ToolbarMenu() {
        toolBar = new JToolBar();
        new_work = new JButton("Нова експертиза");
        //new_work.setFocusable(false);
        toolBar.add(new_work);
        open_work = new JButton("Отвори експертиза");
        open_work.setFocusable(false);
        toolBar.add(open_work);
        toolBar.addSeparator(new Dimension(20, 25));
        new_object = new JButton("Нов обект");
        new_object.setEnabled(false);
        new_object.setFocusable(false);
        toolBar.add(new_object);
        new_evidence = new JButton("Ново ВД");
        new_evidence.setEnabled(false);
        new_evidence.setFocusable(false);
        toolBar.add(new_evidence);
        String[] objects = {"GSM", "SIM", "MMC", "Tablet", "Флаш", "GSM Рутер", "GPS", "Друго"};
        select_object = new JComboBox(objects);
        select_object.setEnabled(false);
        select_object.setFocusCycleRoot(false);
        toolBar.add(select_object);
        other_object = new JTextField();
        other_object.getText();
        other_object.setText("Друг обект");
        toolBar.add(other_object);
        other_object.setEditable(false);
        rename_object = new JButton("Преименувай обект");
        rename_object.setEnabled(false);
        rename_object.setFocusable(false);
        toolBar.add(rename_object);
        remove_evidence = new JButton("Премахни обект");
        remove_evidence.setEnabled(false);
        remove_evidence.setFocusable(false);
        toolBar.add(remove_evidence);
        toolBar.add(Box.createHorizontalGlue());
        toolBar.addSeparator(new Dimension(20, 25));
        //ekspertiza = new JLabel();
        //toolBar.add(ekspertiza);
        generate_expertise = new JButton("Генерирай експертиза");
        generate_expertise.setEnabled(false);
        generate_expertise.setFocusable(false);
        toolBar.add(generate_expertise);
        Container pane = this.getContentPane(); //add to JPane toolbar
        pane.add(toolBar, BorderLayout.NORTH);
        new_work.addActionListener(this);
        select_object.addActionListener(this);
        new_object.addActionListener(this);
        new_evidence.addActionListener(this);
        rename_object.addActionListener(this);
        remove_evidence.addActionListener(this);
        generate_expertise.addActionListener(this);
    }

    private void TreeViewMenu() {
        tree_panell = new JPanel();
        tree_panell.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        tree_panell.setPreferredSize(new Dimension(170, 900));
        tree_panell.setBorder(BorderFactory.createLineBorder(Color.black));
        tree_panell.setBackground(Color.white);
        this.add(tree_panell, BorderLayout.WEST);

        JPanel buttons_tree = new JPanel();
        buttons_tree.setBorder(BorderFactory.createLineBorder(Color.black));
        buttons_tree.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        tree_panell.add(buttons_tree);


        expand_tree = new JButton("Разтегли");
        expand_tree.setEnabled(false);
        expand_tree.setFocusable(false);
        buttons_tree.add(expand_tree);
        colapse_tree = new JButton("Свий");
        colapse_tree.setEnabled(false);
        buttons_tree.add(colapse_tree);

        TreeView();
        expand_tree.addActionListener(this);
        colapse_tree.addActionListener(this);
    }

    private void TabsProtokol() {
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

    public static void treeNodeSelect() {
        main_tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                        main_tree.getLastSelectedPathComponent();
                //System.out.println(node);
                String myNode = node.toString();
                if (myNode.equals("Протокол")) {
                    protocol.setVisible(true);
                } else {
                    protocol.setVisible(false);
                }
            }
        });
    }//Ne se polzva za sega!!!
}