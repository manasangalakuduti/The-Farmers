package sample.backend;
import java.time.LocalDate;
import java.time.LocalTime;


public class Date {

    public String season;
    public LocalDate date;
    public LocalTime time;

    public Date(String season, LocalDate date, LocalTime time) {
        this.season = season;
        this.date = date;
        this.time = time;
    }

    public String getSeason() {
        return season;
    }
    public LocalDate getDate() {
        return date;
    }
    public LocalTime getTime() {
        return time;
    }
}
