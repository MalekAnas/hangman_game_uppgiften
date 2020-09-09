package se.ecutbildning.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import se.ecutbildning.App;

public class LandingController {


    @FXML
    private AnchorPane anchor_bk;

    @FXML
    private Label hangman_lable;

    @FXML
    private Button btn_play;





    @FXML
    private void switchToGame() throws IOException {
        App.setRoot("game");
    }
}
