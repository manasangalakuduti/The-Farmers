package sample.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
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
        Button currentCrop = new Button(this.plot.getSeedType());
        Button currentStatus = new Button(this.plot.getSeedStatus());
        Button name = new Button("Player Name: " + Player.getName());
        Button waterStatus = new Button("Water status: " + this.plot.getWaterStatus());

        currentCrop.setFont(new Font("Futura", 15));
        currentCrop.setStyle("-fx-background-color: #98c1d9; -fx-text-fill: black;"
                + "fx-border-radius: 20; -fx-background-radius: 10;");
        currentStatus.setFont(new Font("Futura", 15));
        currentStatus.setStyle("-fx-background-color: #98c1d9; -fx-text-fill: black;"
                + "fx-border-radius: 20; -fx-background-radius: 10;");
        name.setFont(new Font("Futura", 15));
        name.setStyle("-fx-background-color: #98c1d9; -fx-text-fill: black;"
                + "fx-border-radius: 20; -fx-background-radius: 10;");
        waterStatus.setFont(new Font("Futura", 15));
        waterStatus.setStyle("-fx-background-color: #219ebc; -fx-text-fill: black;"
                + "fx-border-radius: 20; -fx-background-radius: 10;");

        Button closeButton = new Button("Close");
        closeButton.setStyle("-fx-background-color: #f4a261; -fx-text-fill: black;"
                + "fx-border-radius: 20; -fx-background-radius: 10;");
        closeButton.setOnAction(e -> {
            try {
                stage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        name.setFont(new Font("Futura", 20));
        VBox leftSide = new VBox();
        leftSide.setSpacing(20);

        leftSide.getChildren().addAll(currentCrop, currentStatus, waterStatus, closeButton);
        bPane.setLeft(leftSide);

        VBox rightSide = new VBox();




        //Creates buttons to harvest, plant or water
        for (String type: Player.itemTypes()) {
            if (!type.equals("SuperPower")) {
                String displayText = String.format("Plant %s (%d in bag)", type,
                        Player.getQuantityOf(type));
                Button plantButton = new Button(displayText);
                plantButton.setFont(new Font("Futura", 15));
                plantButton.setStyle("-fx-background-color: #f4a261; -fx-text-fill: black;"
                        + "fx-border-radius: 20; -fx-background-radius: 10;");


                plantButton.setOnAction(e -> {
                    if (this.plot.getSeedStatus().equals("Dirt")) {
                        if (Player.hasItem(type)) {
                            this.plot.plant(type);
                            Player.updateInventory(type, -1);
                            TransitionScene tScene = new TransitionScene();
                            Stage tStage = new Stage();
                            stage.close();
                            try {
                                tScene.start(tStage, "Planting");
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            stage.close();
                        }
                    }
                });
                rightSide.getChildren().addAll(plantButton);
            }
        }

        //Creates water button

        Button waterButton = new Button("Water");
        waterButton.setFont(new Font("Futura", 15));
        waterButton.setStyle("-fx-background-color: #219ebc; -fx-text-fill: black;"
                + "fx-border-radius: 20; -fx-background-radius: 10;");
        waterButton.setOnAction(e -> {
            if (!this.plot.getWateredToday()) {
                this.plot.water();
                this.plot.setWateredToday(true);
                TransitionScene tScene = new TransitionScene();
                Stage tStage = new Stage();
                stage.close();
                try {
                    tScene.start(tStage, "Watering");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                waterButton.setText("Already watered today!");
            }
        });

        Button harvestButton = new Button("Harvest");
        harvestButton.setFont(new Font("Futura", 15));
        harvestButton.setStyle("-fx-background-color: #2a9d8f; -fx-text-fill: black;"
                + "fx-border-radius: 20; -fx-background-radius: 10;");
        harvestButton.setOnAction(e -> {
            if (this.plot.getSeedStatus().equals("Mature")) {
                if (Player.hasRoom(1)) {
                    Player.updateInventory(this.plot.getSeedType(), this.plot.getHarvestQuantity());
                    this.plot.clear();
                    TransitionScene tScene = new TransitionScene();
                    Stage tStage = new Stage();
                    stage.close();
                    try {
                        tScene.start(tStage, "Harvest");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    stage.close();
                }
            } else if (this.plot.getSeedStatus().equals("Dead")) {
                this.plot.clear();
                stage.close();
            }
        });

        rightSide.setSpacing(10);
        rightSide.getChildren().addAll(waterButton, harvestButton);
        bPane.setRight(rightSide);



        bPane.setStyle("-fx-background-image: url(/sample/media/cropInfoBk.png);"
                + "-fx-background-size: 900px 600px;"
                + "-fx-padding-top: 100%;");
        bPane.setPadding(new Insets(20, 20, 20, 20));


        Scene scene = new Scene(bPane, Main.X_WIDTH, Main.Y_WIDTH);
        stage.setScene(scene);
        stage.showAndWait();


    }


}
