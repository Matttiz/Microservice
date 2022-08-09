package objects.schedule;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Timetable {
    private List<BusStopSchedule> busStopScheduleList = new ArrayList<>();
    private List<FullLine> fullLineList = new ArrayList<>();
    private Line line;

    @SneakyThrows
    public Timetable(List<List<String>> listOfLists){
        if (listOfLists == null || listOfLists.isEmpty()){
            throw new IllegalArgumentException("ListOfLists can't be empty or null");
        }
        BusStop busStop;
        Schedule schedule;
        for (List<String> list : listOfLists){
            busStop = new BusStop(list.get(1), Integer.parseInt(list.get(2)));
            schedule = new Schedule(
                    list.get(4),
                    Boolean.parseBoolean(list.get(6)),
                    Boolean.parseBoolean(list.get(3)),
                    list.get(5),
                    Integer.parseInt(list.get(7))
            );
            this.busStopScheduleList.add(new BusStopSchedule(busStop, schedule));
        }
        this.line = new Line(
                Integer.parseInt(listOfLists.get(0).get(0)),
                busStopScheduleList.get(0).getBusStop(),
                busStopScheduleList.get(busStopScheduleList.size() - 1).getBusStop()
        );
        int index = 1;
        for(BusStopSchedule busStopSchedule : busStopScheduleList){
            busStop = busStopSchedule.getBusStop();
            this.fullLineList.add(new FullLine(this.line, busStop, index));
            index++;
        }
    }

    public static List<Timetable> getListOfTimetables(List<List<String>> listOfLists){
        List<Timetable> result = new ArrayList<>();
        List<Integer> serviceList = listOfLists.stream().map(list -> Integer.parseInt(list.get(7))).distinct().toList();
        List<List<String>> listForTimetables;
        for(int service : serviceList) {
            listForTimetables = listOfLists.stream().filter(list -> Integer.parseInt(list.get(7)) == service).collect(Collectors.toList());
            Timetable timetable = new Timetable(listForTimetables);
            result.add(timetable);
        }
        return result;
    }
}
