package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import sample.FarmUIScreen;

public class ConfigurationScreen extends Application {

    Scene scene2;
    @Override
    public void start(Stage stage) throws Exception {
        //"Shorter methods and moving stuff into separate methods

        //break things up - good coding practice
        
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

        //Set Text Field
        TextField enterName = new TextField("Enter Name");
        Label playerLabel = new Label("Player name");
        EventHandler<ActionEvent> event = e -> playerLabel.setText(enterName.getText());

        enterName.setOnAction(event);

        //Drop down to select difficulty
        ChoiceBox<String> difficulty = new ChoiceBox<>();
        difficulty.getItems().addAll("Easy", "Medium", "Hard", "Master");

        //Set default difficulty
        difficulty.setValue("Easy");

        //Drop down to select starting seed
        ChoiceBox<String> startingSeed = new ChoiceBox<>();
        startingSeed.getItems().addAll("Corn", "Soybeans", "Tomato", "Peas");
        startingSeed.setValue("Corn");

        //Drop donw to select starting season
        ChoiceBox<String> startingSeason = new ChoiceBox<>();
        startingSeason.getItems().addAll("Spring", "Summer", "Fall", "Winter");
        startingSeason.setValue("Spring");



        Button b2 = new Button("Test");
        grid2.setRowIndex(b2, 0);
        grid2.setColumnIndex(b2, 1);

        grid2.setRowIndex(enterName, 1);
        grid2.setColumnIndex(enterName, 1);

        grid2.setRowIndex(playerLabel, 2);
        grid2.setColumnIndex(playerLabel, 1);

        grid2.setRowIndex(difficulty, 3);
        grid2.setColumnIndex(difficulty, 1);

        grid2.setRowIndex(startingSeed, 4);
        grid2.setColumnIndex(startingSeed, 1);

        grid2.setRowIndex(startingSeason, 5);
        grid2.setColumnIndex(startingSeason, 1);

        grid2.getChildren().addAll(b2, enterName, playerLabel, difficulty,
                startingSeed, startingSeason);
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
