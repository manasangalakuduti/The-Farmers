package sample.frontend;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import sample.backend.Market;
import sample.backend.Date;
import sample.backend.Player;
import sample.backend.StoreBackend;

import java.time.LocalDateTime;


public class ConfigurationScreen extends Application {

    private Scene scene2;

    @Override
    public void start(Stage stage) throws Exception {
        
        //Layout for Second Scene
        StackPane root = new StackPane();
        stage.setTitle("Configuration Screen");

        GridPane grid2 = new GridPane();
        scene2 = new Scene(grid2, Main.X_WIDTH, Main.Y_WIDTH);
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(8);
        grid2.setHgap(10);
        grid2.setStyle("-fx-background-color: LemonChiffon");
        stage.setScene(scene2);

        //Set Text Field
        Label playerLabel = new Label("Player name:");
        playerLabel.setFont(new Font("Futura", 15));
        TextField nameInput = new TextField();
        nameInput.setPromptText("Enter Name Here:");
        EventHandler<ActionEvent> event = e -> playerLabel.setText(nameInput.getText());
        nameInput.setOnAction(event);

        //Drop down to select difficulty
        Label difficultyLabel = new Label("Difficulty:");
        difficultyLabel.setFont(new Font("Futura", 15));
        ChoiceBox<String> difficulty = new ChoiceBox<>();
        difficulty.getItems().addAll("Easy", "Medium", "Hard", "Master");

        //Set default difficulty
        difficulty.setValue("Easy");

        //Drop down to select starting seed
        Label seedLabel = new Label("Seed Type:");
        seedLabel.setFont(new Font("Futura", 15));
        ChoiceBox<String> startingSeed = new ChoiceBox<>();
        startingSeed.getItems().addAll("Corn", "Soybeans", "Tomato", "Peas");
        startingSeed.setValue("Corn");

        //Drop down to select starting season
        Label seasonLabel = new Label("Starting Season:");
        seasonLabel.setFont(new Font("Futura", 15));
        ChoiceBox<String> startingSeason = new ChoiceBox<>();
        startingSeason.getItems().addAll("Spring", "Summer", "Fall", "Winter");
        startingSeason.setValue("Spring");

        //Return Button
        Button b3 = new Button("Return");
        b3.setStyle("-fx-background-color: Chartreuse; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;");
        grid2.setRowIndex(b3, 0);
        grid2.setColumnIndex(b3, 66);
        b3.setOnAction(e -> {
            Stage returnStage = new Stage();
            Main m = new Main();
            try {
                m.start(returnStage);
                stage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Button b2 = new Button("Continue");
        b2.setStyle("-fx-background-color: Chartreuse; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;");
        grid2.setRowIndex(b2, 13);
        grid2.setColumnIndex(b2, 1);

        grid2.setRowIndex(nameInput, 1);
        grid2.setColumnIndex(nameInput, 1);

        grid2.setRowIndex(playerLabel, 0);
        grid2.setColumnIndex(playerLabel, 1);

        grid2.setRowIndex(difficultyLabel, 3);
        grid2.setColumnIndex(difficultyLabel, 1);

        grid2.setRowIndex(difficulty, 4);
        grid2.setColumnIndex(difficulty, 1);

        grid2.setRowIndex(startingSeed, 7);
        grid2.setColumnIndex(startingSeed, 1);

        grid2.setRowIndex(seedLabel, 6);
        grid2.setColumnIndex(seedLabel, 1);

        grid2.setRowIndex(seasonLabel, 9);
        grid2.setColumnIndex(seasonLabel, 1);

        grid2.setRowIndex(startingSeason, 10);
        grid2.setColumnIndex(startingSeason, 1);

        grid2.setStyle("-fx-background-image: url(/sample/media/configImage"
                + ".png);"
                + "-fx-background-size: 900px 600px;");
        grid2.getChildren().addAll(b2, b3, nameInput, playerLabel, difficulty,
                startingSeed, startingSeason, difficultyLabel, seedLabel, seasonLabel);
        b2.setOnAction(e -> {
            nameInput.setText(nameInput.getText().trim());
            String validation = validateNameInput(nameInput.getText());
            if (validation == "") {
                Stage s1 = new Stage();
                String choice = difficulty.getValue();
                double initialMoney = 0.0;
                switch (choice) {
                case "Easy":
                    initialMoney = 1000.0;
                    break;
                case "Medium":
                    initialMoney = 500.0;
                    break;
                case "Hard":
                    initialMoney = 250.0;
                    break;
                default:
                    initialMoney = 100.0;
                    break;
                }
                Date season = new Date(startingSeason.getValue(), LocalDateTime.now());
                Market market = new Market(season, choice);
                StoreBackend store = new StoreBackend("1101", market);
                Player.initialize(nameInput.getText(), initialMoney);
                Player.updateInventory(startingSeed.getValue(), 5);
                FarmUIScreen f = new FarmUIScreen(/*player, */startingSeason.getValue());
                try {
                    f.start(s1);
                    stage.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                //set alert type
                Alert a = new Alert(Alert.AlertType.ERROR);

                // set content text
                a.setContentText(validation);

                a.show();
            }
        });
        stage.show();
    }

    //Validate if the textfield for player's name
    public String validateNameInput(String name) {
        if (name.length() == 0) {
            return "Length of name cannot be zero.";
        } else {
            return "";
        }
    }


}
