package db;

import lombok.Getter;

public enum Season {
    SUMMER("summer"),
    WINTER("winter");

    @Getter
    private String season;

    Season(String season) {
        this.season = season;
    }


}
