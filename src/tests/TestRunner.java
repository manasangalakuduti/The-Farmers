package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
//import java.util.List;

public class TestRunner {
    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(ConfigScreenTest.class,
                FarmUITest.class, DateTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
