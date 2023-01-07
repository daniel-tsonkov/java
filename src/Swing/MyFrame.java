package Swing;

import com.fazecast.jSerialComm.SerialPort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;


public class MyFrame extends JFrame implements ActionListener {
    JComboBox runPort;

    MyFrame() {

        this.setIconImage();
        this.setTitle("COM Port Test");
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        SerialPort[] s = SerialPort.getCommPorts();
        LinkedList<String> ports = new LinkedList<String>();

        for (SerialPort port : s) {
            ports.add(port.getSystemPortName());
        }
        String[] myPorts = new String[ports.size()];
        for (int i = 0; i < ports.size(); i++) {
            myPorts[i] = ports.get(i);
        }

        runPort = new JComboBox(myPorts);
        runPort.addActionListener(this);

        this.add(runPort);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == runPort) {
            String openPort = runPort.getSelectedItem().toString();
            SerialPort sp = SerialPort.getCommPort(openPort);//COM9
            sp.setComPortParameters(9600, 8, 1, 0); // default connection settings for Arduino
            sp.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0); // block until bytes can be written

            if (sp.openPort()) {
                System.out.println(openPort + " is open :)");
            } else {
                System.out.println("Failed to open port :(");
                return;
            }
        }
    }
}
