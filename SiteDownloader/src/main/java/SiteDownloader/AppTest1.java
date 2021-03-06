package SiteDownloader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AppTest1 {
    public static void main(String[] args) {

//        StringBuilder sb = new StringBuilder();
//
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("body.html"));
//            String s;
//            while ((s = bufferedReader.readLine()) != null) {
//                sb.append(s);
//                sb.append("\n");
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//
//        Parser parser = new Parser(sb.toString(), "body");
//
//        System.out.println(new ConverterStringToHasMap().convert(parser.getTextOnly()));
//
//        HashMap hashMap = new HashMap();
//        hashMap.put("1", 1);
//        hashMap.put("2", 2);
//
//        System.out.println(hashMap);
//
//        hashMap.put("1", 3);
//
//        System.out.println(hashMap);
//        System.out.println(hashMap.get("1"));

        DBHelper dbHelper = new DBHelper();
        Integer i = dbHelper.getCurrentTaskId();
        System.out.println(i);
        //dbHelper.closeTask(i);

        dbHelper.addUnscanedURL("http://test1.url", 1);
        dbHelper.addUnscanedURL("http://test2.url", 2);
        dbHelper.addUnscanedURL("http://test3.url", 3);
        dbHelper.addUnscanedURL("http://test4.url", 4);
        dbHelper.addUnscanedURL("http://test5.url", 5);

        ArrayList<SpiderURL> spiderURLS = dbHelper.getUnscanedUrl("wrkUID1", 2);

        for (SpiderURL spiderURL:spiderURLS) {
            System.out.println(spiderURL.getUrl());
            dbHelper.setStatusScaned(spiderURL.getUrl());
        }



    }
}
