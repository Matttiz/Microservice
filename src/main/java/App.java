import db.BusStop;
import utils.ODSReader;
import utils.StringUtilities;

import java.io.File;
import java.util.List;

public class App {
        public static void main(String[] args) {

            String path = System.getProperty("user.dir") + "/src/main/resources/line/Example_A.ods";
//            String path = System.getProperty("user.dir") + "/src/main/resources/line/Example.ods";
            File file = new File(path);
            String content = ODSReader.read(file);


            System.out.println(content);

            List<List<String>> listOfLists = StringUtilities.createListOfLists(content);
            String w = "w";

            BusStop busStop = new BusStop("Grodzisk Dworzec",1);
        }
    }
