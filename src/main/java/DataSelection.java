import config.PropertiesManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


public class DataSelection {

    public static void main(String args[]) {
        Properties prop = PropertiesManager.propertiesManager.getProperties();

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(
                    prop.getProperty("driverDB")
                            + "://"
                            + prop.getProperty("addressDB"),
                    prop.getProperty("userDB"),
                    prop.getProperty("passwordDB"));
//     c.setAutoCommit(false);
            System.out.println("Successfully Connected.");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from public.\"line\" ;");
            while (rs.next()) {
                int line = rs.getInt("line");
                System.out.println(line);
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println(" Data Retrieved Successfully ..");
    }
}