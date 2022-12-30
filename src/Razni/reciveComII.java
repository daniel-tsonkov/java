package Razni;

import com.fazecast.jSerialComm.SerialPort;

import java.io.IOException;
import java.io.InputStream;

public class reciveComII {
    static int x = 0;
    static SerialPort s1;

    public static void main(String args[]) throws IOException, InterruptedException {
        SerialPort[] s = SerialPort.getCommPorts();

        for (SerialPort port : s) {
            System.out.println("" + port.getSystemPortName());
            s1 = SerialPort.getCommPort(port.getSystemPortName());
            if (s1.openPort()) {
                System.out.println("SuccessFully port opened");
            } else {
                System.out.println("Failed to open port");
            }
        }
        s1.setBaudRate(9600);
        s1.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0); // block until bytes can be written

//                 Receiving data from the serial port

        InputStream is = s1.getInputStream();


        for (int i = 0, x = 0; true; i++) {
            System.out.print(is.read());
        }

        /*if (s1.closePort()) {
            System.out.println("Port closed Successfully");
        }*/


//                Sending  data To  the serial port
            /*OutputStream os = s1.getOutputStream();
            for (int x = 0; x <= 7; x++) {

                os.write(new String("0").getBytes());

                os.flush();
                System.out.println("Send Succeed  -" + new String("0"));
                Thread.sleep(3000);

                os.write(new String("1").getBytes());
                System.out.println("Send Succeed  -" + new String("1"));
                os.flush();

            }*/
            /*os.close();

            s1.closePort();*/
    }

}
