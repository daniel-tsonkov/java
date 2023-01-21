package Razni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.in;

public class testLan {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(in);

        ServerSocket ss = new ServerSocket(4999);
        Socket s = ss.accept();

        System.out.println("client connected");

        //-----Server
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("Message" + str);
        //-----End Server

        //-----Klient
        String tekst = scanner.nextLine();
        while (scanner.equals("end")) {
            PrintWriter pr = new PrintWriter(s.getOutputStream());
            pr.println(tekst);
            pr.flush();
            tekst = scanner.nextLine();
        }
        //-----End Klient
    }
}
