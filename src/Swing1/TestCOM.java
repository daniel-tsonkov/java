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
        JButton connectButton = new JButton();
        JButton disconnectButton = new JButton();
        JButton onButton = new JButton();
        JButton offButton = new JButton();
        String openPort;
        SerialPort sp;

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
            runPort.setPreferredSize(new Dimension(110, 30));
            runPort.addActionListener(this);

            selectPort.setText("Select PORT");
            selectPort.setFont(new Font("Arial", Font.PLAIN, 18));
            selectPort.setForeground(new Color(255, 255, 255));
            selectPort.setBounds(100, 100, 300, 300);

            connectButton.setText("Connect");
            connectButton.setFocusable(false);
            connectButton.setPreferredSize(new Dimension(90, 30));
            connectButton.addActionListener(this);

            disconnectButton.setText("Disconnect");
            disconnectButton.setFocusable(false);
            disconnectButton.setPreferredSize(new Dimension(100, 30));
            disconnectButton.setEnabled(false);
            disconnectButton.addActionListener(this);

            onButton.setText("on");
            onButton.setFocusable(false);
            onButton.setPreferredSize(new Dimension(90, 30));
            onButton.addActionListener(this);

            offButton.setText("off");
            offButton.setFocusable(false);
            offButton.setPreferredSize(new Dimension(90, 30));
            offButton.addActionListener(this);

            JPanel leftPanel = new JPanel();
            leftPanel.setBounds(0, 0, 200, 560);
            leftPanel.setBackground(new Color(90, 90, 90));

            JPanel rightPanel = new JPanel();
            rightPanel.setBounds(585, 0, 200, 560);
            rightPanel.setBackground(new Color(90, 90, 90));

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
            leftPanel.add(connectButton);
            leftPanel.add(disconnectButton);
            rightPanel.add(onButton);
            rightPanel.add(offButton);
            frame.add(leftPanel);
            frame.add(rightPanel);
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TestCOM.class.getResource("/icon.jpg")));
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == runPort) {
                openPort = runPort.getSelectedItem().toString();
            }
            if (e.getSource() == connectButton) {

                sp = SerialPort.getCommPort(openPort);//COM9
                sp.setComPortParameters(9600, 8, 1, 0); // default connection settings for Arduino
                sp.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0); // block until bytes can be written

                if (sp.openPort()) {
                    //connectButton.setText("Disconnect");
                    disconnectButton.setEnabled(true);
                    connectButton.setEnabled(false);
                    System.out.println(openPort + " is open :)");
                    selectPort.setText(openPort + " is open");
                } else {
                    System.out.println("Failed to open port :(");
                    selectPort.setText("Check again " + openPort);
                }
            }
            if (e.getSource() == disconnectButton) {
                if (sp.closePort()) {
                    //connectButton.setText("Connect");
                    disconnectButton.setEnabled(false);
                    connectButton.setEnabled(true);
                    System.out.println(openPort + " is closed :)");
                    selectPort.setText(openPort + " is closed");
                } else {
                    System.out.println("Failed to close port :(");
                    selectPort.setText("Check again " + openPort);
                }
            }

            if (e.getSource() == onButton) {
                byte[] WriteByte = new byte[2];
                WriteByte[0] = 111; //send A
                WriteByte[1] = 110; //send A


                int bytesTxed  = 0;

                bytesTxed  = sp.writeBytes(WriteByte,2);
            }
            if (e.getSource() == offButton) {
                byte[] WriteByte = new byte[3];
                WriteByte[0] = 111; //send A
                WriteByte[1] = 102; //send A
                WriteByte[2] = 102; //send A


                int bytesTxed  = 0;

                bytesTxed  = sp.writeBytes(WriteByte,3);
            }
        }
    }
}