package sample.tests;

import sample.backend.Date;
import sample.backend.Player;
import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;
public class FarmUITest {
    private Player obj;
    @Before
    public void setup() {
        obj = new Player("Bob", 33.01);
    }

    @Test
    public void testPlayerConstructorName() {
        assertEquals("Bob", obj.getName());
    }

    @Test
    public void testPurchaseSuccess() {
        assertEquals(true, obj.purchaseObject(30));
    }

    @Test
    public void testPurchaseFailure() {
        assertEquals(false, obj.purchaseObject(35));
    }

    @Test
    public void updateBalanceAfterPurchase() {
        obj.purchaseObject(30);
        double resBalance = obj.getBalance();
        DecimalFormat f = new DecimalFormat("##.00");
        assertEquals("3.01", f.format(resBalance));
    }

    @Test
    public void testCurrentDate() {
        Date d = new Date("Summer", LocalDateTime.now());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        assertEquals(LocalDateTime.now().format(format),
                    d.getDate().now().format(format));
    }


}
