package db;

import objects.schedule.BusStop;
import objects.schedule.Schedule;

public class ScheduleDataBase extends DataBaseBasic{

    private Schedule schedule;

    public ScheduleDataBase(Schedule schedule){
        this.initialConnection();
        this.schedule = schedule;
    }

    public boolean IsScheduleExistInDB(){
        String query = "select * from schedule where 1=1"
                + " and service_number = '"  + this.schedule.getServiceNumber()
                + "' and time = '" + this.schedule.getTime()
                + "' and is_holiday = '" + this.schedule.isHoliday()
//                + " and bus_stop_id = " + this.schedule.
                + "' and on_demand = '" + this.schedule.isOnDemand()
                + "' and season = '" + this.schedule.getSeason()
                + "';";

        this.createStatement(query);
        return this.isResultsExistExecuteQuery();
    }

    public void insertScheduleToDB(BusStop busStop){
        BusStopDataBase busStopDataBase = new BusStopDataBase(busStop);
        if(busStopDataBase.getID() == 0){
            busStopDataBase.insertBusStopToDB();
        }
        int busStopId = busStopDataBase.getID();
        String query = "insert into ( service_number, time, is_holiday, bus_stop_id, on_demand, season)"
                + "values ('"
                + this.schedule.getServiceNumber()
                + "', '"
                + this.schedule.getTime()
                + "', '"
                + this.schedule.isHoliday()
                + "', '"
                + busStopId
                + "', '"
                + this.schedule.isOnDemand()
                + "', '"
                + this.schedule.getSeason()
                + ",);";
        this.createStatement(query);
        this.executeQuery();
    }

    public void addScheduleToDBIfIsNotPresent(BusStop busStop){
        if(!IsScheduleExistInDB()){
            insertScheduleToDB(busStop);
        }
    }

    public void closeConnection(){
        this.closeConnection();
    }
}
