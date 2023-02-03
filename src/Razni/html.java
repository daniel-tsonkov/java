package Razni;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class html {
    public static void main(String[] args) throws IOException {
        URL webpage = null;
        URLConnection conn = null;
        webpage = new URL("https://www.coinmarketcap.com/currencies/bitcoin/");
        //webpage = new URL("https://google.com");
        conn = webpage.openConnection();
        InputStreamReader reader = new InputStreamReader(conn.getInputStream(), "UTF8");
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
