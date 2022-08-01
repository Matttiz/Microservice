package db;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullLine {
    private Line line;
    private BusStop busStop;
    private short numberBusStopInLine;

    public FullLine(Line line, BusStop busStop, int numberBusStopInLine) {
        this.line = line;
        this.busStop = busStop;
        this.numberBusStopInLine = (short) numberBusStopInLine;
    }
}
