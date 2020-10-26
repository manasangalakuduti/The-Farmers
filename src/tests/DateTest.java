package tests;

import org.junit.Test;
import sample.backend.Date;


import static org.junit.Assert.assertEquals;



public class DateTest {

    private Date time;
    private int curDay;
    //private LocalDateTime datetime;



    @Test
    public void testTimestamp() {
        //int currY = time.getDate().getDayOfYear();
        assertEquals(1, Date.getDate());
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
