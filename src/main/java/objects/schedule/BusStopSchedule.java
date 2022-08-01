package objects.schedule;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusStopSchedule {

    private BusStop busStop;
    private Schedule schedule;

    public BusStopSchedule(BusStop busStop, Schedule schedule){
        this.busStop = busStop;
        this.schedule = schedule;
    }
}
