package objects.schedule;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Service {

    private int serviceNumber;
    private Line lineNumber;

    public Service(int serviceNumber, Line lineNumber) {
        this.serviceNumber = serviceNumber;
        this.lineNumber = lineNumber;
    }
}
