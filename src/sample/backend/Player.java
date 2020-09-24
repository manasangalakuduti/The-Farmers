package sample.backend;

public class Player {
    private double balance;
    private String name;
    public Player(String name, double balance){
        this.balance = balance;
        this.name = name;
    }
    public boolean purchaseObject(double price){
        if (balance >= price) {
            balance -= price;
            return true;
        }
        System.out.println("Sorry, but you do not have the funds to make that purchase");
        return false;
    }
}
