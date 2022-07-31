import utils.ODSReader;

import java.io.File;

    public class App {
        public static void main(String[] args) {

            String path = System.getProperty("user.dir") + "/src/main/resources/line/Example_A.ods";
//            String path = System.getProperty("user.dir") + "/src/main/resources/line/Example.ods";
            File file = new File(path);
            String content = ODSReader.read(file);


            System.out.println(content);
        }
    }
