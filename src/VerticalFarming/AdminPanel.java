package VerticalFarming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AdminPanel extends JFrame implements ActionListener, MouseListener {

    public MainScreen mainScreen;

    JButton ok;
    JPanel selectPlant, addRemovePlant;
    JTabbedPane pane;
    JComboBox plantList;
    ImageIcon iconAdd = new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/VerticalFarming/resources/add.png")));
    ImageIcon iconAddPBlack = new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/VerticalFarming/resources/add-plant-black.png")));
    ImageIcon iconDelete = new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/VerticalFarming/resources/remove-plant.png")));
    ImageIcon iconDeleteBlack = new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/VerticalFarming/resources/delete-plant-black.png")));
    JButton addPlant = new JButton(iconAddPBlack);
    JButton removePlant = new JButton(iconDeleteBlack);

    public AdminPanel(VerticalFarming.MainScreen mainScreen) throws ClassNotFoundException {
        this.setUndecorated(true); //remove "Title bar"
        this.mainScreen = mainScreen;
        //this.setSize(1600, 950);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("resources/admin.png")));
        this.setTitle("Admin");
        this.setLayout(null);
        this.setVisible(true);

        pane = new JTabbedPane(JTabbedPane.LEFT);
        pane.setBounds(5, 5, 1700, 900);

        addRemovePlant = new JPanel();
        addRemovePlant.setOpaque(true);
        //addRemovePlant.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        addRemovePlant.setBorder(BorderFactory.createTitledBorder("Добави / премахни култура"));
        addRemovePlant.setPreferredSize(new Dimension(1600, 80));
        addRemovePlant.setLayout(null);

        addPlant.setFocusable(false);
        addPlant.setBounds(5, 20, 60, 55);
        addPlant.setMargin(new Insets(0, 0, 0, 0));
        addPlant.setBorder(BorderFactory.createEtchedBorder(0));
        addPlant.setVerticalTextPosition(SwingConstants.BOTTOM);
        addPlant.setHorizontalTextPosition(SwingConstants.CENTER);
        addPlant.setText("Add");
        addRemovePlant.add(addPlant);

        removePlant.setFocusable(false);
        removePlant.setBounds(65, 20, 60, 55);
        removePlant.setMargin(new Insets(0, 0, 0, 0));
        removePlant.setBorder(BorderFactory.createEtchedBorder(0));
        removePlant.setVerticalTextPosition(SwingConstants.BOTTOM);
        removePlant.setHorizontalTextPosition(SwingConstants.CENTER);
        removePlant.setText("Remove");
        addRemovePlant.add(removePlant);

        selectPlant = new JPanel();
        selectPlant.setOpaque(true);
        selectPlant.setBorder(BorderFactory.createTitledBorder("Избор на култура"));
        selectPlant.setPreferredSize(new Dimension(1600, 50));
        selectPlant.setLayout(null);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        panel2.add(addRemovePlant);
        panel2.add(selectPlant);

        pane.add("Потрбители", panel1);
        pane.add("Култури", panel2);
        pane.add("Empty", panel3);
        pane.add("Empty", panel4);
        pane.add("Empty", panel5);

        this.add(pane);
        pane.setVisible(true);
        this.add(pane);

        plantList = new JComboBox();
        plantList.setBounds(10, 20, 1500, 20);
        plantList.addItem("---");
        plantList.addItem("Тест");
        plantList.addActionListener(this);
        selectPlant.add(plantList);

        ok = new JButton("Затвори");
        this.add(ok);
        ok.setBounds(1530, 915, 120, 30);

        addPlant.addActionListener(this);
        addPlant.addMouseListener(this);
        removePlant.addActionListener(this);
        removePlant.addMouseListener(this);
        ok.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            mainScreen.setEnabled(true);
            this.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == addPlant) {
            addPlant.setIcon(iconAdd);
        }
        if (e.getSource() == removePlant) {
            removePlant.setIcon(iconDelete);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == addPlant) {
            addPlant.setIcon(iconAddPBlack);
        }
        if (e.getSource() == removePlant) {
            removePlant.setIcon(iconDeleteBlack);
        }
    }
}
