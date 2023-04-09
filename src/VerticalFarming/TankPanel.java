package VerticalFarming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TankPanel extends JPanel implements ActionListener {
    Timer timer;
    int tempValueForExample = 1;

    TankPanel() {
        this.setPreferredSize(new Dimension(335, 290));
        this.setBackground(new Color(0, 0, 0));

        timer = new Timer(1000, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2D = (Graphics2D) g;

        int levelWater = 250 - (MainScreen.tankFill * 2);

        g2D.setPaint(new Color(98, 205, 255));
        g2D.fillRect(50, levelWater, 230, 250 - levelWater);
        g2D.fillOval(50, 228, 230, 50);
        g2D.setPaint(new Color(185, 233, 252));
        g2D.fillOval(50, levelWater - 25, 230, 50);

        g2D.setPaint(new Color(155, 155, 155));
        g2D.setStroke(new BasicStroke(3));
        g2D.drawLine(50, 50, 50, 250);
        g2D.drawLine(280, 50, 280, 250);
        g2D.drawOval(50, 25, 230, 50);
        g2D.drawArc(50, 228, 230, 50, 180, 180);

        g2D.setPaint(new Color(155, 155, 0));
        g2D.setFont(new Font(null, Font.BOLD, 30));
        g2D.drawString(MainScreen.tankFill + "%", 140, 150);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((MainScreen.tankFill == 0) || (MainScreen.tankFill == 100)){
            tempValueForExample = tempValueForExample * (-1);
        }
        MainScreen.tankFill = MainScreen.tankFill - tempValueForExample;

        //MainScreen.statusLed.setText(String.valueOf((MainScreen.tankFill)));

        if((MainScreen.tankFill % 2) == 0){
            MainScreen.array2dtop[100 - 1].setBackground(Color.RED);
            MainScreen.array2dtop[50 - 1].setBackground(UIManager.getColor("Button.background"));
        } else {
            MainScreen.array2dtop[50 - 1].setBackground(Color.GREEN);
            MainScreen.array2dtop[100 - 1].setBackground(UIManager.getColor("Button.background"));
        }
        repaint();
    }
}
