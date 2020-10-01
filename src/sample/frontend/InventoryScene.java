package sample.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InventoryScene extends Application {

    @Override
    public void start(Stage storeStage) throws Exception {

        //First Scene - Layout
        storeStage.setTitle("Inventory");

        //Setting up GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setStyle("-fx-background-image: url(/sample/media/inventory.png);"
                + "-fx-background-size: 900px 600px;"
                + "-fx-padding-top: 100%;");

        //Creating First Scene
        Scene scene = new Scene(grid, 900, 600);


        //Return Button
        Button returnButton = new Button("Close");
        returnButton.setStyle("-fx-background-color: DeepSkyBlue; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;");
        grid.setRowIndex(returnButton, 0);
        grid.setColumnIndex(returnButton, 80);
        returnButton.setMinWidth(60);
        //Generates a popup for now, but should probably change later
        returnButton.setOnAction(e -> {
            try {
                storeStage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        grid.getChildren().addAll(returnButton);
        storeStage.setScene(scene);
        storeStage.show();
    }
}
