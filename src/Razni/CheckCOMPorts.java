package Razni;
import java.net.*;
import java.io.*;

public class CheckCOMPorts {
    public static void main(String[] args)
    {
        // Creating object of socket class
        Socket portCheck;

        // Defining the hostName to check for port
        // availability
        String host = "localhost";

        if (args.length > 0) {
            host = args[0];
        }
        for (int i = 0; i < 1024; i++) {
            try {
                System.out.println("Looking for " + i);
                portCheck = new Socket(host, i);
                System.out.println(
                        "There is a server running on port "
                                + i);
            }
            catch (UnknownHostException e) {
                System.out.println("Exception occurred" + e);
                break;
            }
            catch (IOException e) {
            }
        }
    }
}
