package Razni;

import com.fazecast.jSerialComm.SerialPort;

import java.io.IOException;
import java.io.InputStream;

/**
 * Simple application that is part of an tutorial.
 * The tutorial shows how to establish a serial connection between a Java and Arduino program with the help of an USB-to-TTL Module.
 *
 * @author Michael Schoeffler (www.mschoeffler.de)
 */
public class reciveCom {

    public static void main(String[] args) throws IOException, InterruptedException {
        SerialPort sp = SerialPort.getCommPort("COM9");
        sp.setComPortParameters(9600, 8, 1, 0); // default connection settings for Arduino
        sp.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0); // block until bytes can be written

        if (sp.openPort()) {
            System.out.println("Port is open :)");
        } else {
            System.out.println("Failed to open port :(");
            return;
        }

        //for (Integer i = 0; i < 5; ++i) {

        InputStream inputStream = sp.getInputStream();
        //for (int j = 0, x = 0; true; j++) {

        String command = "";
        boolean end = true;
        while (end) {
            command += (char) inputStream.read();
            if(command.length() == 5) {
                System.out.println(command);
                char temp = (char) inputStream.read();
                char temp1 = (char) inputStream.read();
                if (command.contains("Test5")) {
                    end = false;
                    System.out.println("END...");
                }
                command = "";
            }


        }
            /*sp.getOutputStream().write(i.byteValue());
            sp.getOutputStream().flush();
            for (int j = 0; j < inputStream.length; j++) {
                System.out.println(inputStream[j]);
            }
            System.out.println("Sent number: " + i);
            Thread.sleep(1000);*/
        //}

        if (sp.closePort()) {
            System.out.println("Port is closed :)");
        } else {
            System.out.println("Failed to close port :(");
            return;
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
