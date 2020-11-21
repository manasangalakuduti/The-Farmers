package sample.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.backend.Date;
import sample.backend.PlotBackend;

public class EndScreen extends Application {

    public static final int X_WIDTH = 900;
    public static final int Y_WIDTH = 600;

    @Override
    public void start(Stage stage) throws Exception {

        //First Scene - Layout
        stage.setTitle("You Lost!");

        //Setting up GridPane
        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(10, 10, 10, 10));


        bPane.setStyle("-fx-background-image: url(/sample/media/losing.gif);"
                + "-fx-background-size: 900px 600px;"
                + "-fx-padding-top: 100%;");
        stage.setTitle("Loser!");


        Button moneys = new Button("You lost :(");
        moneys.setStyle(String.format("-fx-background-color: #%s; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;", "B53737"));
        bPane.setCenter(moneys);



        Button resetButton = new Button("New game");
        resetButton.setStyle(String.format("-fx-background-color: #%s; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;", "B53737"));
        resetButton.setOnAction(e -> {
            Stage returnStage = new Stage();
            ConfigurationScreen c = new ConfigurationScreen();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    PlotBackend.setNewPlot(i, j);
                }
            }
            Date.resetDate();
            try {
                c.start(returnStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        bPane.setBottom(resetButton);



        Scene scene = new Scene(bPane, X_WIDTH, Y_WIDTH);
        stage.setScene(scene);
        stage.show();


    }
}
