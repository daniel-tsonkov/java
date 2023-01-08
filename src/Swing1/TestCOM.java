package Swing1;

import com.fazecast.jSerialComm.SerialPort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class TestCOM {
    public static void main(String[] args) {
        new MyFrame();
    }

    public static class MyFrame extends JFrame implements ActionListener {
        JLabel selectPort = new JLabel();
        JComboBox runPort;

        MyFrame() {

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

            selectPort.setText("Select PORT");
            selectPort.setForeground(new Color(255, 255, 255));
            selectPort.setBounds(100, 100, 300, 300);

            JPanel leftPanel = new JPanel();
            leftPanel.setBounds(0, 0, 150, 550);
            leftPanel.setBackground(new Color(90, 90, 90));

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);
            frame.setSize(800, 600);
            frame.setVisible(true);
            frame.getContentPane().setBackground(new Color(42, 63, 84));
            frame.setTitle("COM Port Test");
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            leftPanel.add(selectPort);
            leftPanel.add(runPort);
            frame.add(leftPanel);
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TestCOM.class.getResource("/icon.jpg")));
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
                    selectPort.setText(openPort + " is open");
                } else {
                    System.out.println("Failed to open port :(");
                    selectPort.setText("Check again " + openPort);
                }
            }
        }
    }


}