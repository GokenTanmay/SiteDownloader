package SiteDownloader;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlValidator {
    public String Validate(String url) {
        System.out.println("URLValidator:");
        System.out.println(url);

        String validURL = null;
        try {
            validURL = new URL(url).toString();
            System.out.println(validURL);
        } catch (MalformedURLException e) {
            if (e.getMessage().contains("no protocol")) {
                validURL = "http://" + url;
                System.out.println("Exceprion - " + validURL);
            }
            e.printStackTrace(); //TODO: добавить в логгирование.
        }
        return validURL;
    }
}
