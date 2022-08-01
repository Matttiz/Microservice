package db;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusStop {


    private String busStopName;
    private short numberBusStop;

    public BusStop(String busStopName, short numberBusStop){
        this.busStopName = busStopName;
//        if(numberBusStop)
        this.numberBusStop =  numberBusStop;
    }

}
