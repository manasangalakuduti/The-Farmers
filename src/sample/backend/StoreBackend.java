package sample.backend;

public class StoreBackend {
    private String name;
    public StoreBackend(String name) {
        this.name = name;
    }
    public double purchase(String item, int qty) {
        //calculate money that the player would
        //receive and whether a store has capacity at the moment.
        return -1;
    }
    public boolean sell(String item, int qty) {
        //add a bunch of nested if statements about player's capacity, balance,
        // and store's inventory, return true if all conditions are met
        // return false otherwise
        if (3 % 2 == 0) {
            return true;
        }
        return false;
    }
    public void restock() {
        //change out the contents of the inventory.
        System.out.println(name.toUpperCase() + " restocked with new items in inventory");
    }
}
