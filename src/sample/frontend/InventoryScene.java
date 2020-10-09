package sample.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.backend.Player;

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
                + "-fx-background-size: 950px 600px;"
                + "-fx-padding-top: 100%;");

        //Creating First Scene
        Scene scene = new Scene(grid, 950, 600);


        Label seedType0 = new Label(Player.itemTypes()[0] + ": "
                + (Player.getQuantityOf(Player.itemTypes()[0])));
        Label seedType1 = new Label(Player.itemTypes()[1]  + ": "
                + (Player.getQuantityOf(Player.itemTypes()[1])));
        Label seedType2 = new Label(Player.itemTypes()[4]  + ": "
                + (Player.getQuantityOf(Player.itemTypes()[4])));
        Label seedType3 = new Label(Player.itemTypes()[5]  + ": "
                + (Player.getQuantityOf(Player.itemTypes()[5])));
        seedType0.setFont(new Font("Futura", 13));
        seedType1.setFont(new Font("Futura", 13));
        seedType2.setFont(new Font("Futura", 13));
        seedType3.setFont(new Font("Futura", 13));
        seedType0.setStyle("-fx-text-fill: #663399;");
        seedType1.setStyle("-fx-text-fill: #663399;");
        seedType2.setStyle("-fx-text-fill: #663399;");
        seedType3.setStyle("-fx-text-fill: #663399;");

        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(seedType0, seedType1, seedType2, seedType3);

        grid.setRowIndex(seedType0, 40);
        grid.setColumnIndex(seedType0, 21);

        grid.setRowIndex(seedType1, 30);
        grid.setColumnIndex(seedType1, 21);

        grid.setRowIndex(seedType2, 25);
        grid.setColumnIndex(seedType2, 21);

        grid.setRowIndex(seedType3, 35);
        grid.setColumnIndex(seedType3, 21);
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
        grid.getChildren().addAll(returnButton, seedType0, seedType1,
                seedType2, seedType3);
        storeStage.setScene(scene);
        storeStage.show();
    }
}
