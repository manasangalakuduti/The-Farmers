package sample.frontend;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.backend.Player;


public class TransitionScene extends Application {

    private Scene scene;


    @Override
    public void start(Stage stage) throws Exception {
        this.start(stage, "Watering");
    }
    public void start(Stage stage, String sceneType, String message) throws Exception {
        //Layout for Third Scene
        BorderPane bPane = new BorderPane();
        stage.setTitle(String.format("%s...", sceneType));
        scene = new Scene(bPane, 900, 600);
        if (sceneType.equals("Watering")) {
            bPane.setStyle("-fx-background-image: url(/sample/media/watering3.gif);"
                    + "-fx-background-size: 900px 600px;"
                    + "-fx-padding-top: 100%;");
            stage.setTitle("Watering the plants");
        } else if (sceneType.equals("NextDay")) {
            bPane.setStyle("-fx-background-image: url(/sample/media/nextDay.gif);"
                    + "-fx-background-size: 900px 600px;"
                    + "-fx-padding-top: 100%;");
            stage.setTitle("Sleeping");
        } else if (sceneType.equals("Harvest")) {
            bPane.setStyle("-fx-background-image: url(/sample/media/harvest.gif);"
                    + "-fx-background-size: 900px 600px;"
                    + "-fx-padding-top: 100%;");
            stage.setTitle("Harvesting the plants");
        } else if (sceneType.equals("Planting")) {
            bPane.setStyle("-fx-background-image: url(/sample/media/planting.gif);"
                    + "-fx-background-size: 900px 600px;"
                    + "-fx-padding-top: 100%;");
            stage.setTitle("Planting");
        } else if (sceneType.equals("Laser")) {
            bPane.setStyle("-fx-background-image: url(/sample/media/laser2.gif);"
                    + "-fx-background-size: 900px 600px;"
                    + "-fx-padding-top: 100%;");
            stage.setTitle("Powering up");
        } else {
            bPane.setStyle(String.format("-fx-background-image: url(/sample/media/%s.gif);", sceneType)
                    + "-fx-background-size: 900px 600px;"
                    + "-fx-padding-top: 100%;");
        }

        Button mBox = new Button(message);
        mBox.setFont(new Font("Futura", 15));
        mBox.setStyle("-fx-background-color: #9a8c98; -fx-text-fill: black;"
                + "fx-border-radius: 20; -fx-background-radius: 10;");
        bPane.setTop(mBox);
        bPane.setAlignment(mBox, Pos.CENTER);

        stage.setScene(scene);
        stage.show();
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> {
            stage.close();
        });
        pause.play();

    }


    public void start(Stage stage, String sceneType) throws Exception {
        //Layout for Third Scene
        BorderPane bPane = new BorderPane();
        stage.setTitle(String.format("%s...", sceneType));
        scene = new Scene(bPane, 900, 600);
        if (sceneType.equals("Watering")) {
            bPane.setStyle("-fx-background-image: url(/sample/media/watering3.gif);"
                    + "-fx-background-size: 900px 600px;"
                    + "-fx-padding-top: 100%;");
            stage.setTitle("Watering the plants");
        } else if (sceneType.equals("NextDay")) {
            bPane.setStyle("-fx-background-image: url(/sample/media/nextDay.gif);"
                    + "-fx-background-size: 900px 600px;"
                    + "-fx-padding-top: 100%;");
            stage.setTitle("Sleeping");
        } else if (sceneType.equals("Harvest")) {
            bPane.setStyle("-fx-background-image: url(/sample/media/harvest.gif);"
                    + "-fx-background-size: 900px 600px;"
                    + "-fx-padding-top: 100%;");
            stage.setTitle("Harvesting the plants");
        } else if (sceneType.equals("Planting")) {
            bPane.setStyle("-fx-background-image: url(/sample/media/planting.gif);"
                    + "-fx-background-size: 900px 600px;"
                    + "-fx-padding-top: 100%;");
            stage.setTitle("Planting");
        } else if (sceneType.equals("Laser")) {
            bPane.setStyle("-fx-background-image: url(/sample/media/laser2.gif);"
                    + "-fx-background-size: 900px 600px;"
                    + "-fx-padding-top: 100%;");
            stage.setTitle("Powering up");
        } else {
            bPane.setStyle(String.format("-fx-background-image: url(/sample/media/%s.gif);", sceneType)
                    + "-fx-background-size: 900px 600px;"
                    + "-fx-padding-top: 100%;");
        }
        stage.setScene(scene);
        stage.show();
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> {
            stage.close();
        });
        pause.play();

    }
}


