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

public class MainScreen extends JFrame implements ActionListener {

    JLabel statusLed = new JLabel();
    JComboBox runPort;
    ImageIcon iconSettings = new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/VerticalFarming/resources/gear.png")));
    JButton settingsButton = new JButton(iconSettings);
    JButton setMacAddr = new JButton();
    JButton setReciveMacAddr = new JButton();
    JButton onButton = new JButton();
    JButton offButton = new JButton();
    JButton getTempAndHum = new JButton();
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

        setMacAddr.setText("MAC addr");
        setMacAddr.setFocusable(false);
        setMacAddr.setPreferredSize(new Dimension(185, 30));
        setMacAddr.setMargin(new Insets(0, 0, 0, 0));
        setMacAddr.addActionListener(this);

        setReciveMacAddr.setText("Recive mac");
        setReciveMacAddr.setFocusable(false);
        setReciveMacAddr.setPreferredSize(new Dimension(90, 30));
        setReciveMacAddr.setMargin(new Insets(0, 0, 0, 0));
        setReciveMacAddr.addActionListener(this);

        onButton.setText("on");
        onButton.setFocusable(false);
        onButton.setPreferredSize(new Dimension(90, 30));
        onButton.addActionListener(this);

        offButton.setText("off");
        offButton.setFocusable(false);
        offButton.setPreferredSize(new Dimension(90, 30));
        offButton.addActionListener(this);

        getTempAndHum.setText("Temp and Hum");
        getTempAndHum.setFocusable(false);
        getTempAndHum.setPreferredSize(new Dimension(185, 30));
        getTempAndHum.setMargin(new Insets(0, 0, 0, 0));
        getTempAndHum.addActionListener(this);

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
        rightPanel.add(setMacAddr);
        //rightPanel.add(setReciveMacAddr);
        rightPanel.add(onButton);
        rightPanel.add(offButton);
        rightPanel.add(getTempAndHum);
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

                if(!receivedAnswers.equals("Set MAC address OK")) {
                    receivedAnswers = "";
                }

                for (byte b : newData) {
                    receivedAnswers += (char) b;
                }
                statusLed.setText("LED " + receivedAnswers);
                String answear = receivedAnswers.trim();
                System.out.println(answear);
                if(answear.equals("Set MAC address OK")) {
                    actionA();

                }
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
        if (e.getSource() == setMacAddr) {
            outputStream1 = sp.getOutputStream();
            String dataToSend = "\"{\\\"macaddr\\\":\\\"4C11AE13D009\\\"}\"";
            try {
                outputStream1.write(dataToSend.getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == setReciveMacAddr) {
            outputStream1 = sp.getOutputStream();
            String dataToSend = "\"{\\\"getdata\\\":\\\"macaddr:4C11AE13F2D0\\\"}\"";
            try {
                outputStream1.write(dataToSend.getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == onButton) {
            outputStream1 = sp.getOutputStream();
            String dataToSend = "\"{\\\"getdata\\\":\\\"relay:on\\\"}\"";
            try {
                outputStream1.write(dataToSend.getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == offButton) {
            outputStream1 = sp.getOutputStream();
            String dataToSend = "\"{\\\"getdata\\\":\\\"relay:off\\\"}\"";
            try {
                outputStream1.write(dataToSend.getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == getTempAndHum) {
            outputStream1 = sp.getOutputStream();
            String dataToSend = "\"{\\\"getdata\\\":\\\"getdata:getdatavalue\\\"}\"";
            try {
                outputStream1.write(dataToSend.getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (sp != null) {
            incomingData();
        }

        if((e.getSource() != settingsButton) && (e.getSource() != setMacAddr) && (e.getSource() != setReciveMacAddr) && (e.getSource() != onButton) && (e.getSource() != offButton) && (e.getSource() != offButton) && (e.getSource() != getTempAndHum)) {
            cmd = Integer.parseInt(e.getActionCommand());
            try {
                System.out.println(Integer.parseInt(e.getActionCommand()));
            } catch (NumberFormatException numberFormatException) {
            }
        }
    }

    void actionA(){
        //String answear = receivedAnswers;
        //if(answear.equals("Set MAC address OK")) {
            OutputStream outputStream2 = sp.getOutputStream();
            String dataToSend2 = "\"{\\\"getdata\\\":\\\"macaddr:4C11AE13F2D0\\\"}\"";
            try {
                outputStream2.write(dataToSend2.getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //receivedAnswers = "";
        //}
    }
}
