package sample.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.backend.*;

public class InventoryScene extends Application {

    @Override
    public void start(Stage storeStage) throws Exception {

        //First Scene - Layout
        storeStage.setTitle("Inventory");

        //Setting up GridPane
        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(10, 10, 10, 10));

        bPane.setStyle("-fx-background-image: url(/sample/media/inventory.png);"
                + "-fx-background-size: 950px 600px;"
                + "-fx-padding-top: 100%;");

        //Creating First Scene
        VBox leftSide = new VBox();

        Scene scene = new Scene(bPane, 950, 600);

        for (String seed: Player.itemTypes()) {
            Label label = new Label(seed + " : " +  Player.getQuantityOf(seed));
            label.setFont(new Font("Futura", 13));
            label.setStyle("-fx-text-fill: #663399;");
            leftSide.getChildren().add(label);
        }
        bPane.setCenter(leftSide);
        bPane.setAlignment(leftSide, Pos.CENTER);
        bPane.setPadding(new Insets(20));




        //Return Button
        Button returnButton = new Button("Close");
        returnButton.setStyle("-fx-background-color: DeepSkyBlue; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;");


        //Generates a popup for now, but should probably change later
        returnButton.setOnAction(e -> {
            try {
                storeStage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        bPane.setRight(returnButton);
        storeStage.setScene(scene);
        storeStage.show();
    }
}
