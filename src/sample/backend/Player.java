package sample.backend;

public class Player {
    private double balance;
    private String name;
    public Player(String name, double balance) {
        this.balance = balance;
        this.name = name;
    }

    /**
     * In later iterations, this will not only modify the price,
     * but also add to inventory
     * @param price the cost of the object
     * @return whether purchase went through
     */
    public boolean purchaseObject(double price) {
        if (balance >= price) {
            balance -= price;
            return true;
        }
        System.out.println("Sorry, but you do not have the funds to make that purchase");
        return false;
    }
    public double getBalance() {
        return balance;
    }
    public String getName() {
        return name;
    }
}
