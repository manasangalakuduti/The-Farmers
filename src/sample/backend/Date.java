package sample.backend;
import java.time.LocalDateTime;
//import java.time.LocalTime;


public class Date {

    private String season;
    private LocalDateTime date;

    public Date(String season, LocalDateTime date) {
        this.season = season;
        this.date = date;
    }

    public String getSeason() {
        return season;
    }
    public LocalDateTime getDate() {
        return date;
    }
}
