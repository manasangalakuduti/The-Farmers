package sample.backend;

import sample.frontend.ConfigurationScreen;

import java.util.HashMap;

public class StoreBackend {
    private static Inventory storeInventory;
    private static Market market;

    public static Market getMarket() {
        return market;
    }

    public static void initialize(Market market) {
        StoreBackend.market = market;
        storeInventory = new Inventory();
        restock();
    }

    public Market getMarketInfo() {
        return this.market;
    }

    public static void sell(String item, int qty) {
        double subtotal = market.getPrice(item, qty);
        if (Player.hasItem(item)
                && Player.getQuantityOf(item) >= qty) { //Player has enough of the item
            if (storeInventory.getCurrOccupied() + qty
                    <= Inventory.MAXCAPACITY) { //Store has enough room
                storeInventory.addToInventory(item, qty);
                Player.updateBalance(-subtotal);
                Player.updateInventory(item, -qty);
            }
        } else {
            System.out.println("Sorry, either the store doesn't have enough"
                    + " space or you don't have enough to sell");
        }
    }
    public static boolean purchase(String item, int qty) {
        double price = market.getPrice(item, qty);
        if (storeInventory.hasItem(item)
                && storeInventory.getQuantity(item) >= qty) { //Store has enough of the item
            if (Player.hasRoom(qty)) { //Player has enough room for the new items
                if (Player.getBalance() >= price) { // Player has enough MONEY
                    storeInventory.removeFromInventory(item, qty);
                    Player.updateInventory(item, qty);
                    Player.updateBalance(price);
                    return true;
                }
            }
        }
        return false;
    }
    public static void restock() {
        //based on season in future
        for (String item : storeInventory.itemTypes()) {
            storeInventory.addToInventory(item, -1 * storeInventory.getQuantity(item));
            storeInventory.addToInventory(item, 10 + (int) (Math.random() * 30));
        }
    }

    // Method called in nextDay() to update the price (for variance) every day
    public static void updatePrice() {
        for (String s: market.getItemPrice().keySet()) {
            market.setPrice(s);
        }
    }
}
