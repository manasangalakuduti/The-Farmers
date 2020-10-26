package tests;

import javafx.embed.swing.JFXPanel;
import org.junit.Before;
import org.junit.Test;
import sample.frontend.Plot;

import static org.junit.Assert.assertEquals;


public class PlotTest {
    private Plot obj;

    @Before
    public void setup() {
        final JFXPanel fxPanel = new JFXPanel();
        obj = new Plot(1, 3, "Ham", "Immature");
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
        assertEquals(plot.getWaterStatus(), 2);
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
        assertEquals(plot.getWaterStatus(), 3);
    }

    @Test
    public void plotDies() {
        Plot plot = new Plot(1, 1, "Tomato", "Immature");
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

}