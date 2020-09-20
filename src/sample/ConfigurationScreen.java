package sample;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import sample.FarmUIScreen;

public class ConfigurationScreen extends Application {

    Scene scene2;
    @Override
    public void start(Stage stage) throws Exception {

        //Layout for Second Scene
        StackPane root = new StackPane();
        stage.setTitle("Configuration Screen");

        GridPane grid2 = new GridPane();
        scene2 = new Scene(grid2, 900, 600);
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(8);
        grid2.setHgap(10);
        grid2.setStyle("-fx-background-color: LemonChiffon");
        stage.setScene(scene2);
        Button b2 = new Button("Test");
        grid2.getChildren().addAll(b2);
        b2.setOnAction(e -> {
            Stage s1 = new Stage();
            FarmUIScreen f = new FarmUIScreen();
            try {
                f.start(s1);
                stage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        stage.show();
    }


}
