package sample.frontend;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class TransitionScene extends Application {

    private Scene scene;


    @Override
    public void start(Stage stage) throws Exception {
        this.start(stage, "Watering");
    }

    public void start(Stage stage, String sceneType) throws Exception {
        //Layout for Third Scene
        BorderPane bPane = new BorderPane();
        stage.setTitle("Watering the plants...");
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
        }
        stage.setScene(scene);
        stage.show();
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(e -> {
            stage.close();
        });
        pause.play();

    }
}


