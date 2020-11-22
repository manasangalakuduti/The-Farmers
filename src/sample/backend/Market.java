package sample.backend;
//import java.text.DecimalFormat;
import java.util.HashMap;
//import java.util.Random;

public class Market {


    //private String[] items = {"Tomato", "Soybeans", "Corn", "Peas", "SuperPower"};
    private HashMap<String, Double> itemPrice = new HashMap<String, Double>();
    private String season;
    private String difficulty;

    public Market(String difficulty) {
        this.season = Date.getSeason();
        this.difficulty = difficulty;
        String[] items =
            {"Tomato", "Soybeans", "Corn", "Peas", "SuperPower",
                "Locusticide", "Fertilizer", "Tractor", "Irrigation"};
        for (String item: items) {
            setPrice(item);
        }
    }

    public void setPrice(String item) {

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
            basePrice = 1.2;
            break;
        case "Fertilizer":
        case "Locusticide":
            basePrice = 4.0;
            break;
        case "Irrigation":
            basePrice = 5.2;
            break;
        case "Tractor":
            basePrice = 6.2;
            break;
        case "SuperPower":
            basePrice = 10.0;
            break;
        default:
            basePrice = 7.5;
        }

        // Setting the seasonFactor based on the current season
        switch (season) {  // Need to use currSeas method
        case "Fall":
            seasonFactor = 1.5 + Math.random(); // Gives # between 1.5 and 2.5
            break;
        case "Summer":
            seasonFactor = 1 + Math.random();   // Gives # between 1.0 and 2.0
            break;
        case "Spring":
            seasonFactor = 0.5 + Math.random(); // Gives # between 0.5 and 1.5
            break;
        default:
            seasonFactor = Math.random() + 0.1; // Gives # between 0.1 and 1.1
            break;
        }

        // Setting the difficultyFactor based on the difficulty selected in the Configuration Screen
        switch (this.difficulty) {
        case "Easy":
            difficultyFactor = 12.5;
            break;
        case "Medium":
            difficultyFactor = 10.0;
            break;
        case "Hard":
            difficultyFactor = 7.5;
            break;
        default:
            difficultyFactor = 3.0;
            break;
        }
        double finalPrice = basePrice * seasonFactor * difficultyFactor;
        itemPrice.put(item, Math.ceil(finalPrice));
    }

    // Returns subtotal of certain item for a certain quantity
    public double getPrice(String item, int quantity) {
        return itemPrice.get(item) * quantity;
    }

    //
    private String currSeason() {
        return Date.getSeason(); // Work on Date class
    }

    // Returns the HashMap of all the items
    public HashMap<String, Double> getItemPrice() {
        return this.itemPrice;
    }
}