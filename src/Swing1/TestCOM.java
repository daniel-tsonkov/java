package Swing1;

import com.fazecast.jSerialComm.SerialPort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public class TestCOM {
    public static void main(String[] args) throws IOException, InterruptedException {
        new MyFrame();
    }

    public static class MyFrame extends JFrame implements ActionListener {
        JLabel selectPort = new JLabel();
        JLabel statusLed = new JLabel();
        JComboBox runPort;
        JButton connectButton = new JButton();
        JButton disconnectButton = new JButton();
        JButton onButton = new JButton();
        JButton offButton = new JButton();
        String openPort;
        SerialPort sp;

        MyFrame() throws IOException {


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

            statusLed.setText("LED");
            statusLed.setFont(new Font("Arial", Font.PLAIN, 14));
            statusLed.setForeground(new Color(255, 255, 255));
            //statusLed.setVerticalTextPosition(JLabel.BOTTOM);

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
            leftPanel.setBounds(0, 0, 200, 540);
            leftPanel.setBackground(new Color(100, 100, 100));

            JPanel rightPanel = new JPanel();
            rightPanel.setBounds(585, 0, 200, 540);
            rightPanel.setBackground(new Color(100, 100, 100));

            JPanel statusPanel = new JPanel();
            statusPanel.setBounds(0, 541, 785, 20);
            statusPanel.setBackground(new Color(100, 100, 100));

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
            statusPanel.add(statusLed);
            leftPanel.add(runPort);
            leftPanel.add(connectButton);
            leftPanel.add(disconnectButton);
            rightPanel.add(onButton);
            rightPanel.add(offButton);
            frame.add(leftPanel);
            frame.add(statusPanel);
            frame.add(rightPanel);
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TestCOM.class.getResource("/icon.jpg")));

        }
        void readBytes() {
            byte[] readBuffer = new byte[10];
            sp.readBytes(readBuffer, readBuffer.length);
            String isLedOn = null; //convert bytes to String
            try {
                isLedOn = new String(readBuffer, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            isLedOn = isLedOn.replace("\n", "").replace("\r", "").replace("\0", "");
            System.out.println("LED -> "+ isLedOn);
            statusLed.setText("LED " + isLedOn);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == runPort) {
                openPort = runPort.getSelectedItem().toString();
            }
            if (e.getSource() == connectButton) {
                sp = SerialPort.getCommPort(openPort);//COM9
                sp.setComPortParameters(9600, 8, 1, 0); // default connection settings for Arduino
                sp.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0); // block until bytes can be written TIMEOUT_READ_SEMI_BLOCKING

                if (sp.openPort()) {
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
                byte[] WriteByte = {111, 110}; //on
                sp.writeBytes(WriteByte, 2);
                readBytes();
            }
            if (e.getSource() == offButton) { //off
                byte[] WriteByte = {111, 102, 102};
                sp.writeBytes(WriteByte, 3);
                readBytes();
            }
        }
    }
}