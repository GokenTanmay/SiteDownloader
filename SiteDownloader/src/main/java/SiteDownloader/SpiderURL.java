package SiteDownloader;

/**
 * Created by Serg on 06.07.2017.
 */
public class SpiderURL {
    private String url;
    private int level;

    public SpiderURL(String url, int level){
        this.url = url;
        this.level = level;
    }

    public String getUrl() {
        return url;
    }

    public int getLevel() {
        return level;
    }
}
