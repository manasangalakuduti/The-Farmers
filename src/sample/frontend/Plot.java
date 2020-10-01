package sample.frontend;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Map;

public class Plot extends Button {
    private int xIndex;
    private int yIndex;
    private String seedType;
    Map<String, String> map = Map.of("Dirt", "sample/media/dirt.png", "test","test");

    public Plot(int xIndex, int yIndex, String seedType) {
        //super(seedType, new ImageView(new Image(new File("sample/media/dirt.png").toURI().toString())));
        this.xIndex = xIndex;
        this.yIndex = yIndex;
        this.seedType = seedType;
        this.setOnAction(e -> {
            Stage cropStage = new Stage();
            CropInfoScreen c = new CropInfoScreen();
            try {
                c.start(cropStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Image image = new Image(map.get(seedType), this.getWidth(), this.getHeight(),
                false, true, true);
        BackgroundImage bImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(this.getWidth(), this.getHeight(), true, true, true, false));

        Background backGround = new Background(bImage);
        this.setBackground(backGround);

        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

    }

    public Plot(int xIndex, int yIndex) {
        this(xIndex, yIndex, "Corn");

    }


    public int getxIndex() {
        return this.xIndex;
    }

    public int getyIndex() {
        return this.yIndex;
    }

    public String getSeedType() {
        return this.seedType;
    }

    public void setSeedType(String seedType) {
        this.seedType = seedType;
    }

    public void setxIndex(int xIndex) {
        this.xIndex = xIndex;
    }

    public void setyIndex(int yIndex) {
        this.yIndex = yIndex;
    }
}

