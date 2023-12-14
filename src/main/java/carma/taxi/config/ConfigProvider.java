package carma.taxi.config;

import java.io.IOException;
import java.util.Properties;

public class ConfigProvider {
    public static final Properties properties = initProperties();
    public static final String BASE_URL = properties.getProperty("base.url");
    public static final long TIMEOUT = Long.parseLong(properties.getProperty("timeout"));

    public static String getDriverName(){

        return properties.getProperty("driver");
    }
    public static Properties initProperties (){
        Properties properties = new Properties();
        try{
            properties.load(ClassLoader.getSystemResourceAsStream("config.properties"));
        }
        catch (IOException e){
            System.err.println("Could not load properties.");
        }
        return properties;

    }
}
