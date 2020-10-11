package tests;

import org.junit.Before;
import org.junit.Test;
import sample.backend.Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;



public class DateTest {

    private Date time;
    private int curDay;
    //private LocalDateTime datetime;

    @Before
    public void setup() {
        LocalDateTime ref = LocalDateTime.of(LocalDate.of(2020, 9, 28), LocalTime.of(19, 30, 0, 0));
        int curDay = ref.getDayOfYear();
        System.out.println("CurDay" + curDay);
        time = new Date("Fall", ref);
    }

//    @Test
//    public void testTimestamp() {
//        int currY = time.getDate().getDayOfYear();
//        assertEquals(curDay, time.getDate().getDayOfYear());
//        assertEquals(LocalDateTime.now().getMonth(),
//                time.getDate().now().getMonth());
//        assertEquals(LocalDateTime.now().getDayOfMonth(),
//                time.getDate().now().getDayOfMonth());
//        assertEquals(LocalDateTime.now().getYear(),
//                time.getDate().now().getYear());
//    }

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
