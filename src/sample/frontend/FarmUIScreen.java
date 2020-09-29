package sample.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.backend.Date;
import sample.backend.Player;

import java.time.LocalDateTime;


public class FarmUIScreen extends Application {
    private Player player;
    private Date date;
    public FarmUIScreen(Player player1, String season) {
        this.player = player1;
        this.date = new Date(season, LocalDateTime.now());
    }
    private Scene scene3;
    @Override
    public void start(Stage stage) throws Exception {

        //Layout for Third Scene
        StackPane root = new StackPane();
        stage.setTitle("FarmUI Screen");
        GridPane grid3 = new GridPane();
        scene3 = new Scene(grid3, 1920, 600);
        grid3.setPadding(new Insets(10, 10, 10, 10));
        grid3.setVgap(10);
        grid3.setHgap(10);

        grid3.setStyle("-fx-background-color: LemonChiffon");
        grid3.setStyle("-fx-background-image: url(/sample/media/farm.png);"
                + "-fx-background-size: 900px 600px;"
                + "-fx-padding-top: 100%;");


        //Return Button
        Button returnButton = new Button("Return");
        returnButton.setStyle("-fx-background-color: DeepSkyBlue; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;");
        grid3.setRowIndex(returnButton, 0);
        grid3.setColumnIndex(returnButton, 107);
        returnButton.setMinWidth(60);
        //Generates a popup for now, but should probably change later
        returnButton.setOnAction(e -> {
            Stage returnStage = new Stage();
            ConfigurationScreen c = new ConfigurationScreen();
            try {
                c.start(returnStage);
                stage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });



        //Store Button
        Button storeButton = new Button("Store");
        storeButton.setStyle("-fx-background-color: #f884ad; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;");
        storeButton.setFont(new Font("Futura", 15));
        grid3.setRowIndex(storeButton, 24);
        grid3.setColumnIndex(storeButton, 70);
        storeButton.setMinWidth(60);
        //Generates a popup for now, but should probably change later
        storeButton.setOnAction(e -> {
            Stage storeStage = new Stage();
            StoreScene s = new StoreScene();
            try {
                s.start(storeStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        //Inventory Button
        Button inventoryButton = new Button("Inventory");
        inventoryButton.setStyle("-fx-background-color: #f884ad; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;");
        inventoryButton.setFont(new Font("Futura", 15));
        grid3.setRowIndex(inventoryButton, 27);
        grid3.setColumnIndex(inventoryButton, 0);
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

        plotFrame.setHgap(10);
        plotFrame.setVgap(10);

        //Adds in the new plots

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Plot newPlot = new Plot(i, j, "Dirt");
                plotFrame.getChildren().addAll(newPlot);
                plotFrame.setRowIndex(newPlot, j);
                plotFrame.setColumnIndex(newPlot, i);
                newPlot.setMinHeight(50);
                newPlot.setMinWidth(100);
            }
        }
        //Making label for player money
        Label moneys = new Label("Balance: $" + player.getBalance());
        moneys.setFont(new Font("Futura", 12));
        Label name = new Label("Player Name: " + player.getName());
        name.setFont(new Font("Futura", 12));
        grid3.setRowIndex(moneys, 4);
        grid3.setColumnIndex(moneys, 20);
        grid3.setRowIndex(name, 2);
        grid3.setColumnIndex(name, 20);

        Label dateLabel =
                new Label("Season: " + date.getSeason());
        dateLabel.setFont(new Font("Futura", 12));
        grid3.setRowIndex(dateLabel, 0);
        grid3.setColumnIndex(dateLabel, 20);

        grid3.setRowIndex(plotFrame, 27);
        grid3.setColumnIndex(plotFrame, 85);
        grid3.getChildren().addAll(plotFrame, returnButton, storeButton,
                moneys, name, dateLabel, inventoryButton);
        stage.setScene(scene3);
        stage.show();
    }
}