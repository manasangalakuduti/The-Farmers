package tests;

import org.junit.Before;
import org.junit.Test;
import sample.backend.Inventory;

import static org.junit.Assert.assertEquals;

public class InventoryTest {
    private Inventory inventory;

    @Before
    public void setup() {
        inventory = new Inventory();
    }

    @Test
    public void testCurrCapacityInitial() {
        assertEquals(0, inventory.getCurrOccupied());
    }

    //check add and remove configurations. Use setters and getters to check
    // has or quantity

    //test current capacity and calculate remaining space
}
