package tests;
import org.junit.Before;
import org.junit.Test;
import sample.backend.Date;
import sample.backend.Market;
import sample.backend.Player;
import sample.backend.StoreBackend;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class StoreBackendTest {
    private StoreBackend obj;
    @Before
    public void setup() {
        Player.initialize("Howdy", 1000);
        Player.updateInventory("Corn", 20);
        obj = new StoreBackend("WalMart", new Market(new Date("Fall", LocalDateTime.now()), "Hard"));
        obj.restock();
    }

    @Test
    public void testSellSuccess() {
        obj.sell("Corn", 1);
        assertEquals(21, Player.getQuantityOf("Corn"));
    }

    @Test
    public void testSellFailTooMuch() {
        obj.sell("Tomato", 30);
        assertEquals(0, Player.getQuantityOf("Tomato"));
    }

    @Test
    public void testBuySuccess() {
        obj.purchase("Corn", 15);
        assertEquals(5, Player.getQuantityOf("Corn"));
    }
    @Test
    public void testBuyFailureHas() {
        obj.purchase("Tomato", 25);
        assertEquals(0, Player.getQuantityOf("Tomato"));
    }
    @Test
    public void testBuyTooMuch() {
        obj.purchase("Corn", 30);
        assertEquals(20, Player.getQuantityOf("Corn"));
    }
}