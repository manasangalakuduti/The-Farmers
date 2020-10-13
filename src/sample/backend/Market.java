package sample.backend;
import java.util.HashMap;

public class Market {


    private String[] items = {"Tomato", "Soybeans", "Corn", "Peas"};
    private HashMap<String, Double> itemPrice = new HashMap<String, Double>();
    private Date season;
    private String difficulty;

    public Market(Date season, String difficulty) {
        this.season = season;
        this.difficulty = difficulty;
        String[] items = {"Tomato", "Soybeans", "Corn", "Peas"};
        for (String item: items) {
            setPrice(item);
        }
    }

    private void setPrice(String item) {

        // Declaring the factor variables
        double basePrice;
        double seasonFactor;
        double difficultyFactor;

        // Setting the base price of each item
        switch (item) {
        case "Tomato":
        case "Soybeans":
        case "Corn":
        case "Peas":
            basePrice = 2.0;
            break;
        case "Trowel":
        case "Fertilizer":
            basePrice = 5.0;
            break;
        case "Tractor":
            basePrice = 10.0;
            break;
        default:
            basePrice = 7.5;
        }

        // Setting the seasonFactor based on the current season
        switch (season.getSeason()) {  // Need to use currSeas method
        case "Fall":
            seasonFactor = 1.5; // + Math.random(); // Gives # between 1.5 and 2.5
            break;
        case "Summer":
            seasonFactor = 1; // + Math.random();   // Gives # between 1.0 and 2.0
            break;
        case "Spring":
            seasonFactor = 0.5; // + Math.random(); // Gives # between 0.5 and 1.5
            break;
        default:
            seasonFactor = 0.1; // + Math.random(); // Gives # between 0.0 and 1.0
            break;
        }

        // Setting the difficultyFactor based on the difficulty selected in the Configuration Screen
        switch (difficulty) {
        case "Easy":
            difficultyFactor = 75.0;
            break;
        case "Medium":
            difficultyFactor = 25.0;
            break;
        case "Hard":
            difficultyFactor = 50.0;
            break;
        default:
            difficultyFactor = 20.0;
            break;
        }
        itemPrice.put(item, basePrice * seasonFactor * difficultyFactor);
    }

    // Returns subtotal of certain item for a certain quantity
    public double getPrice(String item, int quantity) {
        return itemPrice.get(item) * quantity;
    }

    //
    private String currSeason() {
        return "Fall"; // Work on Date class
    }

    // Returns the HashMap of all the items
    public HashMap<String, Double> getItemPrice() {
        return this.itemPrice;
    }
}