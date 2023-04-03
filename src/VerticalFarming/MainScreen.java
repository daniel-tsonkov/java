package VerticalFarming;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;

public class MainScreen  extends JFrame implements ActionListener {
    JLabel selectPort = new JLabel();
    JLabel statusLed = new JLabel();
    JComboBox runPort;

    JButton connectButton = new JButton();
    JButton disconnectButton = new JButton();
    JButton onButton = new JButton();
    JButton offButton = new JButton();
    String openPort;
    SerialPort sp;
    OutputStream outputStream1;
    String receivedAnswers = "";

    MainScreen() {
        SerialPort[] s = SerialPort.getCommPorts();
        runPort = new JComboBox();

        runPort.removeAllItems();
        for (SerialPort port : s) {
            runPort.addItem(port.getSystemPortName());
        }
        runPort.setPreferredSize(new Dimension(110, 30));
        runPort.addActionListener(this);

        selectPort.setText("Select PORT");
        selectPort.setFont(new Font("Arial", Font.PLAIN, 18));
        selectPort.setForeground(new Color(255, 255, 255));
        selectPort.setBounds(100, 100, 300, 300);

        statusLed.setText("LED");
        //statusLed.setHorizontalAlignment(SwingConstants.LEFT);
        statusLed.setFont(new Font("Arial", Font.PLAIN, 12));
        statusLed.setForeground(new Color(255, 255, 255));
        //statusLed.setVerticalTextPosition(JLabel.BOTTOM);

        ImageIcon iconSettings = new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/VerticalFarming/resources/gear.png")));
        JButton settingsButton = new JButton(iconSettings);
        settingsButton.setPreferredSize(new Dimension(30, 30));
        settingsButton.setMargin(new Insets(0, 0, 0, 0));

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

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(20, 35));
        topPanel.setBackground(new Color(100, 100, 100));
        topPanel.setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        //leftPanel.setBounds(0, 0, 200, 540);
        leftPanel.setPreferredSize(new Dimension(200, 200));
        leftPanel.setBackground(new Color(100, 100, 100));

        JPanel rightPanel = new JPanel();
        //rightPanel.setBounds(585, 0, 200, 540);
        rightPanel.setPreferredSize(new Dimension(200, 200));
        rightPanel.setBackground(new Color(100, 100, 100));

        JPanel statusPanel = new JPanel();
        //statusPanel.setBounds(0, 541, 785, 20);
        statusPanel.setPreferredSize(new Dimension(20, 20));
        statusPanel.setBackground(new Color(100, 100, 100));

        JPanel workArea = new JPanel();
        workArea.setPreferredSize(new Dimension(200, 200));
        workArea.setBackground(new Color(0, 0, 0));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 768);
        this.setLayout(new BorderLayout(1, 2));
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(200, 200, 200));
        this.setTitle("COM Port Test");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        topPanel.add(settingsButton, BorderLayout.EAST);
        leftPanel.add(selectPort);
        statusPanel.add(statusLed);
        leftPanel.add(runPort);
        leftPanel.add(connectButton);
        leftPanel.add(disconnectButton);
        rightPanel.add(onButton);
        rightPanel.add(offButton);
        this.add(topPanel, BorderLayout.NORTH);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);
        this.add(statusPanel, BorderLayout.SOUTH);
        this.add(workArea, BorderLayout.CENTER);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/VerticalFarming/resources/leafs.png")));
    }

    public void incomingData() {
        sp.addDataListener(new SerialPortDataListener() {
            @Override
            public int getListeningEvents() {
                return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
            }

            @Override
            public void serialEvent(SerialPortEvent serialPortEvent) {
                byte[] newData = serialPortEvent.getReceivedData();

                for (byte b : newData) {
                    receivedAnswers += (char) b;
                }
                statusLed.setText("LED " + receivedAnswers);
                System.out.print(receivedAnswers);
            }
        });
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
            outputStream1 = sp.getOutputStream();
            String dataToSend = "";
            dataToSend = "on";
            try {
                outputStream1.write(dataToSend.getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == offButton) { //off
            outputStream1 = sp.getOutputStream();
            String dataToSend = "";
            dataToSend = "off";
            try {
                outputStream1.write(dataToSend.getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        receivedAnswers = "";
        if(sp != null) {
            incomingData();
        }
    }
}
