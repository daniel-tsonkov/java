package VerticalFarming;

import javax.swing.*;
import java.awt.*;

public class TankPanel extends JPanel {
    TankPanel() {
        this.setPreferredSize(new Dimension(335, 290));
        this.setBackground(new Color(0, 0, 0));
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(new Color(155, 155, 155));
        g2D.setStroke(new BasicStroke(3));
        g2D.drawLine(50, 50, 50, 250);
        g2D.drawLine(280, 50, 280, 250);
        g2D.drawOval(50, 25, 230, 50);
        g2D.drawArc(50, 228, 230, 50, 180, 180);
    }
}
