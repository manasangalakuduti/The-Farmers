package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    Scene scene2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //First Scene - Layout
        primaryStage.setTitle("The Farmers");

        //Setting up GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Adding 'Start Game Button' + configurations
        Button button1 = new Button("Start Game");
        GridPane.setConstraints(button1, 8, 8);
        grid.getChildren().addAll(button1);
        button1.setOnAction(e -> {
             primaryStage.setScene(scene2);
            });
        button1.setStyle("-fx-background-color: CornflowerBlue; -fx-text-fill: white;"
                           + "fx-border-radius: 10; -fx-background-radius: 10;");
        button1.setFont(new Font("Futura", 20));
        grid.setStyle("-fx-background-color: LightGreen");

        //Creating First Scene
        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

        //Layout for Second Scene
        GridPane grid2 = new GridPane();
        scene2 = new Scene(grid2, 900, 600);
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(8);
        grid2.setHgap(10);
        grid2.setStyle("-fx-background-color: LemonChiffon");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
