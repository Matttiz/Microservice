package db;

import config.PropertiesManager;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.*;

public class DataBaseBasic {
    private static final Properties properties = PropertiesManager.propertiesManager.getProperties();
    private Connection connection = null;
    private Statement statement = null;

    private String query = null;

    @SneakyThrows
    public void initialConnection() {
        Class.forName("org.postgresql.Driver");
        this.connection = DriverManager.getConnection(
                properties.getProperty("driverDB")
                        + "://"
                        + properties.getProperty("addressDB"),
                properties.getProperty("userDB"),
                properties.getProperty("passwordDB"));
    }

    @SneakyThrows
    public void createStatement(String sqlStatement){
        statement = connection.createStatement();
        this.query = sqlStatement;
    }

    @SneakyThrows
    public List<Map<String, Object>> executeQuery(){
        ResultSet resultSet = this.statement.executeQuery(this.query);
        List<Map<String, Object>> result = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> resMap = new HashMap<>();
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                resMap.put(resultSet.getMetaData().getColumnName(i), resultSet.getObject(i));
            }
            result.add(resMap);
        }
        resultSet.close();
        return result;
    }

    @SneakyThrows
    public void closeConnection(){
        this.statement.close();
        this.connection.close();
    }

}
