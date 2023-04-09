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
import java.util.Objects;

public class MainScreen extends JFrame implements ActionListener {

    TankPanel tank;

    JToolBar toolBar;
    public static JLabel statusLed = new JLabel();
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
    JPanel topPanel, rightPanel, statusPanel, workArea, colorPanel, cellPanel, leftPanelWorkArea, rightPanelWorkarea, infoPanel, tankPanel;
    public static JTextArea evetTextArea;
    JScrollPane scrollPane;
    JTextField redColor, greenColor, blueColor;
    JButton setColor = new JButton();
    //JButton[][] array2dtop = new JButton[10][10];
    public static JButton[] array2dtop = new JButton[154];
    ImageIcon iconExit = new ImageIcon(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/VerticalFarming/resources/exit.png")));
    JButton exitButton = new JButton(iconExit);
    int cellNumber;
    static String openPort, stringToConsole;
    static SerialPort sp;
    OutputStream outputStream1;
    String receivedAnswers = "";
    int cmd = 0;
    static int tankFill = 99;
    static String tankMacAddress = "01020304";

    MainScreen() {
        this.setUndecorated(true); //remove "Title bar"
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(1280, 768);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        //rightPanel.add(exitButton, BorderLayout.EAST);
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

        leftPanelWorkArea.add(cellPanel);
        leftPanelWorkArea.add(scrollPane);
        rightPanelWorkarea.add(infoPanel);
        rightPanelWorkarea.add(tankPanel);
        workArea.add(leftPanelWorkArea);
        workArea.add(rightPanelWorkarea);
        this.add(rightPanel, BorderLayout.EAST);
        this.add(statusPanel, BorderLayout.SOUTH);
        this.add(workArea, BorderLayout.CENTER);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/VerticalFarming/resources/leafs.png")));
        ToolbarMenu();

        exitButton.addActionListener(this);
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

        leftPanelWorkArea = new JPanel();
        leftPanelWorkArea.setPreferredSize(new Dimension(1140, 890));
        leftPanelWorkArea.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        leftPanelWorkArea.setBackground(new Color(0, 0, 0));

        evetTextArea = new JTextArea();
        evetTextArea.setLineWrap(true);
        evetTextArea.setWrapStyleWord(true);
        evetTextArea.setFont(new Font(null, Font.PLAIN, 12));
        evetTextArea.setForeground(new Color(200, 200, 200));
        evetTextArea.setBackground(new Color(0, 0, 50));
        scrollPane = new JScrollPane(evetTextArea);
        scrollPane.setPreferredSize(new Dimension(1140, 315));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        cellPanel = new JPanel();
        cellPanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        cellPanel.setBorder(BorderFactory.createTitledBorder(null, "Cels", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, myFont, myColor));
        cellPanel.setPreferredSize(new Dimension(1140, 560));
        cellPanel.setBackground(new Color(0, 0, 0));

        rightPanelWorkarea = new JPanel();
        rightPanelWorkarea.setPreferredSize(new Dimension(350, 890));
        rightPanelWorkarea.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rightPanelWorkarea.setBackground(new Color(0, 0, 0));

        infoPanel = new JPanel();
        infoPanel.setBorder(BorderFactory.createTitledBorder(null, "Info", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, myFont, myColor));
        infoPanel.setPreferredSize(new Dimension(345, 560));
        infoPanel.setBackground(new Color(0, 0, 0));

        tank = new TankPanel();

        tankPanel = new JPanel();
        tankPanel.setBorder(BorderFactory.createTitledBorder(null, "Tank", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, myFont, myColor));
        tankPanel.setPreferredSize(new Dimension(345, 320));
        tankPanel.setBackground(new Color(0, 0, 0));
        tankPanel.add(tank);

        for (cellNumber = 0; cellNumber < array2dtop.length; cellNumber++) {
            array2dtop[cellNumber] = new JButton("C" + (cellNumber + 1));
            array2dtop[cellNumber].setActionCommand(String.valueOf(cellNumber));
            array2dtop[cellNumber].setMargin(new Insets(0, 0, 0, 0));
            array2dtop[cellNumber].setPreferredSize(new Dimension(46, 46));
            array2dtop[cellNumber].setBorder(BorderFactory.createEtchedBorder(0));
            if (cellNumber >= 140 - 1) {
                array2dtop[cellNumber].setBackground(new Color(130, 130, 130));
            } else {
                array2dtop[cellNumber].setBackground(UIManager.getColor("Button.background"));
            }
            array2dtop[cellNumber].addActionListener(this);

            cellPanel.add(array2dtop[cellNumber]);
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
                    stringToConsole = answear;
                    PrintOnTheConsole(stringToConsole);
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
            String tempRedColor = redColor.getText();
            String tempGreenColor = greenColor.getText();
            String tempBlueColor = blueColor.getText();
            if (Integer.parseInt(tempRedColor) < 10) {
                tempRedColor = "00" + tempRedColor;
            } else if ((Integer.parseInt(tempRedColor) >= 10) && (Integer.parseInt(tempRedColor) < 100)) {
                tempRedColor = "0" + tempRedColor;
            }
            if (Integer.parseInt(tempGreenColor) < 10) {
                tempGreenColor = "00" + tempGreenColor;
            } else if ((Integer.parseInt(tempGreenColor) >= 10) && (Integer.parseInt(tempGreenColor) < 100)) {
                tempGreenColor = "0" + tempGreenColor;
            }
            if (Integer.parseInt(tempBlueColor) < 10) {
                tempBlueColor = "00" + tempBlueColor;
            } else if ((Integer.parseInt(tempBlueColor) >= 10) && (Integer.parseInt(tempBlueColor) < 100)) {
                tempBlueColor = "0" + tempBlueColor;
            }
            String dataToSend = "\"{\\\"getdata\\\":\\\"set:" + tempRedColor + tempGreenColor + tempBlueColor + "\\\"}\"";
            try {
                outputStream1.write(dataToSend.getBytes());
                stringToConsole = "Send color: " +tempRedColor + tempGreenColor + tempBlueColor;
                PrintOnTheConsole(stringToConsole);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (sp != null) {
            incomingData();
        }

        if ((e.getSource() != exitButton) && (e.getSource() != setColor) && (e.getSource() != addCell) && (e.getSource() != deleteCell) && (e.getSource() != settingsButton) && (e.getSource() != setMacAddr) && (e.getSource() != getSoil) && (e.getSource() != onButton) && (e.getSource() != offButton) && (e.getSource() != offButton) && (e.getSource() != getTempAndHum)) {
            cmd = Integer.parseInt(e.getActionCommand());
            try {
                int event = (Integer.parseInt(e.getActionCommand()) + 1);
                System.out.println(event);
                stringToConsole = "Selected cell: C" + event;
                PrintOnTheConsole(stringToConsole);
                statusLed.setText(String.valueOf(event));
                for (JButton jButton : array2dtop) {
                    if ((Objects.equals(jButton.getBackground(), new Color(57, 181, 254))) && (jButton != (array2dtop[event - 1]))) {
                        jButton.setBackground(UIManager.getColor("Button.background"));
                    }
                }
                if ((!Objects.equals(array2dtop[event - 1].getBackground(), new Color(130, 130, 130)))) {
                    array2dtop[event - 1].setBackground(new Color(57, 181, 254));
                }
            } catch (NumberFormatException ignored) {
            }
        }

        if (e.getSource() == exitButton) {
            this.dispose();
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
        exitButton.setPreferredSize(new Dimension(30, 30));
        toolBar.add(exitButton);

        Container pane = this.getContentPane(); //add to JPane toolbar
        pane.add(toolBar, BorderLayout.NORTH);

        addCell.addActionListener(this);
        deleteCell.addActionListener(this);
        settingsButton.addActionListener(this);
    }

    public void PrintOnTheConsole(String str) {
        evetTextArea.append("\n" + str);
        evetTextArea.setCaretPosition(evetTextArea.getDocument().getLength());
    }
}
