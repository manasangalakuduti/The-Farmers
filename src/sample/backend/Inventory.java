package sample.backend;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Inventory {

    public static final int MAXCAPACITY = 1000;
    private int currOccupied;
    private static String[] items = {"Tomato", "Soybeans",
        "Corn",
        "Peas"
    };


    private static HashSet<String> validItems =
            new HashSet<>(Arrays.asList(items));


    private HashMap<String, Integer> inventoryMap; //map item name to quantity

    //Decide on how we should encode how much space per unit is taken up by
    // an item


    public Inventory() {
        inventoryMap = new HashMap<>();
        this.currOccupied = 0;
        for (String elem: validItems) {
            inventoryMap.put(elem, 0);
        }
    }

    public void addToInventory(String itemName, int quantity) {
        if (!inventoryMap.containsKey(itemName)) {
            System.out.println(String.format("%s is not a valid item for "
                    + "inventory", itemName));
        }
        if (quantity + currOccupied <= MAXCAPACITY) {
            inventoryMap.put(itemName,
                    inventoryMap.getOrDefault(itemName, 0) + quantity);
            currOccupied = currOccupied + quantity;
        }
    }

    public void removeFromInventory(String itemName, int quantity) {
        if (!inventoryMap.containsKey(itemName)) {
            System.out.println(String.format("Cannot remove item because %s is not in "
                    + "inventory", itemName));
        }
        if (quantity <= inventoryMap.get(itemName)) {
            inventoryMap.put(itemName, inventoryMap.get(itemName) - quantity);
            currOccupied = currOccupied - quantity;
        } else {
            System.out.println(String.format("Cannot remove %d of %s because "
                    + "your inventory contains %d of %s", quantity, itemName,
                    inventoryMap.get(itemName), itemName));
        }
    }

    public int getQuantity(String itemName) {
        return inventoryMap.getOrDefault(itemName, 0);
    }

    public boolean hasItem(String itemName) {
        return inventoryMap.getOrDefault(itemName, 0) > 0;
    }

    //How much space is occupied
    public int getCurrOccupied() {
        return currOccupied;
    }
    //Seed types, anything in inventory
    public String[] itemTypes() {
        return items;
    }
    //Quantity of seeds, and anything in inventory
    public int[] quantities() {
        Collection<Integer> vals = inventoryMap.values();
        Integer[] quantities = (Integer[]) vals.toArray();
        int[] qty = new int[quantities.length];
        for (int i = 0; i < quantities.length; i++) {
            qty[i] = quantities[i];
        }
        return qty;
    }
    /*
    //map inventory item to amount of space taken up by a given item
    private HashMap<InventoryItem, Double> inventoryMap;
    public Inventory() {
        inventoryMap = new HashMap<>();
        currCapacity = 0;
    }
    public void addToInventory(InventoryItem item, double quantity) {
        try {
            if (currCapacity + quantity*item.getSpace() <= MAX_CAPACITY) {
                //update the inventory hashmap
                inventoryMap.put(item,
                        quantity*item.getSpace() +
                        inventoryMap.getOrDefault(inventoryMap.get(item), 0.0));
                currCapacity += quantity*item.getSpace();
            } else {
                throw new InventoryOverflowException("Cannot add to inventory"
                        + " because you will have an overflow");
            }
        } catch (InventoryOverflowException overflow) {
            System.out.println(overflow.getMessage());
        }
    }
    public void removeFromInventory(InventoryItem item, double quantity) {
        try {
            if (!inventoryMap.containsKey(item)) {
                System.out.println("Item does not exist");
            }

            if (quantity > Math.floor(inventoryMap.get(item)/item.getSpace())) {
                throw new InventoryUnderflowException(String.format("You "
                        + "don't have enough of %s to get %f of it",
                        item.getName(), quantity));
            } else {

                //update inventory after removing an item
                inventoryMap.put(item,
                        inventoryMap.get(item) - quantity*item.getSpace());
                currCapacity -= quantity*item.getSpace();
            }

        } catch (InventoryUnderflowException underflow) {
            System.out.println(underflow.getMessage());
        }
    }

    public HashMap<InventoryItem, Double> getInventoryMap() {
        return inventoryMap;
    }

    public double getCurrCapacity() {
        return currCapacity;
    }
     */

}
