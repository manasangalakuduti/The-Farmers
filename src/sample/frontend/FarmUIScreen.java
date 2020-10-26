package sample.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.backend.Date;
import sample.backend.Player;
import sample.backend.PlotBackend;
import java.util.Random;

public class FarmUIScreen extends Application {

    private Scene scene3;
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("FarmUI Screen");
        BorderPane bPane = new BorderPane();
        scene3 = new Scene(bPane, Main.X_WIDTH, Main.Y_WIDTH);
        bPane.setPadding(new Insets(10, 10, 10, 10));

        bPane.setStyle("-fx-background-color: LemonChiffon");
        bPane.setStyle("-fx-background-image: url(/sample/media/farm.png);"
                + "-fx-background-size: 900px 600px;"
                + "-fx-padding-top: 100%;");

        Button currentDate = this.getButton("Current day: " + Date.getDate(), "98c1d9");
        Button seasonLabel = this.getButton("Season: " + Date.getSeason(), "98c1d9");
        Button name = this.getButton("Player Name: " + Player.getName(), "98c1d9");
        Button returnButton = this.getButton("Return", "75c69d");
        Button moneys = this.getButton("Balance: $" + Math.round(Player.getBalance()), "75c69d");
        VBox leftSide = new VBox();
        leftSide.setSpacing(20);
        leftSide.getChildren().addAll(name, currentDate, seasonLabel, moneys);
        returnButton.setMinWidth(60);
        //Generates a popup for now, but should probably change later
        returnButton.setOnAction(e -> {
            Stage returnStage = new Stage();
            ConfigurationScreen c = new ConfigurationScreen();
            try {
                c.start(returnStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        Button storeButton = this.getButton("Store", "f884ad");
        storeButton.setMinWidth(60);
        //Generates a popup for now, but should probably change later
        storeButton.setOnAction(e -> {
            Stage storeStage = new Stage();
            StoreScene s = new StoreScene();
            try {
                s.start(storeStage);
                leftSide.getChildren().removeAll(moneys, currentDate, seasonLabel);
                moneys.setText("Balance: $" + Math.round(Player.getBalance()));
                currentDate.setText("Current day" + Date.getDate());
                seasonLabel.setText("Season: " + Date.getSeason());
                leftSide.getChildren().addAll(currentDate, seasonLabel, moneys);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Button inventoryButton = this.getButton("Inventory", "f884ad");
        inventoryButton.setMinWidth(80);
        inventoryButton.setOnAction(e -> {
            Stage storeStage = new Stage();
            InventoryScene s = new InventoryScene();
            try {
                s.start(storeStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        GridPane plotFrame = new GridPane();

        plotFrame.setHgap(30);
        plotFrame.setVgap(45);
        plotFrame.setAlignment(Pos.BOTTOM_CENTER);
        plotFrame.setPadding(new Insets(50, 50, 50, 50));

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {

                Random rand = new Random();
                int n = rand.nextInt(4);
                int m = rand.nextInt(3);
                String initialStatus;

                if (m == 0) {
                    initialStatus = "Seed";
                } else if (m == 1) {
                    initialStatus = "Immature";
                } else {
                    initialStatus = "Mature";
                }

                Plot newPlot = new Plot(i, j, Player.itemTypes()[n], initialStatus);
                PlotBackend.setPlots(j, i, newPlot);

                plotFrame.getChildren().addAll(newPlot);
                plotFrame.setRowIndex(newPlot, j);
                plotFrame.setColumnIndex(newPlot, i);
                newPlot.setMinHeight(30);
                newPlot.setMinWidth(60);
                newPlot.setMaxHeight(30);
                newPlot.setMaxWidth(60);

            }
        }

        Button nextDayButton = new Button("Next day");
        nextDayButton.setStyle("-fx-background-color: #f4a261; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;");
        nextDayButton.setOnAction(e -> {
            Date.nextDay();
            for (int i = 0; i < 15; i++) {
                int j = i / 5;
                int k = i % 5;
                PlotBackend.setPlots(j, k, (Plot) plotFrame.getChildren().get(i));
            }

            plotFrame.getChildren().clear();
            TransitionScene tScene = new TransitionScene();
            Stage tStage = new Stage();
            try {
                tScene.start(tStage, "NextDay");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 3; j++) {
                    Plot plot = PlotBackend.getPlots(j, i);
                    plot.nextDay();
                    plot.setPlotImage();
                    plot.setWateredToday(false);
                    plotFrame.getChildren().add(plot);
                }
            }
            bPane.setCenter(plotFrame);
            leftSide.getChildren().removeAll(currentDate, seasonLabel);
            currentDate.setText("Current day: " + Date.getDate());
            seasonLabel.setText("Season: " + Date.getSeason());
            leftSide.getChildren().addAll(currentDate, seasonLabel);
        });



        VBox rightSide = new VBox();
        rightSide.setSpacing(20);
        rightSide.setAlignment(Pos.TOP_RIGHT);
        rightSide.getChildren().addAll(nextDayButton, storeButton,
                inventoryButton, returnButton);

        bPane.setCenter(plotFrame);
        bPane.setLeft(leftSide);
        bPane.setRight(rightSide);

        stage.setScene(scene3);
        stage.show();
    }

    public Button getButton(String label, String color) {
        Button helperButton = new Button(label);
        helperButton.setStyle(String.format("-fx-background-color: #%s; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;", color));
        return helperButton;
    }


}