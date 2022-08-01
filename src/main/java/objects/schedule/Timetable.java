package objects.schedule;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Timetable {
    private List<BusStopSchedule> busStopScheduleList = new ArrayList<>();
    private Line line;

    public Timetable(List<List<String>> listOfLists){
        BusStop busStop;
        Schedule schedule;
        for (List<String> list : listOfLists){
            busStop = new BusStop(list.get(1), Integer.parseInt(list.get(2)));
            schedule = new Schedule(
                    list.get(4),
                    Boolean.parseBoolean(list.get(6)),
                    Boolean.parseBoolean(list.get(3)),
                    list.get(5));
            this.busStopScheduleList.add(new BusStopSchedule(busStop, schedule));
        }
        this.line = new Line(
                Integer.parseInt(listOfLists.get(0).get(0)),
                busStopScheduleList.get(0).getBusStop(),
                busStopScheduleList.get(busStopScheduleList.size() - 1).getBusStop()
        );
    }
}
