package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
    @FXML
    private Button counterClicker;

    private static int counter;

    @FXML
    public void initialize() {
        counterClicker.setText("" + counter);
    }

    @FXML
    private void showCount(ActionEvent event) {
        counter++;
        System.out.println("Click Count: " + counter);
        counterClicker.setText("" + counter);
    }
}
