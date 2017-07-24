package SiteDownloader;
import java.util.regex.*;

public class TextExctractor {
    String result = "";
    Pattern pattern_title;
    String tmphtmlbody;

    public TextExctractor() {
        pattern_title = Pattern.compile("(<title>)(.*)(<\\/title>)");
    }

    public String Extract(String htmlbody){
        this.tmphtmlbody = htmlbody;
        Matcher matcher_title = pattern_title.matcher(tmphtmlbody);
        while (matcher_title.find()){
            result = result + " " + tmphtmlbody.substring(matcher_title.start(), matcher_title.end());
        }
    return result;
    }
}
