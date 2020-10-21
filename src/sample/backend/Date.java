package sample.backend;

public class Date {

    private static String season = "Fall";
    private static int date = 0;


    public static void nextDay() {
        date += 1;
    }

    public static String getSeason() {
        return season;
    }

    public static int getDate() {
        return date;
    }

    public static void setSeason(String startingSeason) {
        season = startingSeason;
    }
}
