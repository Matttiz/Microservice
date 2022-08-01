package db;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Schedule {
    private String time;
    private boolean isHoliday;
    private boolean isOnDemand;
    private Season season;
}
