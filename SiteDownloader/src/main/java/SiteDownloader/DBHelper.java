package SiteDownloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public DBHelper() {
        Properties properties = new Properties();
        File dbConfigFile = new File("dbset.cfg");
        try {
            FileInputStream fis = new FileInputStream(dbConfigFile);
            properties.load(fis);
        } catch (IOException e) {
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
            connectionToDB = DriverManager.getConnection("jdbc:" + dbdriver + "://" + dbhost + ":" + dbport + "/" + dbSchemaname + "?useSSL=false", dbLogin, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return Метод возвращает Id текущей выполняемой задачи для краулера. Если задачь с открытым endtime нет, то создает новую c текущим временем.
     **/

    public Integer getCurrentTaskId() {
        Integer result = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = connectionToDB.prepareStatement("select idTasks from tasks where endtime is NULL");
            rs = ps.executeQuery();
            if (rs.next()) { //если запись есть то возвращаем ее id
                result = rs.getInt(1);
            } else { //иначе создаем новую задачу (запись в таблице) и возвращаем ее id.
                ps = connectionToDB.prepareStatement("insert into tasks (startTime) VALUES (?)");
                ps.setString(1, getCurrentDateTime());
                ps.executeUpdate();
                ps = connectionToDB.prepareStatement("select idTasks from tasks where endtime is NULL");
                rs = ps.executeQuery();
                if (rs.next()) { //если запись есть то возвращаем ее id
                    result = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void closeTask(Integer taskId) {
        PreparedStatement ps;
        try {
            ps = connectionToDB.prepareStatement("update tasks set endTime=? WHERE idTasks=" + taskId);
            ps.setString(1, getCurrentDateTime());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUnscanedURL(String url, int level) {
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = connectionToDB.prepareStatement("select url from tmpscanurls where url = ?");
            ps.setString(1, url);
            rs = ps.executeQuery();
            if (!rs.next()) { //Если такой записи нет, то добавляем.
                //INSERT INTO tmpscanurls (`url`) VALUES ('http://test2.url');
                ps = connectionToDB.prepareStatement("insert into tmpscanurls (url, deeplevel) values (?, ?)");
                ps.setString(1, url);
                ps.setInt(2, level);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param workerUID - идентификатор краулера, для каждого запущенного приложения должен быть уникальным.
     * @param limit - количество возвращаемых значений за раз.
     * @return - функция возвращает ArrayList<SpiderURL> полученных из базы, которые еще не были просканированны, но уже закреплены за данным workerом.
     */

    public ArrayList<SpiderURL> getUnscanedUrl(String workerUID, Integer limit) {
        ArrayList<SpiderURL> result = null;
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = connectionToDB.prepareStatement("select url, deeplevel from tmpscanurls where scaned = 0 and worker = ?");
            ps.setString(1, workerUID);
            rs = ps.executeQuery();
            if (!rs.next()) { //Если нет записей помеченных для данного workera, то метим и требуем снова.
                ps = connectionToDB.prepareStatement("update tmpscanurls set worker = ? where worker is null limit ?");
                ps.setString(1,workerUID);
                ps.setInt(2, limit);
                ps.executeUpdate();
                result = getUnscanedUrl(workerUID,limit);
            } else { //TODO: засовываем полученные результаты в result.
                z\sdasdasdaz\c
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private String getCurrentDateTime() {    //выдает дату и время в текущий момент в формате для mysql
        java.util.Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }


}
