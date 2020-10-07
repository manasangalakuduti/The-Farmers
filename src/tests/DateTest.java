package tests;

import org.junit.Before;
import org.junit.Test;
import sample.backend.Date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;



public class DateTest {

    private Date time;
    //private LocalDateTime datetime;

    @Before
    public void setup() {
        time = new Date("Fall", LocalDateTime.now());
    }

    @Test
    public void testTimestamp() {
        assertEquals(LocalDateTime.now().getMonth(),
                time.getDate().now().getMonth());
        assertEquals(LocalDateTime.now().getDayOfMonth(),
                time.getDate().now().getDayOfMonth());
        assertEquals(LocalDateTime.now().getYear(),
                time.getDate().now().getYear());
    }

    @Test
    public void testSeasonEqualsMonth() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");
        int month = Integer.parseInt(time.getDate().now().format(dtf));
        String season = "";

        if (month == 3 || month == 4 || month == 5) {
            season = "Spring";
        } else if (month == 6 || month == 7 || month == 8) {
            season = "Summer";
        } else if (month == 9 || month == 10 || month == 11) {
            season = "Fall";
        } else {
            season = "Winter";
        }

        assertEquals(season, time.getSeason());
    }

    @Test
    public void testGetSeason() {
        System.out.println(time.getSeason());
    }
}
