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
//<<<<<<< HEAD


    @Test
    public void testPurchaseSuccess() {
        Player.initialize("Bob", 33.35);
        String item = "Tomato";
        Market m = new Market(new Date("Spring", LocalDateTime.now()), "Spring");
        StoreBackend.initialize(m);
        assertEquals(false, StoreBackend.purchase(item, 3));
    }


    private StoreBackend obj;

    @Before
    public void setup() {
        Player.initialize("Howdy", 1000);
        Player.updateInventory("Corn", 20);
        Market m = new Market(new Date("Spring", LocalDateTime.now()), "Spring");
        StoreBackend.initialize(m);
        //obj = new StoreBackend("WalMart", new Market(new Date("Fall", LocalDateTime.now()), "Hard"));
        StoreBackend.restock();

    }

    @Test
    public void testSellSuccess() {

        Player.initialize("Bob", 33.35);
        String item = "Tomato";
        assertEquals(false, StoreBackend.purchase(item, 3));
    }






    @Test
    public void testSellFailTooMuch() {
        StoreBackend.sell("Tomato", 30);
        assertEquals(0, Player.getQuantityOf("Tomato"));
    }

    @Test
    public void testBuySuccess() {
        StoreBackend.purchase("Corn", 1);
        assertEquals(21, Player.getQuantityOf("Corn"));
    }

    @Test
    public void testBuyFailureHas() {
        StoreBackend.purchase("Tomato", 25);
        assertEquals(0, Player.getQuantityOf("Tomato"));
    }

    @Test
    public void testBuyTooMuch() {
        StoreBackend.purchase("Corn", 30);
        assertEquals(20, Player.getQuantityOf("Corn"));
    }

}

