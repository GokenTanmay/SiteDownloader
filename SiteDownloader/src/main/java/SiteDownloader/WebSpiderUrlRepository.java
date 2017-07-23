package SiteDownloader;

import java.util.HashMap;

/**
 * Created by Serg on 06.07.2017.
 */
public class WebSpiderUrlRepository {
    private HashMap unscanedURL;
    private HashMap scanedURL;

    public WebSpiderUrlRepository() {
        unscanedURL = new HashMap();
        scanedURL = new HashMap();
    }

    /**
     * Метод добавляет SpiderURL и контролиркет его неповторяемость.
     *
     * @param spiderURL - Класс описывающий URL и глубину его сслыки
     */
    public void addUnscanedURL(SpiderURL spiderURL) {
        if ((!unscanedURL.containsKey(spiderURL.getUrl())) && (!scanedURL.containsKey(spiderURL.getUrl()))) {
            unscanedURL.put(spiderURL.getUrl(), spiderURL.getLevel());
        }
    }

    /**
     * @return - Возвращает SpiderURL которые еще ни разу не брались для сканирования. Или если таковых нет то null;
     */
    public SpiderURL getUnscanedURL() {
        SpiderURL result = null;
        if (unscanedURL.entrySet().iterator().hasNext()) {
            HashMap.Entry<String, Integer> firstEntry = (HashMap.Entry<String, Integer>) unscanedURL.entrySet().iterator().next();
            result = new SpiderURL(firstEntry.getKey(), firstEntry.getValue());
            unscanedURL.remove(firstEntry.getKey());
            scanedURL.put(firstEntry.getKey(), firstEntry.getValue());
        }
        return result;
    }

    public HashMap getHashMapScanedURL() {
        return scanedURL;
    }
    public Integer getRepositorySize(){
        return unscanedURL.size();
    }
}
