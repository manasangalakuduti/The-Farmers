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



    @Test
    public void testTimestamp() {
        //int currY = time.getDate().getDayOfYear();
        assertEquals(0,Date.getDate());
    }

    @Test
    public void testSeasonEqualsMonth() {
        assertEquals("Fall", Date.getSeason());
    }

    @Test
    public void testGetSeason() {
        System.out.println(time.getSeason());
    }
}
