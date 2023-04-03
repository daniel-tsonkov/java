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

    JLabel statusLed = new JLabel();
    JComboBox runPort;
    ImageIcon iconSettings = new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/VerticalFarming/resources/gear.png")));
    JButton settingsButton = new JButton(iconSettings);
    JButton onButton = new JButton();
    JButton offButton = new JButton();
    JButton[][] array2dtop = new JButton[10][10];
    int xCell = 0;
    int yCell = 0;
    int selectedCell;
    JButton cellNo = new JButton();
    static String openPort;
    static SerialPort sp;
    OutputStream outputStream1;
    String receivedAnswers = "";
    int cmd = 0;

    MainScreen() {
        settingsButton.setPreferredSize(new Dimension(30, 30));
        settingsButton.setMargin(new Insets(0, 0, 0, 0));
        settingsButton.setBackground(new Color(220, 220, 220));

        onButton.setText("on");
        onButton.setFocusable(false);
        onButton.setPreferredSize(new Dimension(90, 30));
        onButton.addActionListener(this);

        offButton.setText("off");
        offButton.setFocusable(false);
        offButton.setPreferredSize(new Dimension(90, 30));
        offButton.addActionListener(this);

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(20, 30));
        topPanel.setBackground(new Color(100, 100, 100));
        topPanel.setLayout(new BorderLayout());

        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(200, 200));
        rightPanel.setBackground(new Color(100, 100, 100));

        JPanel statusPanel = new JPanel();
        statusPanel.setPreferredSize(new Dimension(20, 20));
        statusPanel.setBackground(new Color(100, 100, 100));

        JPanel workArea = new JPanel();
        workArea.setPreferredSize(new Dimension(200, 200));
        workArea.setBackground(new Color(0, 0, 0));

        for (xCell = 0; xCell < array2dtop.length; xCell++) {
            for (int yCell = 0; yCell < array2dtop.length; yCell++) {
                array2dtop[xCell][yCell] = new JButton("C" + String.valueOf((xCell * 10) + yCell));
                array2dtop[xCell][yCell].setActionCommand(String.valueOf((xCell * 10) + yCell));
                array2dtop[xCell][yCell].setMargin(new Insets(0, 0, 0, 0));
                array2dtop[xCell][yCell].addActionListener(this);
                array2dtop[xCell][yCell].setPreferredSize(new Dimension(46, 46));

                workArea.add(array2dtop[xCell][yCell]);
            }
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 768);
        this.setLayout(new BorderLayout(2, 2));
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(200, 200, 200));
        this.setTitle("Pidleri");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        topPanel.add(settingsButton, BorderLayout.EAST);
        statusPanel.add(statusLed);
        rightPanel.add(onButton);
        rightPanel.add(offButton);
        this.add(topPanel, BorderLayout.NORTH);
        this.add(rightPanel, BorderLayout.EAST);
        this.add(statusPanel, BorderLayout.SOUTH);
        this.add(workArea, BorderLayout.CENTER);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/VerticalFarming/resources/leafs.png")));

        settingsButton.addActionListener(this);
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
        if (e.getSource() == settingsButton) {
            try {
                Settings settings = new Settings(this);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            this.setEnabled(false);
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

        //int cmd = Integer.parseInt(e.getActionCommand());
        try {
            System.out.println(Integer.parseInt(e.getActionCommand()));
        } catch (NumberFormatException numberFormatException) {
        }
        /*if(Integer.parseInt(e.getActionCommand()) == 5) {
            array2dtop[xCell][yCell].setBackground(new Color(255, 100, 100));
        }*/
    }
}
