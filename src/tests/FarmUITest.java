package tests;

import org.junit.Before;
import org.junit.Test;
import sample.backend.Date;
import sample.backend.Player;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;
public class FarmUITest {
    //private Player obj;
    @Before
    public void setup() {
        Player.initialize("Bob", 33.01);
    }

    @Test
    public void testPlayerConstructorName() {
        assertEquals("Bob", Player.getName());
    }

    @Test
    public void testPurchaseSuccess() {
        assertEquals(true, Player.purchaseObject(30));
    }

    @Test
    public void testPurchaseFailure() {
        assertEquals(false, Player.purchaseObject(35));
    }

    @Test
    public void updateBalanceAfterPurchase() {
        Player.purchaseObject(30);
        double resBalance = Player.getBalance();
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
