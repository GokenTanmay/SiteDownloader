package SiteDownloader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AppTest1 {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("body.html"));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }



        System.out.println(new TextExctractor().Extract(sb.toString()));
    }
}
