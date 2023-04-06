package VerticalFarming;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;

public class MainScreen extends JFrame implements ActionListener {

    JToolBar toolBar;
    JLabel statusLed = new JLabel();
    ImageIcon iconSettings = new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/VerticalFarming/resources/gear.png")));
    JButton settingsButton = new JButton(iconSettings);
    JButton setMacAddr = new JButton();
    JButton getSoil = new JButton();
    JButton onButton = new JButton();
    JButton offButton = new JButton();
    JButton getTempAndHum = new JButton();
    ImageIcon iconAddCell = new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/VerticalFarming/resources/addcell.png")));
    JButton addCell = new JButton(iconAddCell);
    ImageIcon iconDeleteCell = new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/VerticalFarming/resources/deletecell.png")));
    JButton deleteCell = new JButton(iconDeleteCell);
    JPanel topPanel, rightPanel, statusPanel, workArea, colorPanel, cellPanel, rightPanelWorkarea, infoPanel, tankPanel;
    JTextField redColor, greenColor, blueColor;
    JButton setColor = new JButton();
    JButton[][] array2dtop = new JButton[10][10];
    int xCell;
    static String openPort;
    static SerialPort sp;
    OutputStream outputStream1;
    String receivedAnswers = "";
    int cmd = 0;

    MainScreen() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 768);
        this.setLayout(new BorderLayout(2, 2));
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(200, 200, 200));
        this.setTitle("Pidleri");
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(20, 30));
        topPanel.setBackground(new Color(100, 100, 100));
        topPanel.setLayout(new BorderLayout());

        rightPanel();
        statusPanel();
        wonkArea();

        topPanel.add(addCell, BorderLayout.WEST);
        topPanel.add(deleteCell);
        topPanel.add(cellPanel);
        topPanel.add(settingsButton, BorderLayout.EAST);
        statusPanel.add(statusLed, BorderLayout.WEST);
        rightPanel.add(setMacAddr);
        rightPanel.add(onButton);
        rightPanel.add(offButton);
        rightPanel.add(getTempAndHum);
        rightPanel.add(getSoil);
        rightPanel.add(colorPanel);
        colorPanel.add(redColor);
        colorPanel.add(greenColor);
        colorPanel.add(blueColor);
        colorPanel.add(setColor);

        workArea.add(cellPanel);
        rightPanelWorkarea.add(infoPanel);
        rightPanelWorkarea.add(tankPanel);
        workArea.add(rightPanelWorkarea);
        this.add(rightPanel, BorderLayout.EAST);
        this.add(statusPanel, BorderLayout.SOUTH);
        this.add(workArea, BorderLayout.CENTER);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/VerticalFarming/resources/leafs.png")));
        ToolbarMenu();
    }

    private void statusPanel() {
        statusPanel = new JPanel();
        statusPanel.setPreferredSize(new Dimension(20, 20));
        statusPanel.setBackground(new Color(100, 100, 100));
        statusPanel.setLayout(new BorderLayout());
    }

    private void rightPanel() {
        Font myFont = new Font("SansSerif", Font.PLAIN, 14);
        Color myColor = Color.WHITE;

        rightPanel = new JPanel();
        rightPanel.setBorder(BorderFactory.createTitledBorder(null, "Settings", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, myFont, myColor));
        rightPanel.setPreferredSize(new Dimension(200, 200));
        rightPanel.setBackground(new Color(100, 100, 100));

        setMacAddr.setText("MAC addr");
        setMacAddr.setFocusable(false);
        setMacAddr.setPreferredSize(new Dimension(185, 30));
        setMacAddr.setMargin(new Insets(0, 0, 0, 0));
        setMacAddr.setBorder(BorderFactory.createEtchedBorder(0));
        setMacAddr.addActionListener(this);

        onButton.setText("on");
        onButton.setFocusable(false);
        onButton.setPreferredSize(new Dimension(90, 30));
        onButton.setBorder(BorderFactory.createEtchedBorder(0));
        onButton.addActionListener(this);

        offButton.setText("off");
        offButton.setFocusable(false);
        offButton.setPreferredSize(new Dimension(90, 30));
        offButton.setBorder(BorderFactory.createEtchedBorder(0));
        offButton.addActionListener(this);

        getTempAndHum.setText("Temp and Hum");
        getTempAndHum.setFocusable(false);
        getTempAndHum.setPreferredSize(new Dimension(185, 30));
        getTempAndHum.setMargin(new Insets(0, 0, 0, 0));
        getTempAndHum.setBorder(BorderFactory.createEtchedBorder(0));
        getTempAndHum.addActionListener(this);

        getSoil.setText("Get Soil");
        getSoil.setFocusable(false);
        getSoil.setPreferredSize(new Dimension(185, 30));
        getSoil.setMargin(new Insets(0, 0, 0, 0));
        getSoil.setBorder(BorderFactory.createEtchedBorder(0));
        getSoil.addActionListener(this);

        colorPanel = new JPanel();
        colorPanel.setOpaque(true);
        colorPanel.setBorder(BorderFactory.createTitledBorder(null, "Set LED color", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, myFont, myColor));
        colorPanel.setPreferredSize(new Dimension(185, 100));
        colorPanel.setBackground(new Color(100, 100, 100));

        redColor = new JTextField();
        redColor.setPreferredSize(new Dimension(53, 30));

        greenColor = new JTextField();
        greenColor.setPreferredSize(new Dimension(53, 30));

        blueColor = new JTextField();
        blueColor.setPreferredSize(new Dimension(53, 30));

        setColor.setText("Set color");
        setColor.setFocusable(false);
        setColor.setPreferredSize(new Dimension(170, 30));
        setColor.setMargin(new Insets(0, 0, 0, 0));
        setColor.setBorder(BorderFactory.createEtchedBorder(0));
        setColor.addActionListener(this);
    }

    private void wonkArea() {
        Font myFont = new Font("SansSerif", Font.PLAIN, 14);
        Color myColor = Color.WHITE;

        workArea = new JPanel();
        workArea.setPreferredSize(new Dimension(200, 200));
        workArea.setBackground(new Color(0, 0, 0));

        cellPanel = new JPanel();
        cellPanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        cellPanel.setBorder(BorderFactory.createTitledBorder(null, "Cels", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, myFont, myColor));
        cellPanel.setPreferredSize(new Dimension(700, 650));
        cellPanel.setBackground(new Color(0, 0, 0));

        rightPanelWorkarea = new JPanel();
        rightPanelWorkarea.setPreferredSize(new Dimension(350, 650));
        rightPanelWorkarea.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rightPanelWorkarea.setBackground(new Color(0, 0, 0));

        infoPanel = new JPanel();
        infoPanel.setBorder(BorderFactory.createTitledBorder(null, "Info", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, myFont, myColor));
        infoPanel.setPreferredSize(new Dimension(345, 320));
        infoPanel.setBackground(new Color(0, 0, 0));

        tankPanel = new JPanel();
        tankPanel.setBorder(BorderFactory.createTitledBorder(null, "Tank", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, myFont, myColor));
        tankPanel.setPreferredSize(new Dimension(345, 320));
        tankPanel.setBackground(new Color(0, 0, 0));

        for (xCell = 0; xCell < array2dtop.length; xCell++) {
            for (int yCell = 0; yCell < array2dtop.length; yCell++) {
                array2dtop[xCell][yCell] = new JButton("C" + ((xCell * 10) + yCell));
                array2dtop[xCell][yCell].setActionCommand(String.valueOf((xCell * 10) + yCell));
                array2dtop[xCell][yCell].setMargin(new Insets(0, 0, 0, 0));
                array2dtop[xCell][yCell].addActionListener(this);
                array2dtop[xCell][yCell].setPreferredSize(new Dimension(46, 46));
                array2dtop[xCell][yCell].setBorder(BorderFactory.createEtchedBorder(0));

                cellPanel.add(array2dtop[xCell][yCell]);
            }
        }
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

                StringBuilder stringBuilder = new StringBuilder(receivedAnswers);
                for (byte b : newData) {
                    stringBuilder.append((char) b);
                }
                receivedAnswers = stringBuilder.toString();

                String answear = receivedAnswers.trim().replace("\n", "").replace("\0", "");
                if (!answear.equals("")) {
                    System.out.println(answear);
                    statusLed.setText(answear);
                }
                if (answear.equals("Set MAC address OK")) {
                    actionA();
                }
                receivedAnswers = "";
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addCell) {
            try {
                new Settings(this);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            this.setEnabled(false);
        }

        if (e.getSource() == deleteCell) {
            try {
                new Settings(this);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            this.setEnabled(false);
        }
        if (e.getSource() == settingsButton) {
            try {
                new Settings(this);
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
        if (e.getSource() == getSoil) {
            outputStream1 = sp.getOutputStream();
            String dataToSend = "\"{\\\"getdata\\\":\\\"getdata:soil\\\"}\"";
            try {
                outputStream1.write(dataToSend.getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == setColor) {
            outputStream1 = sp.getOutputStream();
            //System.out.println(ledColor);
            String dataToSend = "\"{\\\"getdata\\\":\\\"set:" + redColor.getText() + greenColor.getText() + blueColor.getText() + "\\\"}\"";
            try {
                outputStream1.write(dataToSend.getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (sp != null) {
            incomingData();
        }

        if ((e.getSource() != setColor) && (e.getSource() != addCell) && (e.getSource() != deleteCell) && (e.getSource() != settingsButton) && (e.getSource() != setMacAddr) && (e.getSource() != getSoil) && (e.getSource() != onButton) && (e.getSource() != offButton) && (e.getSource() != offButton) && (e.getSource() != getTempAndHum)) {
            cmd = Integer.parseInt(e.getActionCommand());
            try {
                System.out.println(Integer.parseInt(e.getActionCommand()));
            } catch (NumberFormatException ignored) {
            }
        }
    }

    void actionA() {
        OutputStream outputStream2 = sp.getOutputStream();
        String dataToSend2 = "\"{\\\"getdata\\\":\\\"macaddr:BCFF4DFA019B\\\"}\"";
        try {
            outputStream2.write(dataToSend2.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //receivedAnswers = "";
    }

    private void ToolbarMenu() {
        toolBar = new JToolBar();
        toolBar.setBackground(new Color(100, 100, 100));
        toolBar.setFloatable(false);
        //addCell = new JButton(iconAddCell);
        addCell.setFocusable(false);
        addCell.setPreferredSize(new Dimension(32, 32));
        addCell.setMargin(new Insets(0, 0, 0, 0));
        addCell.setBorder(BorderFactory.createEtchedBorder(0));
        toolBar.add(addCell);
        //deleteCell = new JButton(iconDeleteCell);
        deleteCell.setFocusable(false);
        deleteCell.setPreferredSize(new Dimension(32, 32));
        deleteCell.setMargin(new Insets(0, 0, 0, 0));
        deleteCell.setBorder(BorderFactory.createEtchedBorder(0));
        toolBar.add(deleteCell);

        toolBar.add(Box.createHorizontalGlue());
        //settingsButton = new JButton(iconSettings);
        settingsButton.setFocusable(false);
        settingsButton.setPreferredSize(new Dimension(30, 30));
        settingsButton.setBorder(BorderFactory.createEtchedBorder(0));
        toolBar.add(settingsButton);

        Container pane = this.getContentPane(); //add to JPane toolbar
        pane.add(toolBar, BorderLayout.NORTH);

        addCell.addActionListener(this);
        deleteCell.addActionListener(this);
        settingsButton.addActionListener(this);
    }
}
