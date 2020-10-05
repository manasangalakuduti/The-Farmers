package sample.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class CropInfoScreen extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane bPane = new BorderPane();
        Button closeButton = new Button("Close");
        closeButton.setStyle("-fx-background-color: DeepSkyBlue; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;");
        closeButton.setOnAction(e -> {
            try {
                stage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        bPane.setLeft(closeButton);
        bPane.setStyle("-fx-background-image: url(/sample/media/cropInfoBk.png);"
                + "-fx-background-size: 900px 600px;"
                + "-fx-padding-top: 100%;");
        bPane.setPadding(new Insets(20, 20, 20, 20));

        Rectangle title = new Rectangle();
        //title.setAccessibleText(player.getName());
        //bPane.setTop(title);



        Scene scene = new Scene(bPane, Main.X_WIDTH / 2, Main.Y_WIDTH / 2);
        stage.setScene(scene);
        stage.showAndWait();



    }
}
