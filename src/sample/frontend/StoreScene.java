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
import sample.backend.Player;
import sample.backend.StoreBackend;


public class StoreScene extends Application {

    private Scene scene4;



    @Override
    public void start(Stage stage) throws Exception {

        //Layout for Third Scene
        BorderPane bPane = new BorderPane();
        stage.setTitle("Store Screen");
        scene4 = new Scene(bPane, 900, 600);
        bPane.setStyle("-fx-background-image: url(/sample/media/sunsetBack.png);"
                + "-fx-background-size: 900px 600px;"
                + "-fx-padding-top: 100%;");

        VBox middle = new VBox();
        //Shows current inventory
        for (String seed: Player.itemTypes()) {
            Button button = new Button("# of " + seed + " in bag: " +  Player.getQuantityOf(seed));
            button.setFont(new Font("Futura", 15));
            button.setStyle("-fx-background-color: #9a8c98; -fx-text-fill: black;"
                    + "fx-border-radius: 20; -fx-background-radius: 10;");
            middle.getChildren().add(button);
        }
        bPane.setCenter(middle);
        bPane.setAlignment(middle, Pos.CENTER);
        bPane.setPadding(new Insets(20));



        Button storeLabel = new Button(Player.getName() + "'s balance: "
                + Math.round(Player.getBalance()));
        storeLabel.setFont(new Font("Futura", 15));
        storeLabel.setStyle("-fx-background-color: #9a8c98; -fx-text-fill: black;"
                + "fx-border-radius: 20; -fx-background-radius: 10;");
        bPane.setTop(storeLabel);
        bPane.setAlignment(storeLabel, Pos.CENTER);
        storeLabel.setFont(new Font("Futura", 22));

        VBox leftSide = new VBox();
        leftSide.setSpacing(20);
        //Creates a list of items to buy
        for (String seed: Player.itemTypes()) {
            Button button = new Button("Purchase " + seed + ": " + StoreBackend.getMarket().getPrice(seed, 1));
            button.setFont(new Font("Futura", 15));
            button.setStyle("-fx-background-color: #e9c46a; -fx-text-fill: black;"
                    + "fx-border-radius: 20; -fx-background-radius: 10;");
            button.setOnAction(e -> {
                StoreBackend.purchase(seed, 1);
                Label storeLabel2 = new Label(Player.getName() + "'s balance: "
                        + Math.round(Player.getBalance()));
                storeLabel2.setFont(new Font("Futura", 15));
                storeLabel2.setStyle("-fx-background-color: #9a8c98; -fx-text-fill: black;"
                        + "fx-border-radius: 20; -fx-background-radius: 10;");
                bPane.setAlignment(storeLabel2, Pos.CENTER);
                storeLabel2.setFont(new Font("Futura", 22));
                bPane.setTop(storeLabel2);

                bPane.setCenter(null);
                VBox tempBox = new VBox();
                //UPDATE INVENTORY
                for (String innerSeed: Player.itemTypes()) {
                    Button invLabel = new Button("# of " + innerSeed + " in bag: " +  Player.getQuantityOf(innerSeed));
                    invLabel.setFont(new Font("Futura", 15));
                    invLabel.setStyle("-fx-background-color: #9a8c98; -fx-text-fill: black;"
                            + "fx-border-radius: 20; -fx-background-radius: 10;");
                    tempBox.getChildren().add(invLabel);
                }

                bPane.setCenter(tempBox);
                bPane.setAlignment(tempBox, Pos.CENTER);
                bPane.setPadding(new Insets(20));

            });
            leftSide.getChildren().add(button);
        }
        bPane.setLeft(leftSide);
        bPane.setAlignment(leftSide, Pos.CENTER);
        bPane.setPadding(new Insets(20));




        VBox rightSide = new VBox();
        rightSide.setSpacing(20);
        //Creates a list of items to buy
        for (String seed: Player.itemTypes()) {
            Button button = new Button("Sell " + seed + ": " + StoreBackend.getMarket().getPrice(seed, 1));
            button.setFont(new Font("Futura", 15));
            button.setStyle("-fx-background-color: #2a9d8f; -fx-text-fill: black;"
                    + "fx-border-radius: 20; -fx-background-radius: 10;");
            button.setOnAction(e -> {
                StoreBackend.sell(seed, 1);
                Label storeLabel3 = new Label(Player.getName() + "'s balance: "
                        + Math.round(Player.getBalance()));
                storeLabel3.setFont(new Font("Futura", 15));
                storeLabel3.setStyle("-fx-background-color: #9a8c98; -fx-text-fill: black;"
                        + "fx-border-radius: 20; -fx-background-radius: 10;");

                bPane.setAlignment(storeLabel3, Pos.CENTER);
                storeLabel3.setFont(new Font("Futura", 22));
                bPane.setTop(storeLabel3);

                bPane.setCenter(null);
                VBox tempBox = new VBox();
                //UPDATE INVENTORY
                for (String innerSeed: Player.itemTypes()) {
                    Button invLabel = new Button("# of " + innerSeed + " in bag: " +  Player.getQuantityOf(innerSeed));
                    invLabel.setFont(new Font("Futura", 15));
                    invLabel.setStyle("-fx-background-color: #9a8c98; -fx-text-fill: black;"
                            + "fx-border-radius: 20; -fx-background-radius: 10;");
                    tempBox.getChildren().add(invLabel);
                }

                bPane.setCenter(tempBox);
                bPane.setAlignment(tempBox, Pos.CENTER);
                bPane.setPadding(new Insets(20));

            });
            rightSide.getChildren().add(button);
        }
        bPane.setRight(rightSide);
        bPane.setAlignment(rightSide, Pos.CENTER);
        bPane.setPadding(new Insets(20));




        //Return Button
        Button returnButton = new Button("Close");
        returnButton.setStyle("-fx-background-color: white; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;");

        returnButton.setMinWidth(60);
        bPane.setBottom(returnButton);
        //Generates a popup for now, but should probably change later
        returnButton.setOnAction(e -> {
            try {
                stage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        stage.setScene(scene4);
        stage.show();

    }
}