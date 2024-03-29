package objects.schedule;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class Schedule {

    static String hourAndMinutePattern = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$";
    static Pattern pattern = Pattern.compile(hourAndMinutePattern);
    private String time;
    private boolean isHoliday;
    private boolean isOnDemand;
    private Season season;
    private int serviceNumber;
    public Schedule(String time, boolean isHoliday, boolean isOnDemand, String season, int serviceNumber) {
        Matcher matcher = pattern.matcher(time);
        if(!matcher.find()){
            throw new IllegalArgumentException("Time should have format HH:MM.!");
        }else{
            this.time = time;
        }
        this.isHoliday = isHoliday;
        this.isOnDemand = isOnDemand;
        this.season = Season.valueOf(season.toUpperCase());
        this.serviceNumber = serviceNumber;
    }
}
