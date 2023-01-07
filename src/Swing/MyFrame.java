package Swing;

import com.fazecast.jSerialComm.SerialPort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MyFrame extends JFrame implements ActionListener {
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        SerialPort[] s = SerialPort.getCommPorts();
        for (int i = 0; i < 5; i++) {
            
        }
        String[] ports = {"1", "2", "3"};
        JComboBox comboBox = new JComboBox(ports);

        this.add(comboBox);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
