package se.ecutbildning.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import se.ecutbildning.game_core.Game;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController  implements Initializable {


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
    private Label gameover_label;

    @FXML
    private Button change_btn;
    @FXML
    private HBox mystery_word;



    //Game obj

    private Game game= new Game();
    private char guess;
    private int tries;

    private boolean isCorrectAnswer;

    public GameController() throws FileNotFoundException {
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {


        gameover_label.setVisible(false);

        System.out.println(game.getMysteryWord());
        System.out.println(game.getFormalCurrentGuess());
        label_mystery.setText(game.getFormalCurrentGuess());

    }



    @FXML
    void printLetter(MouseEvent event) throws FileNotFoundException {
        System.out.println(((Button) event.getSource()).getText());


        guess = ((Button) event.getSource()).getText().toLowerCase().charAt(0);

        isCorrectAnswer = game.checkGuess(guess);

        if (!isCorrectAnswer){
            tries = tries + 1;
            if (tries > 6){
                gameover_label.setText("You lose!");
                gameover_label.setVisible(true);
                gameover_label.setStyle("-fx-text-fill: #8c2424");
            }
        }



        updaterLabel();


    }



    @FXML
    void pickAnotherWord(ActionEvent event) throws FileNotFoundException {


        game.setMysteryWord(game.getNewMesteryWord());
        game.initCurrentGuess();

        System.out.println(game.getMysteryWord());
        System.out.println(game.getFormalCurrentGuess());
        updaterLabel();

    }



    public void updaterLabel (){


        label_mystery.setText(game.getFormalCurrentGuess());
    }
    public void saveCodeHere() {
        // letter_mystery.setText(((Button)event.getSource()).getText());

    }



    public char getGuess() {
        return guess;
    }

    public void setGuess(char guess) {
        this.guess = guess;
    }



}
