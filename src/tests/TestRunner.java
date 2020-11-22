package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class TestRunner {
    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(ConfigScreenTest.class,
                FarmUITest.class, DateTest.class, PlotTest.class,
                InventoryTest.class, StoreBackendTest.class, MarketTest.class
                , PlayerTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
