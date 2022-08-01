package db;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Service {

    private int serviceNumber;
    private int lineNumber;

    public Service(int serviceNumber, int lineNumber) {
        this.serviceNumber = serviceNumber;
        this.lineNumber = lineNumber;
    }
}
