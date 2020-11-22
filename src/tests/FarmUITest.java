package tests;

import org.junit.Before;
import org.junit.Test;
import sample.backend.Date;
import sample.backend.Player;
import java.text.DecimalFormat;
import static org.junit.Assert.assertEquals;

public class FarmUITest {
    //private Player obj;

    private Date time;
    @Before
    public void setup() {
        Player.initialize("Bob", 33.01);
        time = new Date();
    }

    @Test
    public void testPlayerConstructorName() {
        assertEquals("Bob", Player.getName());
    }

    @Test
    public void testPurchaseSuccess() {
        assertEquals(true, Player.updateBalance(30));
    }

    @Test
    public void testPurchaseFailure() {
        assertEquals(false, Player.updateBalance(35));
    }

    @Test
    public void updateBalanceAfterPurchase() {
        Player.updateBalance(30);
        double resBalance = Player.getBalance();
        DecimalFormat f = new DecimalFormat("##.00");
        assertEquals("3.01", f.format(resBalance));
    }

    @Test
    public void testCurrentDate() {
        time.nextDay();
        assertEquals(1, time.getDate());
    }

}
