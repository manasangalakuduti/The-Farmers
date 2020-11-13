package sample.backend;

import javafx.stage.Stage;
import sample.frontend.FarmUIScreen;
import sample.frontend.Plot;
import sample.frontend.TransitionScene;

import java.util.Map;
import java.util.Random;


public class PlotBackend {
    private static String difficulty;
    private static Plot[][] plots = new Plot[3][5];
    private static double[] eventProbs = {0.1, 0.2, 0.3, 0.7};
    private static double[] initProbs = {0.1, 0.2, 0.3, 0.7};
    private static Map<String, String> imageMap = Map.of("Dirt", "sample/media/dirt.png",
            "Seed", "sample/media/seed.png",
            "Tomato", "sample/media/tomato.jpg",
            "Peas", "sample/media/peas.png",
            "Soybeans", "sample/media/beans.png",
            "Corn", "sample/media/corn.png",
            "Plant", "sample/media/plant.jpg",
            "Dead", "sample/media/deadPlant.png",
            "Empty", "sample/media/Empty.jpg"

    );
    private static int purchasedPlots = 0;
    private static FarmUIScreen fScreen;

    public static void setDifficulty(String diff) {
        PlotBackend.difficulty = diff;
    }

    public static String locust(int diff) {
        System.out.println("LOCUSTS!");
        int trueKills = 0;
        int killCount = 0;
        int numRounds = 0;
        while (killCount < diff && numRounds < diff) {
            for (int i = 0; i < plots.length; i++) {
                for (int j = 0; j < plots[i].length; j++) {
                    double chance = Math.random();
                    if (chance < 0.5 && !(plots[i][j].getSeedStatus()).equals("Dirt")
                            && !(plots[i][j].getSeedStatus()).equals("Dead")) {
                        //protect the plant and still add to total if protected
                        if (!(plots[i][j].isProtected())) {
                            plots[i][j].setSeedStatus("Dead");
                            trueKills++;
                        }
                        killCount++;
                        if (killCount >= diff) {
                            break;
                        }
                    }
                }
                numRounds++; //ensures it doesn't go on to infinity
            }
        }
        return String.format("Locusts killed %d plants!", trueKills);
    }

    public static String drought(int diff) {
        int amount = (int) (1 + Math.random() * diff);
        System.out.println("We are in a drought! Water level dropped by " + amount + " levels");
        for (int i = 0; i < plots.length; i++) {
            for (int j = 0; j < plots[i].length; j++) {
                plots[i][j].setWaterLevel(Math.max(0, plots[i][j].getWaterStatus() - amount));
            }
        }
        return String.format("Drought- water levels dropped by %d!! ", amount);
    }
    public static String rain(int diff) {
        int amount = (int) (1 + Math.random() * diff);
        System.out.println("A rainstorm passed by! Water level rose by " + amount + " levels");
        for (int i = 0; i < plots.length; i++) {
            for (int j = 0; j < plots[i].length; j++) {
                plots[i][j].setWaterLevel(plots[i][j].getWaterStatus() + amount);
            }
        }
        return String.format("Rain- water levels increased by %d!! ", amount);
    }

    public static void naturalEvent() {
        double num = Math.random(); //number between [0,1)
        int diffint;
        switch (difficulty) {
        case "Easy" :
            diffint = 1;
            break;
        case "Medium":
            diffint = 2;
            break;
        case "Hard":
            diffint = 3;
            break;
        case "Master":
            diffint = 4;
            break;
        default:
            diffint = 0;
            break;
        } //set the difficulty level input in above switch statement


        String eventRan = null;
        //decide which event to
        String mText = null;
        if (num < PlotBackend.eventProbs[0]) {
            eventRan = "locust";
            mText = locust(diffint);
            PlotBackend.eventProbs = PlotBackend.initProbs.clone();
        } else if (num >= PlotBackend.eventProbs[0] && num < PlotBackend.eventProbs[1]) {
            eventRan = "drought";
            mText = drought(diffint);
            PlotBackend.eventProbs = PlotBackend.initProbs.clone();
        } else if (num >= PlotBackend.eventProbs[1] && num < PlotBackend.eventProbs[2]) {
            eventRan = "rain";
            mText = rain(diffint);
            PlotBackend.eventProbs = PlotBackend.initProbs.clone();
        } else {
            System.out.println("No events today!");
            if (PlotBackend.eventProbs[3] >= 0.15) { //if no events, increase chance
                PlotBackend.eventProbs[3] -= 0.15;
                for (int i = 0; i < 3; i++) {
                    PlotBackend.eventProbs[i] += (i + 1) * 0.05;
                }
            }
            eventRan = "NextDay";
        }
        if (eventRan != null) {
            TransitionScene tScene = new TransitionScene();
            Stage tStage = new Stage();
            try {
                if (mText != null) {
                    tScene.start(tStage, eventRan, mText);
                    System.out.println("Working");
                } else {
                    tScene.start(tStage, eventRan);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static int getPurchasedPlots() {
        int count = 0;
        for (int i = 0; i < plots.length; i++) {
            for (int j = 0; j < plots[i].length; j++) {
                if (plots[i][j].isPurchased()) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void setNewPlot(int i, int j) {
        Random rand = new Random();
        int n = rand.nextInt(4);
        int m = rand.nextInt(3);
        String initialStatus;
        if (m == 0) {
            initialStatus = "Seed";
        } else if (m == 1) {
            initialStatus = "Immature";
        } else {
            initialStatus = "Mature";
        }
        Plot newPlot = new Plot(i, j, Player.itemTypes()[n], initialStatus);
        plots[i][j] = newPlot;

    }


    public static int getPlotPrice() {
        return 80 * getPurchasedPlots();
    }

    public static void setFarmScreen(FarmUIScreen fScreenSet) {
        fScreen = fScreenSet;
    }

    public static FarmUIScreen getFarmScreen() {
        return fScreen;
    }

    public static Plot getPlots(int i, int j) {
        return plots[i][j];
    }
    public static void setPlots(int i, int j, Plot plot) {
        plots[i][j] = plot;
    }

    //1. Get random event chance (~10-15 lines)
    //2. Loop through
    //3. Set appropraite status on plot[i][j]
    //4. Set transition scene
    //5. $$$ Cash out $$$

    public static Map<String, String> getImageMap() {
        return imageMap;
    }
}