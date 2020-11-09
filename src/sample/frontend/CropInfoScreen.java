package sample.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.backend.Player;

//import java.util.HashSet;
//import java.util.Set;


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
        Button fStatus = new Button("Fertilizer applied: " + this.plot.isFertalized());
        Button pStatus = new Button("Locusticide applied: " + this.plot.isProtected());

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

        fStatus.setFont(new Font("Futura", 15));
        fStatus.setStyle("-fx-background-color: #219ebc; -fx-text-fill: black;"
                + "fx-border-radius: 20; -fx-background-radius: 10;");

        pStatus.setFont(new Font("Futura", 15));
        pStatus.setStyle("-fx-background-color: #219ebc; -fx-text-fill: black;"
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

        leftSide.getChildren().addAll(currentCrop, currentStatus,
                waterStatus, fStatus, pStatus, closeButton);
        bPane.setLeft(leftSide);

        VBox rightSide = new VBox();




        //Creates buttons to harvest, plant or water
        for (String type: Player.itemTypes()) {
            //if (!Player.getSpecialItemTypes().contains(type)) {
            //"SuperPower", "Locusticide", "Fertilizer"
            if (!type.equals("SuperPower") && !type.equals("Locusticide")
                && !type.equals("Fertilizer")) {
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

        //Fertalizer button
        Button fButton = new Button("Fertalize");
        fButton.setFont(new Font("Futura", 15));
        fButton.setStyle("-fx-background-color: #219ebc; -fx-text-fill: black;"
                + "fx-border-radius: 20; -fx-background-radius: 10;");
        fButton.setOnAction(e -> {
            if (!this.plot.getSeedStatus().equals("Dirt")) {
                if (Player.hasItem("Fertilizer")) {
                    if (!this.plot.isFertalized()) {
                        this.plot.setFertalized(true);
                        Player.updateInventory("Fertilizer", -1);
                        TransitionScene tScene = new TransitionScene();
                        Stage tStage = new Stage();
                        stage.close();
                        try {
                            tScene.start(tStage, "Fertilizer");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        stage.close();
                    } else {
                        fButton.setText("ALready fertalized!");
                    }
                }
            }
        });


        //Locust protext button
        Button lButton = new Button("Locustisize");
        lButton.setFont(new Font("Futura", 15));
        lButton.setStyle("-fx-background-color: #219ebc; -fx-text-fill: black;"
                + "fx-border-radius: 20; -fx-background-radius: 10;");
        lButton.setOnAction(e -> {
            if (!this.plot.getSeedStatus().equals("Dirt")) {
                if (Player.hasItem("Locusticide")) {
                    if (!this.plot.isProtected()) {
                        this.plot.setProtected(true);
                        Player.updateInventory("Locusticide", -1);
                        TransitionScene tScene = new TransitionScene();
                        Stage tStage = new Stage();
                        stage.close();
                        try {
                            tScene.start(tStage, "Locusticide");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        stage.close();
                    } else {
                        fButton.setText("ALready Locustesized!");
                    }
                }
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
        rightSide.getChildren().addAll(waterButton, harvestButton, fButton, lButton);
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
