package se.ecutbildning.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import se.ecutbildning.game_core.Game;

import java.io.FileNotFoundException;

public class GameController {


    @FXML
    private AnchorPane game_bk;

    @FXML
    private Button keyboardBtn;


    @FXML
    private ImageView hangman_drawing;

    @FXML
    private HBox tries_container;

    @FXML
    private ImageView heart_icon;


    @FXML
    private Label label_mystery;


    @FXML
    private Button change_btn;
    @FXML
    private HBox mystery_word;


    //Game obj

    private Game game = new Game();
    char guess;

    public GameController() throws FileNotFoundException {
    }


    @FXML
    void printLetter(MouseEvent event) {
        System.out.println(((Button) event.getSource()).getText());


        label_mystery.setText(game.getFormalCurrentGuess());

        String readString = ((Button) event.getSource()).getText();
        guess = readString.charAt(0);
        System.out.println(guess + " Guess");
        updaterLabel();


    }



    @FXML
    void pickAnotherWord(ActionEvent event) {

        String mw = game.getMesteryWord();
        System.out.println(mw);
        System.out.println(game.initCurrentGuess(mw).toString());
        label_mystery.setText(game.getFormalCurrentGuess());

    }


    public void checkGuess(Character ch) {


        for (int i = 0; i < game.getMesteryWord().length() *2; i++) {

            if (game.getMesteryWord().charAt(i) == ch) {

                game.getPreviousGuesses().add(ch);
                game.getCurrentGuess().setCharAt(i/2, ch);
            }

        }


    }


    public void updaterLabel (){
        checkGuess(guess);
        label_mystery.setText(game.getFormalCurrentGuess());
    }
    public void saveCodeHere() {
        // letter_mystery.setText(((Button)event.getSource()).getText());

    }


}
