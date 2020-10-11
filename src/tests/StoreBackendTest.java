package tests;
import org.junit.Test;
import sample.backend.Player;
import sample.backend.StoreBackend;

import static org.junit.Assert.assertEquals;

public class StoreBackendTest {
    private StoreBackend obj;


    @Test
    public void testSellSuccess() {
        Player.initialize("Bob", 33.35);
        String item = "Tomato";
        int qty = 3;
        assertEquals(false, obj.purchase(item, qty));
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