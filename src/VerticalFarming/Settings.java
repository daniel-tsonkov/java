package VerticalFarming;

import com.fazecast.jSerialComm.SerialPort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Settings  extends JFrame implements ActionListener {

    JPanel topPanel, tankPanel;
    //JLabel selectPort = new JLabel();
    //
    //JLabel statusLed = new JLabel();
    JComboBox runPort;
    JButton connectButton = new JButton();
    JButton disconnectButton = new JButton();
    JButton setTankButton = new JButton();
    JTextField tankMacAddress = new JTextField("4C11AE13F2D0");
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

        topPanel = new JPanel();
        topPanel.setOpaque(true);
        //topPanel.setBackground(Color.WHITE);
        topPanel.setBorder(BorderFactory.createTitledBorder("Избор на порт"));
        topPanel.setPreferredSize(new Dimension(500, 70));

        tankPanel = new JPanel();
        tankPanel.setOpaque(true);
        tankPanel.setBorder(BorderFactory.createTitledBorder("MAC адрес на резервоар"));
        tankPanel.setPreferredSize(new Dimension(500, 70));

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        tabbedPane.add("Порт", panel1);
        tabbedPane.add("Резервоар", panel2);
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
        if(MainScreen.openPort != null){
            runPort.setSelectedItem(MainScreen.openPort);
        }
        runPort.setPreferredSize(new Dimension(110, 30));
        runPort.addActionListener(this);

        /*selectPort.setText("Select PORT");
        selectPort.setFont(new Font("Arial", Font.PLAIN, 18));
        selectPort.setForeground(new Color(10, 10, 10));
        selectPort.setBounds(100, 100, 300, 300);*/

        connectButton.setText("Connect");
        connectButton.setFocusable(false);
        connectButton.setPreferredSize(new Dimension(90, 30));

        disconnectButton.setText("Disconnect");
        disconnectButton.setFocusable(false);
        disconnectButton.setPreferredSize(new Dimension(100, 30));
        disconnectButton.setEnabled(false);

        setTankButton.setText("Connect");
        setTankButton.setFocusable(false);
        setTankButton.setPreferredSize(new Dimension(150, 30));

        if (MainScreen.sp != null) {
            disconnectButton.setEnabled(true);
            connectButton.setEnabled(false);
        }
        if ((MainScreen.openPort == null) || (MainScreen.openPort.equals(""))) {
            disconnectButton.setEnabled(false);
            connectButton.setEnabled(true);
        }

        panel1.add(topPanel, BorderLayout.CENTER);
        panel2.add(tankPanel, BorderLayout.CENTER);

        //topPanel.add(selectPort);
        topPanel.add(runPort);
        topPanel.add(connectButton);
        topPanel.add(disconnectButton);

        tankMacAddress.setPreferredSize(new Dimension(150, 30));

        tankPanel.add(tankMacAddress);
        tankPanel.add(setTankButton);

        ok = new JButton("Затвори");
        this.add(ok);
        ok.setBounds(500, 390, 120, 30);

        connectButton.addActionListener(this);
        disconnectButton.addActionListener(this);
        setTankButton.addActionListener(this);
        ok.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == runPort) {
            MainScreen.openPort = Objects.requireNonNull(runPort.getSelectedItem()).toString();
        }

        if (e.getSource() == setTankButton) {
            MainScreen.tankMacAddress = tankMacAddress.getText();
            MainScreen.statusLed.setText(MainScreen.tankMacAddress);
            System.out.println(MainScreen.tankMacAddress);
            MainScreen.stringToConsole = "Tank MAC address is: " + MainScreen.tankMacAddress;
            MainScreen.PrintOnTheConsole(MainScreen.stringToConsole);
        }

        if (e.getSource() == ok) {
            mainScreen.setEnabled(true);
            this.dispose();
        }
        if (e.getSource() == connectButton) {
            MainScreen.sp = SerialPort.getCommPort(MainScreen.openPort);
            MainScreen.sp.setComPortParameters(115200, 8, 1, 0); // default connection settings for Arduino
            MainScreen.sp.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0); // block until bytes can be written TIMEOUT_READ_SEMI_BLOCKING

            if (MainScreen.sp.openPort()) {
                disconnectButton.setEnabled(true);
                connectButton.setEnabled(false);
                System.out.println(MainScreen.openPort + " is open :)");
                //selectPort.setText(MainScreen.openPort + " is open");
                MainScreen.stringToConsole = MainScreen.openPort + " is open";
                MainScreen.PrintOnTheConsole(MainScreen.stringToConsole);
            } else {
                System.out.println("Failed to open port :(");
                //selectPort.setText("Check again " + MainScreen.openPort);
            }
        }

        if (e.getSource() == disconnectButton) {
            if (MainScreen.sp.closePort()) {
                disconnectButton.setEnabled(false);
                connectButton.setEnabled(true);
                System.out.println(MainScreen.openPort + " is closed :)");
                //selectPort.setText(MainScreen.openPort + " is closed");
                MainScreen.openPort = "";
            } else {
                System.out.println("Failed to close port :(");
                //selectPort.setText("Check again " + MainScreen.openPort);
            }
        }
    }
}


