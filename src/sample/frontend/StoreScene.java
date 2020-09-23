package sample.frontend;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class StoreScene extends Application {

    private Scene scene3;
    @Override
    public void start(Stage stage) throws Exception {

        //Layout for Third Scene
        StackPane root = new StackPane();
        stage.setTitle("Store Screen");
        GridPane grid3 = new GridPane();

        Rectangle r = new Rectangle();
        r.setAccessibleText("ACCESS");

        grid3.getChildren().addAll(r);
        stage.setScene(scene3);
        stage.show();
    }
}