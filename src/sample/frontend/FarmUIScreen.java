package sample.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.backend.Player;


public class FarmUIScreen extends Application {
    private Player player;
    public FarmUIScreen(Player player1){
        this.player = player1;
    }
    private Scene scene3;
    @Override
    public void start(Stage stage) throws Exception {

        //Layout for Third Scene
        StackPane root = new StackPane();
        stage.setTitle("FarmUI Screen");
        GridPane grid3 = new GridPane();
        scene3 = new Scene(grid3, 900, 600);
        grid3.setPadding(new Insets(10, 10, 10, 10));
        grid3.setVgap(8);
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
        grid3.setColumnIndex(returnButton, 42);
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
        storeButton.setFont(new Font("Futura", 16));
        grid3.setRowIndex(storeButton, 42);
        grid3.setColumnIndex(storeButton, 2);
        storeButton.setMinWidth(60);
        //Generates a popup for now, but should probably change later
        storeButton.setOnAction(e -> {
            Stage storeStage = new Stage();
            StoreScene s = new StoreScene();
            try {
                s.start(storeStage);
                stage.close();
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
                newPlot.setMinHeight(30);
                newPlot.setMinWidth(60);
            }
        }


        grid3.setRowIndex(plotFrame, 45);
        grid3.setColumnIndex(plotFrame, 33);
        grid3.getChildren().addAll(plotFrame, returnButton, storeButton);
        stage.setScene(scene3);
        stage.show();
    }
}