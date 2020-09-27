package sample.frontend;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Plot extends Button {
    private int xIndex;
    private int yIndex;
    private String seedType;

    public Plot(int xIndex, int yIndex, String seedType) {
        super(seedType);
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

