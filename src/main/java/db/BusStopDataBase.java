package db;

import objects.schedule.BusStop;

import java.util.List;
import java.util.Map;

public class BusStopDataBase extends DataBaseBasic{

    private BusStop busStop;

    public BusStopDataBase(BusStop busStop){
        this.initialConnection();
        this.busStop = busStop;
    }

    public boolean IsBusStopExistInDB(){
        String query = "select * from bus_stop where 1=1"
                + " and name = '" + this.busStop.getBusStopName()
                + "' and number = '" + this.busStop.getNumberBusStop()
                + "';";

        this.createStatement(query);
        return this.isResultsExistExecuteQuery();
    }

    public void insertBusStopToDB(){
        String query = " insert into bus_stop (name, number) "
                + "values ('"
                + this.busStop.getBusStopName()
                + "', '"
                + this.busStop.getNumberBusStop()
                + ");";
        this.createStatement(query);
        this.executeQuery();
    }

    public void addBusStopToDBIfIsNotPresent(){
        if(!IsBusStopExistInDB()){
            insertBusStopToDB();
        }
    }

    public void closeConnection(){
        this.closeConnection();
    }

    public Object selectBusStopFromDB(String columnName){
        String query = "select * from bus_stop where 1=1"
                + " and name = '" + this.busStop.getBusStopName()
                + "' and number = '" + this.busStop.getNumberBusStop()
                + "';";

        this.createStatement(query);
        List<Map<String, Object>> result = this.executeQuery();
        if(result.size() !=1){
            throw new IllegalStateException("Expected that result have only one row");
        }
        return result.get(0).get(columnName);
    }


    public int getID(){
        if(IsBusStopExistInDB()){
            return 0;
        }else{
            return (int) selectBusStopFromDB("id");
        }
    }
}
