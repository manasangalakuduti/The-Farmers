package tests;

import org.junit.Test;
import sample.backend.Date;
import sample.backend.Market;
import sample.backend.Player;
import sample.backend.StoreBackend;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class StoreBackendTest {
<<<<<<< HEAD


    @Test
    public void testPurchaseSuccess() {
        Player.initialize("Bob", 33.35);
        String item = "Tomato";
        Market m = new Market(new Date("Spring", LocalDateTime.now()), "Spring");
        StoreBackend.initialize(m);
        assertEquals(false, StoreBackend.purchase(item, 3));
=======
    private StoreBackend obj;
    @Before
    public void setup() {
        Player.initialize("Howdy", 1000);
        Player.updateInventory("Corn", 20);
        obj = new StoreBackend("WalMart", new Market(new Date("Fall", LocalDateTime.now()), "Hard"));
        obj.restock();
>>>>>>> 6d924f10e01c8cd9d19684f2613a940e45158522
    }

    @Test
    public void testSellSuccess() {
<<<<<<< HEAD
        Player.initialize("Bob", 33.35);
        String item = "Tomato";
        Market m = new Market(new Date("Spring", LocalDateTime.now()), "Spring");
        StoreBackend.initialize(m);
        assertEquals(false, StoreBackend.purchase(item, 3));
    }


    /*
=======
        obj.sell("Corn", 1);
        assertEquals(21, Player.getQuantityOf("Corn"));
    }

>>>>>>> 6d924f10e01c8cd9d19684f2613a940e45158522
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