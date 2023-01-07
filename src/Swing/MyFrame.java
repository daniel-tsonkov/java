package Swing;

import com.fazecast.jSerialComm.SerialPort;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;


public class MyFrame extends JFrame implements ActionListener {
    JComboBox runPort;
    ImageIcon icon = new ImageIcon("/icon.jpg");
    JLabel statusPort = new JLabel();
    JPanel myPanel = new JPanel();

    MyFrame() {
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        this.setSize(800, 600);
        //this.setResizable(false);
        this.setVisible(true);
        this.setIconImage(icon.getImage());
        this.setTitle("COM Port Test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //this.myPanel.setSize(300, 300);
        this.myPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));
        this.myPanel.setBackground(Color.BLUE);
        this.add(myPanel);

        this.add(statusPort);
        statusPort.setText("Select PORT ");

        SerialPort[] s = SerialPort.getCommPorts();
        LinkedList<String> ports = new LinkedList<String>();

        for (SerialPort port : s) {
            ports.add(port.getSystemPortName());
        }
        String[] myPorts = new String[ports.size()];
        for (int i = 0; i < ports.size(); i++) {
            myPorts[i] = ports.get(i);
        }

        this.runPort = new JComboBox(myPorts);
        this.runPort.addActionListener(this);

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
                statusPort.setText(openPort + " is open");
            } else {
                System.out.println("Failed to open port :(");
                statusPort.setText("Check again " + openPort);
                return;
            }
        }
    }
}
