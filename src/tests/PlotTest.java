package tests;

import javafx.embed.swing.JFXPanel;
import org.junit.Before;
import org.junit.Test;
import sample.backend.PlotBackend;
import sample.frontend.FarmUIScreen;
import sample.frontend.Plot;

import static org.junit.Assert.assertEquals;


public class PlotTest {
    private Plot obj;

    @Before
    public void setup() {
        final JFXPanel fxPanel = new JFXPanel();
        obj = new Plot(1, 3, "Ham", "Immature");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                Plot plot = new Plot(i, j, "Tomato", "Immature");
                PlotBackend.setPlots(i,j, plot);
            }
        }
    }


    @Test
    public void testPlotName() {
        assertEquals("Ham", obj.getSeedType());
        obj.setSeedType("Tomato");
        assertEquals("Tomato", obj.getSeedType());
    }


    @Test
    public void testPlotLocations() {
        assertEquals(1, obj.getxIndex());
        assertEquals(3, obj.getyIndex());
        obj.setxIndex(4);
        obj.setyIndex(5);
        assertEquals(4, obj.getxIndex());
        assertEquals(5, obj.getyIndex());
    }


    @Test
    public void testWater() {
        Plot plot = new Plot(1, 1, "Tomato", "Immature");
        assertEquals(plot.getWaterStatus(), 3);
    }

    @Test
    public void testWateredToday() {
        Plot plot = new Plot(1, 1, "Tomato", "Immature");
        assertEquals(plot.getWateredToday(), false);
        plot.water();
        plot.setWateredToday(true);
        assertEquals(plot.getWateredToday(), true);
    }

    @Test
    public void plotNextDay() {
        Plot plot = new Plot(1, 1, "Tomato", "Immature");
        plot.water();
        plot.nextDay();
        assertEquals(plot.getWaterStatus(), 4);
    }

    @Test
    public void plotDies() {
        Plot plot = new Plot(1, 1, "Tomato", "Immature");
        plot.nextDay();
        plot.nextDay();
        plot.nextDay();
        assertEquals(plot.getSeedStatus(), "Dead");
    }

    @Test
    public void plotOverWater() {
        Plot plot = new Plot(1, 1, "Tomato", "Immature");
        plot.setWaterLevel(5);
        plot.water();
        plot.nextDay();
        assertEquals(plot.getSeedStatus(), "Dead");
    }



    @Test
    public void plotRain() {
        int prev = PlotBackend.getPlots(1, 1).getWaterStatus();
        PlotBackend.rain(0);
        assertEquals(PlotBackend.getPlots(1, 1).getWaterStatus(), prev + 1);
    }


    @Test
    public void plotRainDie() {
        for (int i = 0; i < 10; i++) {
            PlotBackend.rain(0);
        }
        PlotBackend.getPlots(1, 1).nextDay();
        assertEquals(PlotBackend.getPlots(1, 1).getSeedStatus(), "Dead");
    }

    @Test
    public void plotDrought() {
        int prev = PlotBackend.getPlots(1, 1).getWaterStatus();
        PlotBackend.drought(0);
        assertEquals(PlotBackend.getPlots(1, 1).getWaterStatus(), prev - 1);
    }

    @Test
    public void plotDroughtDie() {
        PlotBackend.drought(0);
        PlotBackend.drought(0);
        PlotBackend.getPlots(1, 1).nextDay();
        assertEquals(PlotBackend.getPlots(1, 1).getSeedStatus(), "Dead");
    }

    @Test
    public void plotLocust() {
        String result = PlotBackend.locust(0);
        assertEquals(result, "Locusts killed 0 plants!");
    }

}