package VerticalFarming;

import com.fazecast.jSerialComm.SerialPort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings  extends JFrame implements ActionListener {

    JLabel selectPort = new JLabel();
    JLabel statusLed = new JLabel();
    JComboBox runPort;
    JButton connectButton = new JButton();
    JButton disconnectButton = new JButton();
    JButton ok;

    public MainScreen mainScreen;
    public Settings(VerticalFarming.MainScreen mainScreen) throws ClassNotFoundException {
        this.mainScreen = mainScreen;
        this.setLocationRelativeTo(null);
        this.setSize(650, 480);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("resources/gear.png")));
        this.setTitle("Настройки");
        this.setLayout(null);
        this.setVisible(true);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
        tabbedPane.setBounds(5, 5, 630, 370);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        tabbedPane.add("Порт", panel1);
        tabbedPane.add("Empty", panel2);
        tabbedPane.add("Empty", panel3);
        tabbedPane.add("Empty", panel4);
        tabbedPane.add("Empty", panel5);

        this.add(tabbedPane, BorderLayout.CENTER);
        tabbedPane.setVisible(true);
        this.add(tabbedPane);

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
        selectPort.setForeground(new Color(10, 10, 10));
        selectPort.setBounds(100, 100, 300, 300);

        statusLed.setText("LED");
        statusLed.setFont(new Font("Arial", Font.PLAIN, 12));
        statusLed.setForeground(new Color(255, 255, 255));

        connectButton.setText("Connect");
        connectButton.setFocusable(false);
        connectButton.setPreferredSize(new Dimension(90, 30));

        disconnectButton.setText("Disconnect");
        disconnectButton.setFocusable(false);
        disconnectButton.setPreferredSize(new Dimension(100, 30));
        disconnectButton.setEnabled(false);

        panel1.add(selectPort);
        panel1.add(runPort);
        panel1.add(connectButton);
        panel1.add(disconnectButton);

        ok = new JButton("Затвори");
        this.add(ok);
        ok.setBounds(500, 390, 120, 30);

        connectButton.addActionListener(this);
        disconnectButton.addActionListener(this);
        ok.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            mainScreen.setEnabled(true);
            this.dispose();
        }

        String openPort = null;
        SerialPort sp = null;
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
    }
}


