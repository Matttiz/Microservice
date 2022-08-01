package db;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusStop {

    private String busStopName;
    private short numberBusStop;

    public BusStop(String busStopName, int numberBusStop){
        this.busStopName = busStopName;
        this.numberBusStop = (short) numberBusStop;
    }
}
