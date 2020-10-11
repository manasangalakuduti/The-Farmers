package tests;

import org.junit.Test;
import sample.backend.Date;
import sample.backend.Market;
import sample.backend.Player;
import sample.backend.StoreBackend;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class StoreBackendTest {


    @Test
    public void testPurchaseSuccess() {
        Player.initialize("Bob", 33.35);
        String item = "Tomato";
        Market m = new Market(new Date("Spring", LocalDateTime.now()), "Spring");
        StoreBackend.initialize(m);
        assertEquals(false, StoreBackend.purchase(item, 3));
    }

    @Test
    public void testSellSuccess() {
        Player.initialize("Bob", 33.35);
        String item = "Tomato";
        Market m = new Market(new Date("Spring", LocalDateTime.now()), "Spring");
        StoreBackend.initialize(m);
        assertEquals(false, StoreBackend.purchase(item, 3));
    }


    /*
    @Test
    public void testSellFailureBalance(){
        String item = "Tomato";
        int qty = 100;
        assertEquals(false, obj.sell(item, qty));
    }
    @Test
    public void testSellFailureRoom(){
        String item = "Tomato";
        int qty = 100;
        assertEquals(false, obj.sell(item, qty));
    }
    @Test
    public void testBuySuccess(){
        Player p1 = new Player("Bob", 33.35);
        String item = "Tomato";
        int qty = 3;
        assertEquals(true, obj.sell(item, qty));
    }

    @Test
    public void testBuyFailureBalance(){
        String item = "Tomato";
        int qty = 100;
        assertEquals(false, obj.sell(item, qty));
    }
    @Test
    public void testBuyFailureRoom(){
        String item = "Tomato";
        int qty = 100;
        obj.sell(item, qty);
    }*/
}