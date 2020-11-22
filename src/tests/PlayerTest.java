package tests;

import org.junit.Before;
import org.junit.Test;
import sample.backend.Market;
import sample.backend.Player;
import sample.backend.StoreBackend;

import static org.junit.Assert.*;

public class PlayerTest {

    @Before
    public void setup() {
        Player.initialize("Manley", 1000);
        Player.updateInventory("Corn", 20);
    }


    //test for limit on irrigation and harvest


    @Test
    public void regLimits() {
        assertEquals(2, Player.getCurrHarvest());
        assertEquals(5, Player.getCurrWater());
    }


    @Test
    public void maximizeYieldAndWaterTest() {
        Player.updateInventory("Tractor", 1);
        Player.updateInventory("Irrigation", 1);
        Player.resetWaterHarvest();
        assertEquals(6, Player.getCurrHarvest());
        assertEquals(10, Player.getCurrWater());
    }

    @Test
    public void testHarvest() {
        Player.resetWaterHarvest();
        Player.harvest();
        assertEquals(1, Player.getCurrHarvest());
        Player.harvest();
        assertEquals(0, Player.getCurrHarvest());
        Player.harvest();
        assertEquals(0, Player.getCurrHarvest());
    }

    @Test
    public void testWater() {
        Player.resetWaterHarvest();
        Player.water();
        assertEquals(4, Player.getCurrWater());
        Player.water();
        assertEquals(3, Player.getCurrWater());
        Player.water();
        assertEquals(2, Player.getCurrWater());

    }

    @Test
    public void testHarvestTooMuch() {
        Player.resetWaterHarvest();
        for (int i = 1; i <= 20; i++) {
            Player.harvest();
        }
        assertNotEquals(-18, Player.getCurrHarvest());
        assertEquals(0, Player.getCurrHarvest());
    }

    @Test
    public void testWaterTooMuch() {
        Player.resetWaterHarvest();
        for (int i = 1; i <= 20; i++) {
            Player.water();
        }
        assertNotEquals(-15, Player.getCurrWater());
        assertEquals(0, Player.getCurrWater());
    }




}
