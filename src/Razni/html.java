package Razni;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class html {
    public static void main(String[] args) throws IOException {
        URL webpage = null;
        URLConnection conn = null;
        webpage = new URL("http://192.168.5.61/?LED=OFF");
        //webpage = new URL("https://google.com");
        conn = webpage.openConnection();
        InputStreamReader reader = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);
        BufferedReader buffer = new BufferedReader(reader);
        String line = "";

        while (true){
            line = buffer.readLine();
            if(line != null){
                Document docs = Jsoup.parse(line);
                System.out.println(docs);
            }else {
                break;
            }
        }
    }
}
