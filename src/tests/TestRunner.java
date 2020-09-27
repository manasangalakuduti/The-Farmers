package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
<<<<<<< HEAD:src/tests/TestRunner.java
//import java.util.List;
=======

>>>>>>> fc21630169924f3463fa51a8ac4370f001c023ee:tests/TestRunner.java

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
