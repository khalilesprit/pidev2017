package Tools;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class DataBase {
    private String url;
    private String login;
    private String password;
    private Connection connection;
    private Properties properties;
    private static DataBase instance;
    private DataBase() {
        try {
           properties = new Properties();
            properties.load(new FileInputStream(new File("configuration.properties")));
            url = properties.getProperty("url");
            login = properties.getProperty("login");
            password = properties.getProperty("password");
            
           connection = DriverManager.getConnection(url, login, password);
        
        
        
        } 
            
            
      
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public Connection getConnection() {
        return connection;
    }
    public static DataBase getInstance()  {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }
}