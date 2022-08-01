package objects.schedule;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BusStop {

    private String busStopName;
    private short numberBusStop;

    public BusStop(String busStopName, int numberBusStop){
        this.busStopName = busStopName;
        this.numberBusStop = (short) numberBusStop;
    }
}
