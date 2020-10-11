package tests;

import javafx.embed.swing.JFXPanel;
import org.junit.Before;
import org.junit.Test;
import sample.backend.Player;
import sample.frontend.Plot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class PlotTest {
    private Plot obj;

    @Before
    public void setup() {
        final JFXPanel fxPanel = new JFXPanel();
        //FarmUIScreen f = new FarmUIScreen(new Player("testPlayer", 100), "TestSeson");
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
    public void testPlotPaths() {
        for (String item: Player.itemTypes()) {
            Plot p = new Plot(1, 1, item, "Mature");
            p.setPlotImage("Mature", item);
            assertNotNull(p.getBackground());
        }
    }
}