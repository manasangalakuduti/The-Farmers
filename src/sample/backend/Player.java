package sample.backend;

public class Player {
    private static double balance;
    private static String name;
    //private Inventory playerInventory; //player inventory
    public static void initialize(String name, double balance) {
        Player.balance = balance;
        Player.name = name;
        //this.playerInventory = new Inventory();
    }

    /**
     * In later iterations, this will not only modify the price,
     * but also add to inventory
     * @param price the cost of the object
     * @return whether purchase went through
     */
    public static boolean purchaseObject(double price) {
        if (balance >= price) {
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
}
