package SiteDownloader;

import java.util.HashMap;

public class ConverterStringToHasMap {
    public HashMap convert(String string){
        HashMap hashMap = new HashMap();
        //Очищаем строку от запятых, точек и переносов.
        String tmpString = "";
        tmpString.replaceAll("[,.\n]", "");

        return hashMap;

    }
}
