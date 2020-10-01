package sample.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class StoreScene extends Application {

    private Scene scene4;

    @Override
    public void start(Stage stage) throws Exception {

        //Layout for Third Scene
        StackPane root = new StackPane();
        stage.setTitle("Store Screen");
        GridPane grid3 = new GridPane();
        scene4 = new Scene(grid3, 900, 600);
        grid3.setPadding(new Insets(10, 10, 10, 10));
        grid3.setVgap(8);
        grid3.setHgap(10);
        grid3.setStyle("-fx-background-color: LemonChiffon");
        grid3.setStyle("-fx-background-image: url(/sample/media/market.gif);"
                + "-fx-background-size: 900px 600px;"
                + "-fx-padding-top: 100%;");

        Rectangle r = new Rectangle();
        r.setAccessibleText("ACCESS");

        //Return Button
        Button returnButton = new Button("Close");
        returnButton.setStyle("-fx-background-color: white; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;");
        grid3.setRowIndex(returnButton, 0);
        grid3.setColumnIndex(returnButton, 80);
        returnButton.setMinWidth(60);
        //Generates a popup for now, but should probably change later
        returnButton.setOnAction(e -> {
            try {
                stage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


        grid3.getChildren().addAll(r, returnButton);
        stage.setScene(scene4);
        stage.show();
    }
}