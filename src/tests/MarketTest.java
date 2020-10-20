package tests;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import sample.backend.Date;
import sample.backend.Market;

import java.time.LocalDateTime;
import java.util.HashMap;


public class MarketTest {

    private Market market;

    @Before
    public void setup() {
        market = new Market( "Hard");
    }

    @Test
    public void testHashMapInitialization() {
        HashMap<String, Double> expectedHM = new HashMap<String, Double>();
        expectedHM.put("Tomato", 150.0);
        expectedHM.put("Soybeans", 150.0);
        expectedHM.put("Corn", 150.0);
        expectedHM.put("Peas", 150.0);
        assertEquals(expectedHM, market.getItemPrice());
    }

    @Test
    public void testQuantityPrice() {
        assertEquals(450.0, market.getPrice("Tomato", 3), 0.1);
        assertEquals(1200.0, market.getPrice("Soybeans", 8), 0.1);
        assertEquals(1650.0, market.getPrice("Peas", 11), 0.1);
    }
}
