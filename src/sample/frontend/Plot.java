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
    private String status;
    private Map<String, String> map = Map.of("Dirt", "sample/media/dirt.png",
            "Seed", "sample/media/seed.png",
            "Tomato", "sample/media/tomato.jpg",
            "Peas", "sample/media/peas.png",
            "Soybeans", "sample/media/beans.png",
            "Corn", "sample/media/corn.png",
            "Plant", "sample/media/plant.jpg");

    public Plot(int xIndex, int yIndex, String seedType, String status) {
        //super(seedType, new ImageView
        //(new Image(new File("sample/media/dirt.png").toURI().toString())));
        this.xIndex = xIndex;
        this.yIndex = yIndex;
        this.seedType = seedType;
        this.setOnAction(e -> {
            Stage cropStage = new Stage();
            CropInfoScreen c = new CropInfoScreen(this);
            try {
                c.start(cropStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        this.status = status;
        this.setPlotImage(status, seedType);

    }

    public void plant(String seedType) {
        this.status = "Seed";
        this.seedType = seedType;
        this.setPlotImage("Seed", seedType);
    }

    public void clear() {
        this.status = "Dirt";
        this.seedType = "Dirt";
        this.setPlotImage("Dirt", "Dirt");
    }

    public void setPlotImage(String status, String seedType) {
        String toSet;
        if (status.equals("Dirt")) {
            toSet  = "Dirt";
        } else if (status.equals("Seed")) {
            toSet  = "Seed";
        } else if (status.equals("Immature")) {
            toSet = "Plant";
        } else {
            toSet = seedType;
        }
        Image image = new Image(map.get(toSet), this.getWidth(), this.getHeight(),
                false, true, true);
        BackgroundImage bImage = new BackgroundImage(image, BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(this.getWidth(), this.getHeight(), true, true, true, false));
        Background backGround = new Background(bImage);
        this.setBackground(backGround);
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
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


    public String getSeedStatus() {
        return this.status;
    }

    public void setSeedStatus(String status) {
        this.status = status;
    }


    public void setxIndex(int xIndex) {
        this.xIndex = xIndex;
    }

    public void setyIndex(int yIndex) {
        this.yIndex = yIndex;
    }
}

