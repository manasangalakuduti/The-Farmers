package sample.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.backend.Player;


public class CropInfoScreen extends Application {
    private Plot plot;
    public CropInfoScreen(Plot plot) {
        this.plot = plot;
    }


    @Override
    public void start(Stage stage) throws Exception {

        BorderPane bPane = new BorderPane();

        //Show current crop info
        Label currentCrop = new Label(this.plot.getSeedType());
        Label currentStatus = new Label(this.plot.getSeedStatus());


        Label name = new Label("Player Name: " + Player.getName());
        name.setFont(new Font("Futura", 20));


        VBox topSide = new VBox();
        topSide.setSpacing(20);
        topSide.getChildren().addAll(currentCrop, currentStatus);

        bPane.setTop(topSide);

        VBox rightSide = new VBox();
        //Creates buttons to harvest, plant or water
        for (String type: Player.itemTypes()) {
            String displayText = String.format("Plant %s", type);
            Button plantButton = new Button(displayText);
            plantButton.setOnAction(e -> {
                if (this.plot.getSeedStatus().equals("Dirt")) {
                    if (Player.hasItem(type)) {
                        this.plot.plant(type);
                        Player.updateInventory(type, -1);
                        stage.close();
                    }
                }
            });
            rightSide.getChildren().addAll(plantButton);
        }

        //Creates water button




        Button harvestButton = new Button("Harvest");
        harvestButton.setStyle("-fx-background-color: DeepSkyBlue; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;");
        harvestButton.setOnAction(e -> {
            if (this.plot.getSeedStatus().equals("Mature")) {
                if (Player.hasRoom(1)){
                    Player.updateInventory(this.plot.getSeedType(), 3);
                    this.plot.clear();
                    stage.close();
                }
            }
        });


        rightSide.getChildren().addAll(harvestButton);
        bPane.setRight(rightSide);



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



        Scene scene = new Scene(bPane, Main.X_WIDTH, Main.Y_WIDTH);
        stage.setScene(scene);
        stage.showAndWait();






    }
}
