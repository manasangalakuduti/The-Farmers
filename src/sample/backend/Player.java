package sample.backend;

public class Player {
    private static double balance;
    private static String name;
    private static Inventory playerInventory; //player inventory
    private static int limHarvestTractor = 6;
    private static int limHarvest = 2;
    private static int limWater = 5;
    private static int limWaterIrrigate = 10;
    private static int currWater = limWater;
    private static int currHarvest = limHarvest;

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

    public static String[] getSpecialItemTypes() {
        return playerInventory.getSpecialItemTypes();
    }

    //Harvest and Water related functions
    public static int getCurrWater() {
        return currWater;
    }
    public static int getCurrHarvest() {
        return currHarvest;
    }
    public static void water() {
        if (currWater == 0) {
            return;
        }
        currWater--;
    }
    public static void harvest() {
        if (currHarvest == 0) {
            return;
        }
        currHarvest--;
    }
    public static void resetWaterHarvest() {
        if (playerInventory.hasItem("Irrigation")) {
            currWater = limWaterIrrigate;
        } else {
            currWater = limWater;
        }
        if (playerInventory.hasItem("Tractor")) {
            currHarvest = limHarvestTractor;
        } else {
            currHarvest = limHarvest;
        }
    }
}
