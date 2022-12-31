package Razni;

import com.fazecast.jSerialComm.SerialPort;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Simple application that is part of an tutorial.
 * The tutorial shows how to establish a serial connection between a Java and Arduino program with the help of an USB-to-TTL Module.
 *
 * @author Michael Schoeffler (www.mschoeffler.de)
 */
public class reciveCom {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        SerialPort[] s = SerialPort.getCommPorts();

        for (SerialPort port : s) {
            System.out.println("" + port.getSystemPortName());
        }

        String comPort = "";
        while (comPort.isEmpty()) {
            comPort = scanner.nextLine();
        }

        SerialPort sp = SerialPort.getCommPort(comPort);//COM9
        sp.setComPortParameters(9600, 8, 1, 0); // default connection settings for Arduino
        sp.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0); // block until bytes can be written

        if (sp.openPort()) {
            System.out.println(comPort + " is open :)");
        } else {
            System.out.println("Failed to open port :(");
            return;
        }

        InputStream inputStream = sp.getInputStream();
        String command = "";
        boolean end = true;
        while (end) {
            command += (char) inputStream.read();
            command = command.replace("\n", "").replace("\r", "");
            if(command.length() == 5) {
                System.out.println(command);
                if (command.contains("Test5")) {
                    end = false;
                    System.out.println("END...");
                }
                command = "";
            }
             /*sp.getOutputStream().write(i.byteValue());
            sp.getOutputStream().flush();
            for (int j = 0; j < inputStream.length; j++) {
                System.out.println(inputStream[j]);
            }
            System.out.println("Sent number: " + i);
            Thread.sleep(1000);*/
        }

        if (sp.closePort()) {
            System.out.println(comPort + " is closed :)");
        } else {
            System.out.println("Failed to close port :(");
        }
    }
}

/*
ARDUINO COEDE
    int i = 0;

    void setup() {
        Serial.begin(9600);
    }

    void loop() {
        Serial.print("Test");
        Serial.println(i);
        i++;
        delay(1000);
    }*/
