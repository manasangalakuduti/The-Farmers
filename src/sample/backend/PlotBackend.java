package sample.backend;

import sample.frontend.Plot;

import java.util.Map;

public class PlotBackend {
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
    public static Plot getPlots(int i, int j) {
        return plots[i][j];
    }
    public static void setPlots(int i, int j, Plot plot) {
        plots[i][j] = plot;
    }

    public static Map<String, String> getImageMap() {
        return imageMap;
    }
}
