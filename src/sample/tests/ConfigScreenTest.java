package sample.tests;

import org.junit.Before;
import org.junit.Test;
import sample.frontend.ConfigurationScreen;
import static org.junit.Assert.assertEquals;


public class ConfigScreenTest {

    private ConfigurationScreen obj;
    @Before
    public void setup() {
        obj = new ConfigurationScreen();
    }

    @Test
    public void validNameInputTest() {
        assertEquals("", obj.validateNameInput("Vali"));
    }

    @Test
    public void invalidNameInputTest() {
        assertEquals("Length of name cannot be zero.", obj.validateNameInput(""));
    }

    //test for difficulty setting, starting seed setting, starting season

    //make a test runner

}
