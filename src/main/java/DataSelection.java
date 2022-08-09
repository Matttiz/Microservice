import db.DataBaseBasic;

import java.util.List;
import java.util.Map;


public class DataSelection {

    public static void main(String args[]) {
        DataBaseBasic dbBasic = new DataBaseBasic();
        dbBasic.initialConnection();
        System.out.println("Successfully Connected.");
        dbBasic.createStatement("select * from public.\"line\" ;");
        List<Map<String, Object>> result =  dbBasic.executeQuery();
        dbBasic.closeConnection();
        System.out.println(" Data Retrieved Successfully ..");
    }
}