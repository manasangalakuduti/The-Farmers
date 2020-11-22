
package sample.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;





public class Main extends Application {

    private Scene scene2;
    public static final int X_WIDTH = 900;
    public static final int Y_WIDTH = 600;
    Media media;


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
        button1.setOnAction(e -> {
            try {
                c.start(s);
                //primaryStage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
        button1.setStyle("-fx-background-color: Chartreuse; -fx-text-fill: black;"
                + "fx-border-radius: 10; -fx-background-radius: 10;");
        button1.setFont(new Font("Futura", 20));

        grid.setStyle("-fx-background-image: url(/sample/media/main"
                + ".gif);"
                + "-fx-background-size: 900px 600px;");
        //Creating First Scene
        Scene scene = new Scene(grid, X_WIDTH, Y_WIDTH);

        //Button Allignment
        grid.setRowIndex(button1, 13);
        grid.setColumnIndex(button1, 69);

        grid.getChildren().addAll(button1);
        primaryStage.setScene(scene);
        primaryStage.show();

        String db = getHostServices().getDocumentBase();
        media = new Media(db + "/src/sample/media/test.mp3");

        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
                mediaPlayer.play();
            }
        });
        mediaPlayer.play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}