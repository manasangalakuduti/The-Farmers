package tests;

import org.junit.Before;
import org.junit.Test;
import sample.backend.Inventory;

import static org.junit.Assert.*;

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
//    @Test

//    public void testHasValidItem() {
//        assertEquals(true, inventory.hasItem("Tomato"));
//    }

    @Test
    public void testHasInvalidItem() {
        assertEquals(false, inventory.hasItem("COVID-19"));
    }

    @Test
    public void testInventoryAdd() {
        inventory.addToInventory("Tomato", 950);
        assertEquals(950, inventory.getQuantity("Tomato"));
    }

    @Test
    public void testInventoryExceedCapacity() {
        inventory.addToInventory("Corn", 1005);
        assertEquals(0, inventory.getCurrOccupied());
        assertFalse(inventory.getCurrOccupied() == 1005);
    }

    @Test
    public void testRemoveAndAdd() {
        inventory.addToInventory("Tractor", 950);
        inventory.addToInventory("Corn", 30);
        assertEquals(980, inventory.getCurrOccupied());
        inventory.removeFromInventory("Tractor", 40);
        inventory.removeFromInventory("Corn", 10);
        assertTrue(inventory.getQuantity("Tractor") == 910);
        assertTrue(inventory.getQuantity("Corn") == 20);
        assertEquals(930, inventory.getCurrOccupied());
    }





    //check add and remove configurations. Use setters and getters to check
    // has or quantity

    //test current capacity and calculate remaining space
}
