package sample.backend;

public class StoreBackend {
    private String name;
    private Inventory storeInventory;
    // Make an instance of the Market class HERE!
    public StoreBackend(String name) { // Pass a MARKET instance parameter HERE
        this.name = name;
        storeInventory = new Inventory();
        restock();
        //Set the market instance HERE
    }
    public void purchase(String item, int qty) {
        double subtotal = 100.1; //Use MARKET to get the subtotal that COULD be sold HERE
        if (Player.hasItem(item) && Player.getQuantityOf(item) >= qty) { //Player has enough of the item
            if (storeInventory.getCurrOccupied() + qty <= Inventory.maxCapacity) { //Store has enough room
                storeInventory.addToInventory(item, qty);
                Player.updateBalance(-subtotal);
                Player.updateInventory(item, -qty);
            }
        }
        System.out.println("Sorry, either the store doesn't have enough"
                + " space or you don't have enough to sell");
    }
    public boolean sell(String item, int qty) {
        double price = 100.1; //Use MARKET to get the price HERE
        if (storeInventory.hasItem(item) && storeInventory.getQuantity(item) >= qty) { //Store has enough of the item
            if (Player.hasRoom(qty)) { //Player has enough room for the new items
                if (Player.getBalance() >= price) { // Player has enough MONEY
                    storeInventory.addToInventory(item, -qty);
                    Player.updateBalance(price);
                    return true;
                }
            }
        }
        return false;
    }
    public void restock() {
        for (String item : storeInventory.itemTypes()) {
            storeInventory.addToInventory(item, -1 * storeInventory.getQuantity(item));
            storeInventory.addToInventory(item, 10 + (int)(Math.random() * 30));
        }
    }
}
