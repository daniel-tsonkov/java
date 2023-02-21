package Razni.TestTree;

import VDSystem.MainScreen;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Functional extends JFrame implements MouseListener {
    JTree myTree;
    JPanel tree_panell;
    public Functional(){
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/icon.jpg")));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tree_panell = new JPanel();
        tree_panell.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        tree_panell.setPreferredSize(new Dimension(150, 300));
        tree_panell.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(tree_panell, BorderLayout.WEST);

        JPanel label_panell = new JPanel();
        label_panell.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        label_panell.setPreferredSize(new Dimension(150, 300));
        label_panell.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(label_panell, BorderLayout.EAST);

        DefaultMutableTreeNode edno = new DefaultMutableTreeNode("Edno");
        DefaultMutableTreeNode dve = new DefaultMutableTreeNode("Dve");
        DefaultMutableTreeNode tri = new DefaultMutableTreeNode("Tri");

        JTextField myText = new JTextField(40);
        label_panell.add(myText);
        myText.setBounds(50, 50, 300, 35);

        myTree = new JTree(edno);
        edno.add(dve);
        edno.add(tri);
        tree_panell.add(myTree);


        this.setVisible(true);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) myTree.getSelectionPath().getLastPathComponent();
        String mySelectedNode = selectedNode.getUserObject().toString();
        System.out.println(mySelectedNode);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        /*DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) myTree.getSelectionPath().getLastPathComponent();
        String mySelectedNode = selectedNode.getUserObject().toString();
        System.out.println(mySelectedNode);*/
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        /*DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) myTree.getSelectionPath().getLastPathComponent();
        String mySelectedNode = selectedNode.getUserObject().toString();
        System.out.println(mySelectedNode);*/
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        /*DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) myTree.getSelectionPath().getLastPathComponent();
        String mySelectedNode = selectedNode.getUserObject().toString();
        System.out.println(mySelectedNode);*/
    }

    @Override
    public void mouseExited(MouseEvent e) {
        /*DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) myTree.getSelectionPath().getLastPathComponent();
        String mySelectedNode = selectedNode.getUserObject().toString();
        System.out.println(mySelectedNode);*/
    }
}
