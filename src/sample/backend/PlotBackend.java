package sample.backend;

import sample.frontend.Plot;

import java.util.Map;

public class PlotBackend {
    public static Plot[][] plots = new Plot[3][5];
    public static Map<String, String> imageMap = Map.of("Dirt", "sample/media/dirt.png",
            "Seed", "sample/media/seed.png",
            "Tomato", "sample/media/tomato.jpg",
            "Peas", "sample/media/peas.png",
            "Soybeans", "sample/media/beans.png",
            "Corn", "sample/media/corn.png",
            "Plant", "sample/media/plant.jpg",
            "Dead", "sample/media/deadPlant.png"
    );
}
