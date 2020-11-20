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

public class FarmUIScreen extends Application {

    private Scene scene3;
    public void start() throws Exception {
        start(new Stage());
    }

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

        for (int i = 0; i < 3; i++) {
            System.out.println("-------");
            for (int j = 0; j < 5; j++) {
                System.out.printf("Setting i at %d and j at %d\n", i, j);
                if (PlotBackend.getPlots(i, j) == null) {
                    PlotBackend.setNewPlot(i, j);
                } else {
                    System.out.println("Fucl");
                }
                Plot newPlot = PlotBackend.getPlots(i, j);
                plotFrame.getChildren().addAll(newPlot);
                plotFrame.setRowIndex(newPlot, i);
                plotFrame.setColumnIndex(newPlot, j);
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
            Player.resetWaterHarvest();
            if (FarmUIScreen.endGame()) {
                EndScreen endScene = new EndScreen();
                Stage s = new Stage();
                try {
                    endScene.start(s);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (FarmUIScreen.winGame()) {
                System.out.println("You won");
                WinScreen winScene = new WinScreen();
                Stage s = new Stage();
                try {
                    winScene.start(s);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            PlotBackend.naturalEvent();
            for (int i = 0; i < 15; i++) {
                int j = i / 5;
                int k = i % 5;
                PlotBackend.setPlots(j, k, (Plot) plotFrame.getChildren().get(i));
            }
            plotFrame.getChildren().clear();
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
            moneys.setText("Balance: $" + Math.round(Player.getBalance()));
            leftSide.getChildren().addAll(currentDate, seasonLabel);
        });



        Button superpowerButton = this.getButton("SuperPower", "f4a261");
        superpowerButton.setOnAction(e -> {
            if (Player.hasItem("SuperPower")) {
                Player.updateInventory("SuperPower", -1);
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 3; j++) {
                        Plot p = PlotBackend.getPlots(j, i);
                        p.setSeedStatus("Mature");
                        p.setWaterLevel(4);
                        PlotBackend.setPlots(j, i, p);
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

            }
        });



        VBox rightSide = new VBox();
        rightSide.setSpacing(20);
        rightSide.setAlignment(Pos.TOP_RIGHT);
        rightSide.getChildren().addAll(nextDayButton, storeButton,
                inventoryButton, returnButton, superpowerButton);
        PlotBackend.setFarmScreen(this);

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

    public static boolean endGame() {
        double balance = Player.getBalance();
        Plot[][] plots = PlotBackend.plots;
        for (int i = 0; i < plots.length; i++) {
            for (int j = 0; j < plots[i].length; j++) {
                if (balance > 10
                    && (plots[i][j].getSeedStatus().equals("Mature")
                    || plots[i][j].getSeedStatus().equals("Immature")
                    || plots[i][j].getSeedStatus().equals("Seed"))) {
                    return false;
                } else if (balance <= 10 && (plots[i][j].getSeedStatus().equals("Mature")
                    || plots[i][j].getSeedStatus().equals("Immature")
                    || plots[i][j].getSeedStatus().equals("Seed"))) {
                    return false;
                } else if (balance > 10 && !(plots[i][j].getSeedStatus().equals("Mature")
                    || plots[i][j].getSeedStatus().equals("Immature")
                    || plots[i][j].getSeedStatus().equals("Seed"))) {
                    return false;
                }
            }
        }
        return true;
       
    }

    public static boolean winGame() {
        Plot[][] plots = PlotBackend.plots;
        double balance = Player.getBalance();
        int quantity = Player.getQuantityOf("Tomato") + Player.getQuantityOf("Soybeans")
                + Player.getQuantityOf("Corn") + Player.getQuantityOf("Peas");
        for (int i = 0; i < plots.length; i++) {
            for (int j = 0; j < plots[i].length; j++) {
                if (quantity < 10 && balance <= 10
                        && Player.getQuantityOf("Superpower") == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}