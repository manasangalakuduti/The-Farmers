package sample.frontend;

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

import java.time.LocalDateTime;
import java.util.Random;


public class FarmUIScreen extends Application {
    //private Player player;
    private Date date;
    public FarmUIScreen(String season) {
        this.date = new Date(season, LocalDateTime.now());
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
        returnButton.setStyle("-fx-background-color: #f884ad; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;");



        Label name = new Label("Player Name: " + Player.getName());
        name.setFont(new Font("Futura", 20));

        Label dateLabel = new Label("Season: " + date.getSeason());
        dateLabel.setFont(new Font("Futura", 20));

        Label moneys = new Label("Balance: $" + Math.round(Player.getBalance()));
        moneys.setFont(new Font("Futura", 20));

        VBox leftSide = new VBox();
        leftSide.setSpacing(20);
        leftSide.getChildren().addAll(name, dateLabel, moneys);


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
                leftSide.getChildren().remove(moneys);
                moneys.setText("Balance: $" + Math.round(Player.getBalance()));
                leftSide.getChildren().add(moneys);


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

        //Adds in the new plots

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {


                Random rand = new Random();
                int n = rand.nextInt(4);

                Random rand2 = new Random();
                int m = rand.nextInt(3);
                String initialStatus;

                if(m == 0) {
                    initialStatus = "Seed";
                } else if (m == 1) {
                    initialStatus = "Immature";
                } else {
                    initialStatus = "Mature";
                }


                Plot newPlot = new Plot(i, j, Player.itemTypes()[n], initialStatus);


                plotFrame.getChildren().addAll(newPlot);
                plotFrame.setRowIndex(newPlot, j);
                plotFrame.setColumnIndex(newPlot, i);
                newPlot.setMinHeight(30);
                newPlot.setMinWidth(60);
                newPlot.setMaxHeight(30);
                newPlot.setMaxWidth(60);

//                Image image = new Image("sample/media/dirt.png",
//                        newPlot.getWidth(), newPlot.getHeight(),
//                        false, true, true);
//                BackgroundImage bImage = new BackgroundImage(image,
//                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
//                        BackgroundPosition.CENTER,
//                        new BackgroundSize(newPlot.getWidth(),
//                                newPlot.getHeight(), true, true, true, false));
//
//                Background backGround = new Background(bImage);
//                newPlot.setBackground(backGround);
//
//                newPlot.setBorder(new Border(new BorderStroke(Color.BLACK,
//                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

            }
        }

        //Making label for player money



        VBox rightSide = new VBox();
        rightSide.setSpacing(20);
        rightSide.setAlignment(Pos.TOP_RIGHT);
        rightSide.getChildren().addAll(storeButton, inventoryButton, returnButton);



        bPane.setCenter(plotFrame);
        bPane.setLeft(leftSide);
        bPane.setRight(rightSide);




        stage.setScene(scene3);
        stage.show();
    }
}