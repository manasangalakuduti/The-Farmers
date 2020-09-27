
package sample.frontend;
import javafx.application.Application;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class Main extends Application {

    private Scene scene2;


    @Override
    public void start(Stage primaryStage) throws Exception {
        //First Scene - Layout
        primaryStage.setTitle("The Farmers");

        //Setting up GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Stage s = new Stage();
        ConfigurationScreen c = new ConfigurationScreen();
        //Adding 'Start Game Button' + configurations
        Button button1 = new Button("Start Game");
        GridPane.setConstraints(button1, 8, 8);
        grid.getChildren().addAll(button1);
        button1.setOnAction(e -> {
            try {
                c.start(s);
                primaryStage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
        button1.setStyle("-fx-background-color: Chartreuse; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;");
        button1.setFont(new Font("Futura", 20));
        grid.setStyle("-fx-background-color: DeepSkyBlue");

        //Creating First Scene
        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}