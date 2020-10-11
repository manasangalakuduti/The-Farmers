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
}
