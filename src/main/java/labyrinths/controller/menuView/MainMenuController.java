package labyrinths.controller.menuView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import labyrinths.App;
import labyrinths.controller.labyrinthView.LabyrinthGetter;
import labyrinths.model.LabyrinthPreset;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeControls();
    }

    @FXML
    Button preset10x10Btn, preset20x40Btn, preset15x30Btn, confirmBtn;
    @FXML
    Slider heightSlider, widthSlider;
    @FXML
    ImageView preset10x10Img, preset15x30Img, preset20x40Img;

    Image preset10x10 = new Image(new File("src/main/resources/drawable/preset_10x10.png").toURI().toString());
    Image preset15x30 = new Image(new File("src/main/resources/drawable/preset_15x30.png").toURI().toString());
    Image preset20x40 = new Image(new File("src/main/resources/drawable/preset_20x40.png").toURI().toString());

    void initializeControls() {

        preset10x10Btn.setOnAction(actionEvent -> {
            try {
                App.mainStage.setScene(LabyrinthGetter.getLabyrinthScene(10,10,LabyrinthPreset.PRESET_10x10));
                App.mainStage.setMaximized(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        preset10x10Img.setImage(preset10x10);

        preset15x30Btn.setOnAction(actionEvent -> {
            try {
                App.mainStage.setScene(LabyrinthGetter.getLabyrinthScene(15,30,LabyrinthPreset.PRESET_15x30));
                App.mainStage.setMaximized(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        preset15x30Img.setImage(preset15x30);

        preset20x40Btn.setOnAction(actionEvent -> {
            try {
                App.mainStage.setScene(LabyrinthGetter.getLabyrinthScene(20,40,LabyrinthPreset.PRESET_20x40));
                App.mainStage.setMaximized(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        preset20x40Img.setImage(preset20x40);

        confirmBtn.setOnAction((actionEvent -> {
            try {
                App.mainStage.setScene(LabyrinthGetter.
                        getLabyrinthScene((int) heightSlider.getValue(),(int) widthSlider.getValue(), LabyrinthPreset.DEFAULT));
                App.mainStage.setMaximized(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
}