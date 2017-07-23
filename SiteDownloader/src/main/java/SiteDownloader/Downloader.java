package SiteDownloader;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Downloader {
    public String download(String url) {
        String validURL = null;
        String result = "";

        validURL = new UrlValidator().Validate(url);
//        try {
//            validURL = new URL(url).getPath();
//        } catch (MalformedURLException e) {
//            if(e.getMessage().contains("no protocol")){
//                validURL = "http://" + url;
//            }
//            e.printStackTrace(); //TODO: добавить в логгирование.
//        }

        if (validURL != null) {
            System.out.println(validURL);

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(validURL).build();

            try {
                Response response = client.newCall(request).execute();
                result = response.body().string();
            } catch (IOException e) {
                e.printStackTrace(); //TODO: добавить в логгирование.
            }
        }
        return result;
    }
}
