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

        //--TANK
        g2D.setPaint(new Color(98, 205, 255));
        g2D.fillRect(30, levelWater, 200, 250 - levelWater);
        g2D.fillOval(30, 228, 200, 50);
        g2D.setPaint(new Color(185, 233, 252));
        g2D.fillOval(30, levelWater - 25, 200, 50);

        g2D.setPaint(new Color(155, 155, 155));
        g2D.setStroke(new BasicStroke(2));
        g2D.drawLine(30, 50, 30, 250);
        g2D.drawLine(230, 50, 230, 250);
        g2D.drawOval(30, 25, 200, 50);
        g2D.drawArc(30, 228, 200, 50, 180, 180);

        g2D.setPaint(new Color(155, 155, 155));
        g2D.setFont(new Font(null, Font.BOLD, 30));
        g2D.drawString(MainScreen.tankFill + "%", 105, 160);

        //--PUMP
        g2D.setPaint(new Color(200, 0, 0));
        g2D.fillOval(260, 205, 50, 50);
        g2D.setPaint(new Color(200, 200, 200));
        g2D.drawRect(255, 190, 27, 8);
        g2D.drawLine(260, 200, 260, 230);
        g2D.drawLine(277, 200, 277, 205);
        g2D.drawOval(260, 205, 50, 50);
        g2D.drawOval(275, 220, 20, 20);
        g2D.drawLine(270, 263, 278, 255);
        g2D.drawLine(301, 263, 293, 255);
        g2D.drawRect(269, 263, 33, 6);

        //--VALVE
        g2D.setPaint(new Color(200, 0, 0));
        g2D.fillRect(282, 102, 30, 40);
        g2D.setPaint(new Color(200, 200, 200));
        g2D.drawRect(282, 102, 30, 40);
        g2D.drawString("S", 287, 132);
        g2D.drawLine(252, 90, 282, 155);
        g2D.drawLine(282, 90, 252, 155);
        g2D.drawLine(252, 90, 282, 90);
        g2D.drawLine(282, 155, 252, 155);
        g2D.drawLine(267, 122, 282, 122);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*if((MainScreen.tankFill == 0) || (MainScreen.tankFill == 100)){
            tempValueForExample = tempValueForExample * (-1);
        }
        MainScreen.tankFill = MainScreen.tankFill - tempValueForExample;*/
        if (MainScreen.myKey.equals(MainScreen.tankMacAddress)) {
            MainScreen.tankFill = Integer.parseInt(MainScreen.myValue);
        }

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
