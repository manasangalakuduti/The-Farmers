package sample.frontend;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.backend.Date;
import sample.backend.PlotBackend;


public class Plot extends Button {
    private int xIndex;
    private int yIndex;
    private String seedType;
    private String status;
    private int statusUpdateTime;
    private int waterLevel;
    private boolean wateredToday = false;

    private boolean isFertalized;
    private int harvestQuantity;

    private boolean isProtected;


    public Plot(int xIndex, int yIndex, String seedType, String status) {
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
        this.statusUpdateTime = 0;
        this.waterLevel = 3;
        this.isFertalized = false;
        this.harvestQuantity = 3;
        this.isProtected = false;
    }


    public void nextDay() {
        if (!this.status.equals("Dirt")) {
            if (!this.status.equals("Dead")) {
                this.waterLevel--;
            }
            if (this.waterLevel < 1 || this.waterLevel > 5) {
                this.status = "Dead";
            }
        }
        if (Date.getDate() - statusUpdateTime > 1 || this.isFertalized) {
            if (this.status.equals("Seed")) {
                this.status = "Immature";
            } else if (this.status.equals("Immature")) {
                this.status = "Mature";
            } else if (this.status.equals("Mature")) {
                this.status = "Dead";
            } else if (this.status.equals("Dead")) {
                this.status = "Dead";
            } else if (this.status.equals("Dirt")) {
                this.status = "Dirt";
            }
            this.statusUpdateTime = Date.getDate();
            this.isFertalized = false;
        }
    }

    public void plant(String seedType) {
        this.status = "Seed";
        this.seedType = seedType;
        this.setPlotImage("Seed", seedType);
        this.statusUpdateTime = Date.getDate();
        this.waterLevel += 1;
    }

    public void clear() {
        this.status = "Dirt";
        this.seedType = "Dirt";
        this.setPlotImage("Dirt", "Dirt");
        this.statusUpdateTime = Date.getDate();
        this.waterLevel = 0;
        this.isFertalized = false;
        this.isProtected = false;
    }

    public void protect() {
        this.isProtected = true;
    }

    public void water() {
        this.waterLevel += 2;
    }

    public void setPlotImage(String status, String seedType) {
        String toSet;
        if (status.equals("Dirt")) {
            toSet  = "Dirt";
        } else if (status.equals("Seed")) {
            toSet  = "Seed";
        } else if (status.equals("Immature")) {
            toSet = "Plant";
        } else if (status.equals("Dead")) {
            toSet = "Dead";
        } else {
            toSet = seedType;
        }

        Image image = new Image(PlotBackend.getImageMap().get(toSet),
                this.getWidth(), this.getHeight(),
                false, true, true);
        BackgroundImage bImage = new BackgroundImage(image, BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(this.getWidth(), this.getHeight(), true, true, true, false));
        Background backGround = new Background(bImage);
        this.setBackground(backGround);
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    public void setPlotImage() {
        setPlotImage(status, seedType);
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

    public int getWaterStatus() {
        return this.waterLevel;
    }

    public void setWaterLevel(int level) {
        this.waterLevel = level;
    }

    public void setWateredToday(boolean b) {
        this.wateredToday = b;
    }

    public boolean getWateredToday() {
        return this.wateredToday;
    }

    public int getHarvestQuantity() {
        return this.harvestQuantity;
    }
    public void setHarvestQuantity(int harvestQuantity) {
        this.harvestQuantity = harvestQuantity;
    }
    public boolean isFertalized() {
        return this.isFertalized;
    }
    public void setFertalized(boolean isFertalized) {
        this.isFertalized = isFertalized;
    }


    public boolean isProtected() {
        return this.isProtected;
    }

    public void setProtected(boolean aProtected) {
        this.isProtected = aProtected;
    }
}

