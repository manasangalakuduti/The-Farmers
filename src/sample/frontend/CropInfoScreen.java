package sample.frontend;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Popup;
import javafx.stage.Stage;


public class CropInfoScreen extends Application {

    private Scene scene3;
    @Override
    public void start(Stage stage) throws Exception {
        // create a label
        Label label = new Label("This is a Popup");
        // create a popup
        Popup popup = new Popup();
        // set background
        label.setStyle(" -fx-background-color: white;");
        // add the label
        popup.getContent().add(label);
        // set size of label
        label.setMinWidth(80);
        label.setMinHeight(50);
        stage.show();



    }
}
