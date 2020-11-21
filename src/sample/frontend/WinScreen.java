package sample.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.backend.Player;

public class WinScreen extends Application {

    public static final int X_WIDTH = 900;
    public static final int Y_WIDTH = 600;

    @Override
    public void start(Stage stage) throws Exception {

        //First Scene - Layout
        stage.setTitle("You Win!");

        //Setting up GridPane
        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(10, 10, 10, 10));


        bPane.setStyle("-fx-background-image: url(/sample/media/farm.png);"
                + "-fx-background-size: 900px 600px;"
                + "-fx-padding-top: 100%;");
        Button moneys = new Button("You won!!!!!");
        moneys.setStyle(String.format("-fx-background-color: #%s; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;", "75c69d"));
        bPane.setCenter(moneys);




        Scene scene = new Scene(bPane, X_WIDTH, Y_WIDTH);
        stage.setScene(scene);
        stage.show();








    }
}
