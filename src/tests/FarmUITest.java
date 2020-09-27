import sample.backend.Player;
import org.junit.Before;
import org.junit.Test;
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


}
