package SiteDownloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {

    private Connection connectionToDB;
    private String dbhost = "";
    private int dbport = 0;
    private String dbSchemaname = "";
    private String dbLogin = "";
    private String dbPassword = "";
    private String dbClassForName = "";
    private String dbdriver = "";

    public DBHelper(){
        Properties properties = new Properties();
        File dbConfigFile = new File("dbset.cfg");
        try{
            FileInputStream fis = new FileInputStream(dbConfigFile);
            properties.load(fis);
        } catch (IOException e){
            e.printStackTrace();
        }
        dbhost = properties.getProperty("DBHOST");
        dbport = Integer.parseInt(properties.getProperty("DBPORT"));
        dbSchemaname = properties.getProperty("DBSCHEMANAME");
        dbLogin = properties.getProperty("DBLOGIN");
        dbPassword = properties.getProperty("DBPASSWORD");
        dbClassForName = properties.getProperty("DBCLASSFORNAME");
        dbdriver = properties.getProperty("DBDRIVER");

        //Дело в том, что Class.forName() приводит к загрузке класса и инициализации его статической части.
        //В свою очередь многие JDBC драйвера при статической инициализации регистрируют себя в DriverManager'е. Так что все дело в side effect'ах.

        try {
            Class.forName(dbClassForName);
            connectionToDB = DriverManager.getConnection("jdbc:" + dbdriver + "://" + dbhost + ":" + dbport + "/" + dbSchemaname + "?useSSL=false", dbLogin , dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
