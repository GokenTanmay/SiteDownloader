package SiteDownloader;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Serg on 06.07.2017.
 */
public class WebSpiderUrlRepository {
    private HashMap unscanedURL;
    private HashMap scanedURL;
    private DBHelper dbHelper;
    ArrayList<SpiderURL> spiderURLS;

    public WebSpiderUrlRepository() {
        unscanedURL = new HashMap();
        scanedURL = new HashMap();
        dbHelper = new DBHelper();
        spiderURLS = new ArrayList<SpiderURL>();
    }

    /**
     * Метод добавляет SpiderURL и контролиркет его неповторяемость.
     *
     * @param spiderURL - Класс описывающий URL и глубину его сслыки
     */
    public void addUnscanedURL(SpiderURL spiderURL) {
        dbHelper.addUnscanedURL(spiderURL.getUrl(),spiderURL.getLevel());
//        if ((!unscanedURL.containsKey(spiderURL.getUrl())) && (!scanedURL.containsKey(spiderURL.getUrl()))) {
//            unscanedURL.put(spiderURL.getUrl(), spiderURL.getLevel());

    }

    /**
     * @return - Возвращает SpiderURL которые еще ни разу не брались для сканирования. Или если таковых нет то null;
     */
    public SpiderURL getUnscanedURL() {
        SpiderURL result = null;
        if(spiderURLS.size() == 0){
            if((spiderURLS = dbHelper.getUnscanedUrl("wrk1", 100)).size() == 0){ //TODO: сделать определение UID воркера.
                return null;
            }
        }

        result = spiderURLS.get(0);
        spiderURLS.remove(0);
        dbHelper.setStatusScaned(result.getUrl());

//        if (unscanedURL.entrySet().iterator().hasNext()) {
//            HashMap.Entry<String, Integer> firstEntry = (HashMap.Entry<String, Integer>) unscanedURL.entrySet().iterator().next();
//            result = new SpiderURL(firstEntry.getKey(), firstEntry.getValue());
//            unscanedURL.remove(firstEntry.getKey());
//            scanedURL.put(firstEntry.getKey(), firstEntry.getValue());
//        }
        return result;
    }

    public HashMap getHashMapScanedURL() {
        return scanedURL;
    }
    public Integer getRepositorySize(){
        return unscanedURL.size();
    }
}
