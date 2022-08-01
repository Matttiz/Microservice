package objects.schedule;

import lombok.Getter;

public enum Season {
    SUMMER("SUMMER"),
    WINTER("WINTER");

    @Getter
    private String season;

    Season(String season) {
        this.season = season.toUpperCase();
    }


}
