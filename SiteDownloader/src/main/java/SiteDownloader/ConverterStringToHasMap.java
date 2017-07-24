package SiteDownloader;

import java.util.ArrayList;
import java.util.HashMap;

public class ConverterStringToHasMap {
    public HashMap convert(String string){
        HashMap hashMap = new HashMap();
        //Очищаем строку от запятых, точек и переносов и прочих знаков препинаний.
        String tmpString = "";
        tmpString = string.replaceAll("[,.\n\\[\\]\"\\(\\)\\«\\»\\—]", "").toLowerCase();
        System.out.println(tmpString.split(" ").length);

        for (String word: tmpString.split(" ")) {
            if(hashMap.containsKey(word)){
                Integer i = (Integer) hashMap.get(word);
                i++;
                hashMap.put(word, i);
            } else {
                hashMap.put(word, 1);
            }
        }
        return hashMap;
    }
}
