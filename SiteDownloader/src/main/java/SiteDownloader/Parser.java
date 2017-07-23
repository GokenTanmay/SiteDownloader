package SiteDownloader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Parser {
    Document doc;
    String baseURI;

    public Parser(String html, String baseURI) {
        this.baseURI = new UrlValidator().Validate(baseURI);
        doc = Jsoup.parse(html, baseURI);
    }

    public ArrayList<String> getURLs() {
        ArrayList<String> result = new ArrayList<String>();
        Elements urls = doc.body().getElementsByTag("a");
        for (Element url : urls) {
            if (!url.attr("href").equals("")) {
                if (url.attr("href").startsWith("/")) {
                    result.add(baseURI + url.attr("href"));
                } else {
                    result.add(url.attr("href"));
                }
            }
        }
        return result;
    }

    public String getTextOnly() {
        return doc.body().text();
    } //TODO: Исключить из выдачи текст ссылок.
}
