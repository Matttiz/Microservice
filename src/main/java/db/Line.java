package db;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Line {

    private short lineNumber;
    private BusStop startBusStop;
    private BusStop endBusStop;

    public Line(int lineNumber, BusStop startBusStop, BusStop endBusStop){
        this.lineNumber = (short) lineNumber;
        this.startBusStop = startBusStop;
        this.endBusStop = endBusStop;
    }
}
