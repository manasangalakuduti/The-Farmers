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
        System.out.println("OLD PLAYER CORN: " + Player.getQuantityOf("Corn"));
        obj = new StoreBackend("WalMart", new Market(new Date("Fall", LocalDateTime.now()), "Hard"));
        obj.restock();
    }

    @Test
    public void testSellSuccess() {
        System.out.println("Sell success");
        obj.sell("Corn", 1);
        System.out.println("NEW PLAYER CORN: " + Player.getQuantityOf("Corn"));
        assertEquals(21, Player.getQuantityOf("Corn"));
    }

    @Test
    public void testBuySuccess() {
        System.out.println("Buy Success");
        obj.purchase("Corn", 15);
        System.out.println("NEW PLAYER CORN: " + Player.getQuantityOf("Corn"));
        assertEquals(5, Player.getQuantityOf("Corn"));
    }
    @Test
    public void testBuyFailureHas() {
        System.out.println("Buy failure 1");
        obj.purchase("Tomato", 25);
        System.out.println("NEW PLAYER CORN: " + Player.getQuantityOf("Corn"));
        assertEquals(0, Player.getQuantityOf("Tomato"));
    }
    @Test
    public void testBuyTooMuch() {
        System.out.println("Buy failure 2");
        obj.purchase("Corn", 30);
        System.out.println("NEW PLAYER CORN: " + Player.getQuantityOf("Corn"));
        assertEquals(20, Player.getQuantityOf("Corn"));
    }
}