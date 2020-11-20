package sample.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WinScreen extends Application {

    public static final int X_WIDTH = 900;
    public static final int Y_WIDTH = 600;

    @Override
    public void start(Stage stage) throws Exception {
        //First Scene - Layout
        stage.setTitle("You Win!");

        //Setting up GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        Stage s = new Stage();
        Scene scene = new Scene(grid, X_WIDTH, Y_WIDTH);
        stage.setScene(scene);
        stage.show();








    }
}
