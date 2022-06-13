package config;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesManager {
    public static PropertiesManager propertiesManager = new PropertiesManager();

    private Properties properties = new Properties();

    @SneakyThrows
    private PropertiesManager() {
        InputStream input = new FileInputStream(
                System.getProperty("user.dir")
                        + "/release.properties");
        properties.load(input);
    }

    public Properties getProperties() {
        return properties;
    }

}
