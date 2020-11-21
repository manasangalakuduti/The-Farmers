package tests;

import org.junit.Before;
import org.junit.Test;
import sample.backend.Inventory;
import sample.backend.Market;
import sample.backend.Player;
import sample.backend.StoreBackend;

import static org.junit.Assert.*;

public class PlayerTest {

    @Before
    public void setup() {
        Player.initialize("Manley", 1000);
        Player.updateInventory("Corn", 20);
        Market m = new Market("Spring");
        StoreBackend.initialize(m);
        StoreBackend.restock();
    }

    @Test
    public void testSellSuccess() {

        Player.initialize("Bob", 33.35);
        String item = "Tomato";
        assertEquals(false, StoreBackend.purchase(item, 3));
    }

    //test for limit on irrigation and harvest

    @Test
    public void populatePlayerInventoryTest() {
        Player.initialize("Manley", 1000);
        StoreBackend.purchase("Soybeans", 15);
        assertEquals(15, Player.getQuantityOf("Soybeans"));

    }

    @Test
    public void regLimits() {
        assertEquals(2, Player.getCurrHarvest());
        assertEquals(5, Player.getCurrWater());
    }

    @Test
    public void maximizeYieldAndWaterTest() {
        Player.initialize("Tracty Tractor and Eerie Irrigation", 1000);
        StoreBackend.purchase("Tractor", 1);
        StoreBackend.purchase("Irrigation", 1);
        Player.resetWaterHarvest();
        assertEquals(6, Player.getCurrHarvest());
        assertEquals(10, Player.getCurrWater());
    }

    @Test
    public void testPlayerBoughtTooMuch() {
        Player.initialize("Extreme Consumer", 1000);
        StoreBackend.purchase("Corn", 10000);
        assertNotEquals(20, Player.getQuantityOf("Corn"));
    }




}
