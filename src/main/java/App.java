import config.PropertiesManager;

import java.util.Properties;

public class App {

    public static void main(String[] args) {
        System.out.println("Hej");

        Properties prop = PropertiesManager.propertiesManager.getProperties();
    }
}
