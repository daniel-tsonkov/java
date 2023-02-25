package VDSystem;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.TextAttribute;
import java.io.File;
import java.util.Map;


public class MainScreen extends JFrame implements ActionListener, KeyListener {//, MouseListener {
    static String nameProgram = "Onaya programa v1.0.0";
    JMenuBar menuBar;
    JMenu file_menu, edin_menu, tools_menu, help_menu;
    JMenuItem new_item, open_item, save_item, exit_item, cut_item, copy_item, paste_item, settings_item, manual_item, version_item;
    JToolBar toolBar, text_tools;
    static JButton new_work, open_work, color_buton, bold_buton, italic_buton, underline_buton, new_object, new_evidence, rename_object, remove_evidence, generate_expertise, expand_tree, colapse_tree;
    static JComboBox select_object, font_box;
    static JTextField other_object;
    static JTree main_tree;
    static JPanel tree_panell, text_panel;
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
        TextTools();
        TabsProtokol();
        //addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == new_item) {
            NewWork();
        }

        if (e.getSource() == open_item) {
            OpenWork();
        }

        if (e.getSource() == save_item) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }
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

        if (e.getSource() == open_work) {
            OpenWork();
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

        if (e.getSource() == color_buton) {
            JColorChooser colorChooser = new JColorChooser();
            Color color = colorChooser.showDialog(null, "Цвят на текст", Color.black);
            //textArea.setForeground(color);
            color_buton.setForeground(color);
        }

        if (e.getSource() == font_box) {
            //textArea.setFont(new Font((String)font_box.getSelectedItem(), Font.PLAIN, textArea.getFont().getSize()));
        }

        if(e.getSource() == manual_item) {
            Manual manual = new Manual(this);
            this.setEnabled(false);
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
        this.setLayout(new BorderLayout());
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/favicon.png")));
        this.setTitle(nameProgram);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(this);
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
        tools_menu = new JMenu("Tools");
        tools_menu.setMnemonic(KeyEvent.VK_T);
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
        settings_item = new JMenuItem("Настройки");
        manual_item = new JMenuItem("Ръководство");
        version_item = new JMenuItem("Версия");

        this.setJMenuBar(menuBar);

        menuBar.add(file_menu);
        menuBar.add(edin_menu);
        menuBar.add(tools_menu);
        menuBar.add(help_menu);

        file_menu.add(new_item);
        file_menu.add(open_item);
        file_menu.add(save_item);
        file_menu.add(new JSeparator());
        file_menu.add(exit_item);
        edin_menu.add(cut_item);
        edin_menu.add(copy_item);
        edin_menu.add(paste_item);
        tools_menu.add(settings_item);
        help_menu.add(manual_item);
        help_menu.add(version_item);

        open_item.addActionListener(this);
        save_item.addActionListener(this);
        new_item.addActionListener(this);
        exit_item.addActionListener(this);
        manual_item.addActionListener(this);
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
        new_work.setFocusable(false);
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
        toolBar.addSeparator(new Dimension(100, 25));
        //ekspertiza = new JLabel();
        //toolBar.add(ekspertiza);
        generate_expertise = new JButton("Генерирай експертиза");
        generate_expertise.setEnabled(false);
        generate_expertise.setFocusable(false);
        toolBar.add(generate_expertise);
        Container pane = this.getContentPane(); //add to JPane toolbar
        pane.add(toolBar, BorderLayout.NORTH);

        new_work.addActionListener(this);
        open_work.addActionListener(this);
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

    private void TextTools() {
        text_panel = new JPanel();
        text_panel.setLayout(new BorderLayout());
        text_panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.add(text_panel);
        text_tools = new JToolBar();

        JLabel font_size_label = new JLabel("Size");
        font_size_label.setBounds(0, 0, 200, 35);
        text_tools.add(font_size_label);

        text_tools.addSeparator(new Dimension(5, 25));

        JSpinner font_size_spiner = new JSpinner();
        font_size_spiner.setValue(20);
        font_size_spiner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

            }
        });
        text_tools.add(font_size_spiner);

        text_tools.addSeparator(new Dimension(15, 25));

        color_buton = new JButton("Цвят");
        //color_buton.setLayout(null);
        color_buton.setPreferredSize(new Dimension(40, 25));
        color_buton.setMargin(new Insets(0, 0, 2, 2));
        text_tools.add(color_buton);

        text_tools.addSeparator(new Dimension(15, 25));

        bold_buton = new JButton("B");
        bold_buton.setFont(bold_buton.getFont().deriveFont(Font.BOLD));
        bold_buton.setPreferredSize(new Dimension(25, 25));
        text_tools.add(bold_buton);

        italic_buton = new JButton("I");
        italic_buton.setFont(italic_buton.getFont().deriveFont(Font.ITALIC));
        italic_buton.setLayout(null);
        italic_buton.setLocation(1000, 0);
        italic_buton.setPreferredSize(new Dimension(25, 25));
        text_tools.add(italic_buton);

        underline_buton = new JButton("U");
        Font font = underline_buton.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        underline_buton.setFont(font.deriveFont(attributes));

        underline_buton.setLayout(null);
        underline_buton.setLocation(1000, 0);
        underline_buton.setPreferredSize(new Dimension(25, 25));
        text_tools.add(underline_buton);

        text_tools.addSeparator(new Dimension(15, 25));

        JLabel size_label = new JLabel("Font");
        size_label.setBounds(0, 0, 200, 25);
        text_tools.add(size_label);

        text_tools.addSeparator(new Dimension(5, 25));

        String[] available_fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        font_box = new JComboBox(available_fonts);
        font_box.setFocusCycleRoot(false);
        font_box.setSelectedItem("Arial");
        text_tools.add(font_box);

        text_tools.addSeparator(new Dimension(550, 25));

        color_buton.addActionListener(this);
        font_box.addActionListener(this);
        Container textpane = text_panel; //add to JPane toolbar
        textpane.add(text_tools, BorderLayout.NORTH);
        font_size_spiner.setEnabled(false);
        color_buton.setEnabled(false);
        bold_buton.setEnabled(false);
        italic_buton.setEnabled(false);
        underline_buton.setEnabled(false);
        font_box.setEnabled(false);
    }

    private void TabsProtokol() {
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        protocol = new JTabbedPane();

        protocol.add("Възложител", panel1);
        panel1.setBackground(Color.white);
        protocol.add("Дата на получаване", panel2);
        panel2.setBackground(Color.white);
        protocol.add("Обстоятелства по делото", panel3);
        panel3.setBackground(Color.white);
        protocol.add("Обекти на експертизата", panel4);
        panel4.setBackground(Color.white);
        protocol.add("Задачи на експертизата", panel5);
        panel5.setBackground(Color.white);

        text_panel.add(protocol, BorderLayout.CENTER);
        //protocol.setBorder(BorderFactory.createLineBorder(Color.green));
        protocol.setVisible(false);
    }

    private void OpenWork() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.getIcon(new File("open.png"));//setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/favicon.png")));
        int response = fileChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            System.out.println(file);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}