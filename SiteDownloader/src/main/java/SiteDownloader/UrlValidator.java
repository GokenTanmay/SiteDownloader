package SiteDownloader;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlValidator {
    public String Validate(String url) {
        System.out.println("URLValidator:");
        System.out.println(url);

        String validURL = null;
        if (!url.contains("@")) { //Проверяем что входящий URL не является адрессом эл.почты.
            if (!url.equals("#")) { //Проверяем что не пустая решетка.
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
            }
        }
        return validURL;
    }
}
