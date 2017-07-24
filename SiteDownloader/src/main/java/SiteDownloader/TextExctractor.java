package SiteDownloader;
import java.util.regex.*;

public class TextExctractor {
    String result = "";
    Pattern pattern_title;
    Pattern pattern_script;
    Pattern pattern_href;
    Pattern pattern_cdata;
    String tmphtmlbody;

    public TextExctractor(String htmlbody) {
        this.tmphtmlbody = htmlbody.replaceAll("\n", ""); //Удаляем все переносы, потому чт омешаются в регекспах.

        pattern_title = Pattern.compile("(\\<title\\>)(.*)(<\\/title\\>)");
        pattern_script = Pattern.compile("(\\<script)(.*)(\\<\\/script\\>)");
        pattern_href = Pattern.compile("(\\<link href)(.*)(\\/\\>)");
        pattern_cdata = Pattern.compile("\\/\\/\\<\\!\\[CDATA\\[(.*)\\/\\/\\]\\]\\>");


    }

    public String Extract(){
        Matcher matcher_title = pattern_title.matcher(tmphtmlbody); //Извлекаем title.
        while (matcher_title.find()){
            result = result + " " + tmphtmlbody.substring(matcher_title.start()+7, matcher_title.end()-8);
            tmphtmlbody = matcher_title.replaceAll("");
        }

//        Matcher matcher_script = pattern_script.matcher(tmphtmlbody); // Скрипты
//        tmphtmlbody = matcher_script.replaceAll("");

//        Matcher matcher_href = pattern_href.matcher(tmphtmlbody); //Ссылки
//        tmphtmlbody = matcher_href.replaceAll("");

        Matcher matcher_cdata = pattern_cdata.matcher(tmphtmlbody); //Удаляем CDATA
        tmphtmlbody = matcher_cdata.replaceAll("");


    return result;
    }

    public String getTmphtmlbody(){
        return tmphtmlbody.toString();
    }
}
