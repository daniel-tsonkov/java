package VDSystem;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.*;

public class Manual extends JFrame implements ActionListener, KeyListener, WindowListener {
    JButton ok;
    JTextPane myText;
    SimpleAttributeSet RedTitleText;
    SimpleAttributeSet GrayDescText;
    SimpleAttributeSet GreeDocFooter;
    JScrollPane scrollPane;

    MainScreen mainScreen;

    public Manual(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
        this.setLocationRelativeTo(null);
        this.setSize(600, 680);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("resources/favicon.png")));
        this.setTitle("Ръководство");
        this.setLayout(null);
        this.setVisible(true);

        RedTitleText = new SimpleAttributeSet();
        GrayDescText = new SimpleAttributeSet();
        GreeDocFooter = new SimpleAttributeSet();

        StyleConstants.setBold(RedTitleText, true);
        StyleConstants.setFontSize(RedTitleText, 20);
        StyleConstants.setFontFamily(RedTitleText, "Verdana");
        StyleConstants.setForeground(RedTitleText, Color.RED);

        StyleConstants.setFontSize(GrayDescText, 16);
        StyleConstants.setForeground(GrayDescText, Color.GRAY);

        StyleConstants.setItalic(GreeDocFooter, true);
        StyleConstants.setFontSize(GreeDocFooter, 20);
        StyleConstants.setForeground(GreeDocFooter, Color.GREEN);

        myText = new JTextPane();
        myText.setEditable(false);
        myText.setMargin(new Insets(10, 20, 10, 20));
        myText.setBackground(new Color(255, 255, 220));

        scrollPane = new JScrollPane(myText);
        scrollPane.setBounds(5, 10, 575, 570);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        this.add(scrollPane);

        insertDocContent("ВЪВЕДЕНИЕ", RedTitleText);
        insertDocContent("\n\n Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has" +
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has" +
                "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC," +
                "\nLorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has" +
                "\nLorem Ipsum is simply dummy text of the There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc. printing and typesetting from repetition, injected humour industry. Lorem Ipsum has ", GrayDescText);
        insertDocContent(new ImageIcon("C:/Users/Dani/IdeaProjects/java/tests/src/VDSystem/resources/gear.png"));
        insertDocContent(" Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has" +
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has" +
                "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC," +
                "\nLorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has" +
                "\nLorem Ipsum is simply dummy text of the There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc. printing and typesetting industry. Lorem Ipsum has\n", GrayDescText);
        insertDocContent(new ImageIcon("C:/Users/Dani/IdeaProjects/java/tests/src/VDSystem/resources/savefile.png"));
        insertDocContent("\n\nПРАВА", GreeDocFooter);

        ok = new JButton("OK");
        this.add(ok);
        ok.setBounds(240, 600, 120, 30);

        ok.addActionListener(this);
        myText.addKeyListener(this);
        this.addWindowListener(this);
    }

    private void setInsertionToDocEnd() {
        Document doc = myText.getDocument();
        int currentDocLength = doc.getLength();
        myText.setSelectionStart(currentDocLength);
        myText.setSelectionEnd(currentDocLength);
    }

    private void insertDocContent(ImageIcon img) {
        setInsertionToDocEnd();
        myText.insertIcon(img);
    }

    private void insertDocContent(String text, SimpleAttributeSet textStlyle) {
        setInsertionToDocEnd();
        Document doc = myText.getDocument();
        try {
            doc.insertString(doc.getLength(), text, textStlyle);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            mainScreen.setEnabled(true);
            this.dispose();
            /*fileChooser.setFileFilter(new FileNameExtensionFilter("jpg", "png"));
            int returnValue = fileChooser.showOpenDialog(Manual.this);
            if(returnValue == JFileChooser.APPROVE_OPTION) {
                //File file = fileChooser.getSelectedFile();
                //System.out.println(file);
                String file = "C:/Users/Dani/IdeaProjects/java/tests/src/VDSystem/resources/favicon.png";
                Icon icon = new ImageIcon(file);//.getAbsolutePath());
                myText.insertIcon(icon);
            }*/
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 27 || e.getKeyCode() == 10) {
            mainScreen.setEnabled(true);
            this.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        mainScreen.setEnabled(true);
        this.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
