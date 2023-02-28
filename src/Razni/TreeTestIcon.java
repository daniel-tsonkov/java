package Razni;

import VDSystem.MainScreen;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class TreeTestIcon {
    public static void main(String[] args) {
        UIManager.put("Tree.openIcon", new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("resources/xlsx_icon.png"))));

        JFrame frame = new JFrame("JTreeSample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Vector<String> v1 = new TreeNodeVector<String>("Two", new String[] { "Mercury", "Venus",
                "Mars" });
        Vector<Object> v2 = new TreeNodeVector<Object>("Three");
        v2.add(System.getProperties());
        v2.add(v1);
        Object rootNodes[] = {v1, v2 };
        Vector<Object> rootVector = new TreeNodeVector<Object>("Root", rootNodes);
        JTree tree = new JTree(rootVector);
        frame.add(new JScrollPane(tree), BorderLayout.WEST);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
class TreeNodeVector<E> extends Vector<E> {
    String name;

    TreeNodeVector(String name) {
        this.name = name;
    }

    TreeNodeVector(String name, E elements[]) {
        this.name = name;
        for (int i = 0, n = elements.length; i < n; i++) {
            add(elements[i]);
        }
    }

    public String toString() {
        return "[" + name + "]";
    }
}