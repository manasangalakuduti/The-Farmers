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

    private void setSeedType(String seedType) {
        this.seedType = seedType;
    }

    private void setxIndex(int xIndex) {
        this.xIndex = xIndex;
    }

    private void setyIndex(int yIndex) {
        this.yIndex = yIndex;
    }
}

//Adds in the new plots
//        int num = 0;
//        for (int i=0; i<5; i++){
//            for (int j=0; j<3; j++) {
//                grid3.getChildren().addAll(new Plot(i, j, "Corn"));
//            }
//        }