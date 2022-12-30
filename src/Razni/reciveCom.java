package Razni;

import com.fazecast.jSerialComm.SerialPort;

import java.io.IOException;

/**
 * Simple application that is part of an tutorial. 
 * The tutorial shows how to establish a serial connection between a Java and Arduino program with the help of an USB-to-TTL Module.
 * @author Michael Schoeffler (www.mschoeffler.de)
 *
 */
public class reciveCom {

    public static void main(String[] args) throws IOException, InterruptedException {
        SerialPort sp = SerialPort.getCommPort("COM9"); // device name TODO: must be changed
        sp.setComPortParameters(9600, 8, 1, 0); // default connection settings for Arduino
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0); // block until bytes can be written

        if (sp.openPort()) {
            System.out.println("Port is open :)");
        } else {
            System.out.println("Failed to open port :(");
            return;
        }

        for (Integer i = 0; i < 5; ++i) {
            //sp.getOutputStream().write(i.byteValue());
            byte[] asd = sp.getInputStream().readAllBytes();
            //System.out.println(asd);
            //sp.getOutputStream().flush();
            /*for (int j = 0; j < asd.length; j++) {
                System.out.println(asd[j]);
            }*/

            //System.out.println("Sent number: " + i);
            Thread.sleep(1000);
        }

        if (sp.closePort()) {
            System.out.println("Port is closed :)");
        } else {
            System.out.println("Failed to close port :(");
            return;
        }


    }

}