package sample.backend;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.time.LocalTime;


public class Date {

    private String season;
    private LocalDateTime date;

    public Date(String season, LocalDateTime date) {
        this.season = season;
        this.date = date;
    }

    public String getSeason() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");
        int month = Integer.parseInt(this.getDate().now().format(dtf));
        String s = "";

        if (month == 3 || month == 4 || month == 5) {
            s = "Spring";
        } else if (month == 6 || month == 7 || month == 8) {
            s = "Summer";
        } else if (month == 9 || month == 10 || month == 11) {
            s = "Fall";
        } else {
            s = "Winter";
        }
        return s;
    }
    public LocalDateTime getDate() {
        return date;
    }
}
