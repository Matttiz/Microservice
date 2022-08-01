package objects.schedule;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
