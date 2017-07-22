package SiteDownloader;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String html = new Downloader().download("lenta.ru");
        Parser parser = new Parser(html, "lenta.ru");

        ArrayList<String> links = parser.getURLs();
        System.out.println(links);

        System.out.println("----");
        System.out.println(parser.getTextOnly());
    }
}
