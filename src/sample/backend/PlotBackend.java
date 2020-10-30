package sample.backend;

import sample.frontend.Plot;

import java.util.Map;


public class PlotBackend {
    public static String difficulty;
    private static Plot[][] plots = new Plot[3][5];
    private static Map<String, String> imageMap = Map.of("Dirt", "sample/media/dirt.png",
            "Seed", "sample/media/seed.png",
            "Tomato", "sample/media/tomato.jpg",
            "Peas", "sample/media/peas.png",
            "Soybeans", "sample/media/beans.png",
            "Corn", "sample/media/corn.png",
            "Plant", "sample/media/plant.jpg",
            "Dead", "sample/media/deadPlant.png"
    );

    public static void setDifficulty(String diff) {
        PlotBackend.difficulty = diff;
    }


    public static void naturalEvent() {
        double num = Math.random(); //number between [0,1)
        //event 1 - Locusts
        switch (difficulty) {
            case "easy" :
                plots[0][0].setSeedStatus("Dead");
                plots[0][0].setPlotImage();
                break;
            case "medium":
                plots[0][1].setSeedStatus("Dead");
                plots[0][0].setPlotImage();
                break;
            case "hard":
                plots[0][2].setSeedStatus("Dead");
                plots[0][0].setPlotImage();
                break;
            case "master":
                plots[0][3].setSeedStatus("Dead");
                plots[0][0].setPlotImage();
                break;
            default:
                break;
        }
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
