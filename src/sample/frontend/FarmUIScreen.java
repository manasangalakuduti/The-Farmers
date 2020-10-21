package sample.frontend;

import javafx.animation.Transition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.backend.Date;
import sample.backend.Player;
import sample.backend.PlotBackend;

import java.time.LocalDateTime;
import java.util.Random;


public class FarmUIScreen extends Application {
    //private Player player;
    private Date date;
    public FarmUIScreen() {

    }

    private Scene scene3;
    @Override
    public void start(Stage stage) throws Exception {

        //Layout for Third Scene
        StackPane root = new StackPane();
        stage.setTitle("FarmUI Screen");
        BorderPane bPane = new BorderPane();
        scene3 = new Scene(bPane, Main.X_WIDTH, Main.Y_WIDTH);
        bPane.setPadding(new Insets(10, 10, 10, 10));


        bPane.setStyle("-fx-background-color: LemonChiffon");
        bPane.setStyle("-fx-background-image: url(/sample/media/farm.png);"
                + "-fx-background-size: 900px 600px;"
                + "-fx-padding-top: 100%;");


        //Return Button
        Button returnButton = new Button("Return");
        returnButton.setStyle("-fx-background-color: #98c1d9; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;");


        Button name = new Button("Player Name: " + Player.getName());
        name.setFont(new Font("Futura", 15));
        name.setStyle("-fx-background-color: #98c1d9; -fx-text-fill: black;"
                + "fx-border-radius: 20; -fx-background-radius: 10;");

        Button currentDate = new Button("Current day: " + Date.getDate());
        currentDate.setFont(new Font("Futura", 15));
        currentDate.setStyle("-fx-background-color: #98c1d9; -fx-text-fill: black;"
                + "fx-border-radius: 20; -fx-background-radius: 10;");

        Button seasonLabel = new Button("Season: " + Date.getSeason());
        seasonLabel.setFont(new Font("Futura", 15));
        seasonLabel.setStyle("-fx-background-color: #98c1d9; -fx-text-fill: black;"
                + "fx-border-radius: 20; -fx-background-radius: 10;");

        Button moneys = new Button("Balance: $" + Math.round(Player.getBalance()));
        moneys.setFont(new Font("Futura", 15));
        moneys.setStyle("-fx-background-color: #75c69d; -fx-text-fill: black;"
                + "fx-border-radius: 20; -fx-background-radius: 10;");

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
                //stage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });



        //Store Button
        Button storeButton = new Button("Store");
        storeButton.setStyle("-fx-background-color: #f884ad; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;");
        storeButton.setFont(new Font("Futura", 15));

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

        //Inventory Button
        Button inventoryButton = new Button("Inventory");
        inventoryButton.setStyle("-fx-background-color: #f884ad; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;");
        inventoryButton.setFont(new Font("Futura", 15));

        inventoryButton.setMinWidth(80);
        //Generates a popup for now, but should probably change later
        inventoryButton.setOnAction(e -> {
            Stage storeStage = new Stage();
            InventoryScene s = new InventoryScene();
            try {
                s.start(storeStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        //Creates a new pane with tiles, for plotting purposes
        GridPane plotFrame = new GridPane();

        plotFrame.setHgap(30);
        plotFrame.setVgap(45);
        plotFrame.setAlignment(Pos.BOTTOM_CENTER);
        plotFrame.setPadding(new Insets(50, 50, 50, 50));

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {

                Random rand = new Random();
                int n = rand.nextInt(4);

                Random rand2 = new Random();
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
                PlotBackend.plots[j][i] = newPlot;

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
                PlotBackend.plots[j][k] = (Plot) plotFrame.getChildren().get(i);
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
                    Plot plot = PlotBackend.plots[j][i];
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
            leftSide.getChildren().addAll( currentDate, seasonLabel);
        });

        Button superpowerButton = new Button("SuperPower");
        superpowerButton.setStyle("-fx-background-color: #f4a261; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;");
        superpowerButton.setOnAction(e -> {
            if (Player.hasItem("SuperPower")) {
                Player.updateInventory("SuperPower", -1);
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 3; j++) {
                        PlotBackend.plots[j][i].setSeedStatus("Mature");
                        PlotBackend.plots[j][i].setWaterLevel(4);
                    }
                }
                TransitionScene tScene = new TransitionScene();
                Stage tStage = new Stage();
                try {
                    tScene.start(tStage, "Laser");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                plotFrame.getChildren().clear();

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 3; j++) {
                        Plot plot = PlotBackend.plots[j][i];
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
                leftSide.getChildren().addAll( currentDate, seasonLabel);

            }
        });






        VBox rightSide = new VBox();
        rightSide.setSpacing(20);
        rightSide.setAlignment(Pos.TOP_RIGHT);
        rightSide.getChildren().addAll(nextDayButton, storeButton, inventoryButton, superpowerButton, returnButton);

        bPane.setCenter(plotFrame);
        bPane.setLeft(leftSide);
        bPane.setRight(rightSide);

        stage.setScene(scene3);
        stage.show();
    }
}