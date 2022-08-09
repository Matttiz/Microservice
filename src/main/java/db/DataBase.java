package db;

import objects.schedule.*;

import java.util.List;

public class DataBase extends DataBaseBasic{

    public DataBase(){};


    public void insertIntoDB(Timetable timetable){

        List<BusStopSchedule> busStopScheduleList = timetable.getBusStopScheduleList();
        busStopScheduleList.get(0).getBusStop();
        busStopScheduleList.get(0).getSchedule();



//        Line line = timetable.getLine();
//        timetable.getFullLineList();
//        timetable.getBusStopScheduleList();


//        this.busStopScheduleList.add(new BusStopSchedule(busStop, schedule));
//        this.fullLineList.add(new FullLine(this.line, busStop, index));
//        Line(int lineNumber, BusStop startBusStop, objects.schedule.BusStop endBusStop)
    }

}
