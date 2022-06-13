import config.PropertiesManager;
import utils.ArrayWithHeader;
import utils.Reader;

import java.io.File;
import java.util.List;
import java.util.Properties;

public class App {

    public static void main(String[] args) {
        System.out.println("Hej");

        Properties prop = PropertiesManager.propertiesManager.getProperties();

        Reader reader = new Reader();
        String path = System.getProperty("user.dir") + "/src/main/resources/line/Example_13.ods";
        File file = new File(path);
        List<ArrayWithHeader> listOfList = reader.readODS(file);

    }
}
