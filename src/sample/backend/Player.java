package sample.backend;

public class Player {
    private static double balance;
    private static String name;
    private static Inventory playerInventory; //player inventory
    public static void initialize(String name, double balance) {
        Player.balance = balance;
        Player.name = name;
        Player.playerInventory = new Inventory();
    }

    /**
     * In later iterations, this will not only modify the price,
     * but also add to inventory
     * @param price the cost of the object
     * @return whether purchase went through
     */
    public static boolean updateBalance(double price) {
        if (balance >= price || price < 0) {
            balance -= price;
            return true;
        }
        System.out.println("Sorry, but you do not have the funds to make that purchase");
        return false;
    }
    public static double getBalance() {
        return balance;
    }
    public static String getName() {
        return name;
    }
    public static void updateInventory(String item, int qty) {
        if (qty > 0) {
            playerInventory.addToInventory(item, qty);
        } else {
            playerInventory.removeFromInventory(item, -qty);
        }

    }
    public static boolean hasItem(String item) {
        return playerInventory.hasItem(item);
    }
    public static int getQuantityOf(String item) {
        return playerInventory.getQuantity(item);
    }
    public static boolean hasRoom(int space) {
        return playerInventory.getCurrOccupied() + space <= Inventory.MAXCAPACITY;
    }
    public static int[] quantities() {
        return playerInventory.quantities();
    }
    public static String[] itemTypes() {
        return playerInventory.itemTypes();
    }
}
