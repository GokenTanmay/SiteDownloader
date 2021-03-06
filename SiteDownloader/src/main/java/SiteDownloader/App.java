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
        WebSpiderUrlRepository webSpiderUrlRepository = new WebSpiderUrlRepository();
        webSpiderUrlRepository.addUnscanedURL(new SpiderURL("lenta.ru", 5));

        SpiderURL scanSpiderURL;
        Integer count = 0;

        while ((scanSpiderURL = webSpiderUrlRepository.getUnscanedURL())!=null){
            String html = new Downloader().download(scanSpiderURL.getUrl());
            Parser parser = new Parser(html, scanSpiderURL.getUrl());
            System.out.printf("===");
            //System.out.println(parser.getTextOnly()); //TODO:Возможно запись в БД занимает много времени и разумнее сделать запись отсканированных урлов "пакетом"

            if (scanSpiderURL.getLevel()>0){
                for (String url: parser.getURLs()) {
                    System.out.println("начало записи в БД");
                    webSpiderUrlRepository.addUnscanedURL(new SpiderURL(url, scanSpiderURL.getLevel() - 1));
                    System.out.println("конец записи в БД");
                }
            }
            count++;
            System.out.println(count);
            System.out.println(webSpiderUrlRepository.getRepositorySize());
        }

//        String html = new Downloader().download("lenta.ru");
//        Parser parser = new Parser(html, "lenta.ru");
//
//        ArrayList<String> links = parser.getURLs();
//        System.out.println(links);
//
//        System.out.println("----");
//        System.out.println(parser.getTextOnly());
    }
}
