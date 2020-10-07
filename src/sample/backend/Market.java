package sample.backend;
import sample.backend.Date;
import sample.frontend.ConfigurationScreen;

import java.util.HashMap;
import java.util.Map;

public class Market {

    private static String[] items = {"Tomato", "Soybeans", "Tractor", "Trowel", "Corn", "Peas", "Fertilizer"};
    private static HashMap<String, Double> itemPrice = new HashMap<String, Double>();
    private static double weatherFactor;
    private static double difficultyFactor;
    private static double itemFactor;
    private Date season;
    private ConfigurationScreen difficulty;

    public static void main(String[] args) {
        System.out.println(itemPrice);
    }
    public Market() {
        setWeatherFactor();
        setDifficultyFactor();
        createHashMap();
    }
    public void setWeatherFactor() {
        String seas = season.getSeason();
        switch (seas) {
            case "Fall":
                weatherFactor = 1.5 + Math.random(); // Gives # between 1.5 and 2.5
                break;
            case "Summer":
                weatherFactor = 1 + Math.random();   // Gives # between 1.0 and 2.0
                break;
            case "Spring":
                weatherFactor = 0.5 + Math.random(); // Gives # between 0.5 and 1.5
                break;
            default:
                weatherFactor = Math.random();       // Gives # between 0.0 and 1.0
                break;
        }
    }

    public void setDifficultyFactor() {
        //String diff = difficulty.getValue();  //Need help on how to retrieve this data
        String diff = "Easy"; //Temporary Value
        switch (diff) {
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
    }

    // Assigns each item in the market to a certain category to help identify the price
    public static void setItemFactor(String item) {
        switch (item) {
            case "Tomato":
            case "Soybeans":
            case "Corn":
            case "Peas":
                itemFactor = 2.0;
                break;
            case "Trowel":
            case "Fertilizer":
                itemFactor = 5.0;
            case "Tractor":
                itemFactor = 10.0;
            default:
                itemFactor = 7.5;
        }
    }

    public static void createHashMap() {
        for (String item: items) {
            itemPrice.put(item, setPrice(item));
        }
    }

    public static double setPrice(String item) {
        setItemFactor(item);
        double priceOfItem = weatherFactor * difficultyFactor * itemFactor;
        return priceOfItem;
    }
    public static double getPrice(String item) {
        return itemPrice.get(item);
    }

}
