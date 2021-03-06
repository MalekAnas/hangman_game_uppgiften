package se.ecutbildning.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import se.ecutbildning.game_core.Game;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {


    @FXML
    private Button Q;

    @FXML
    private Button W;

    @FXML
    private Button E;

    @FXML
    private Button R;

    @FXML
    private Button T;

    @FXML
    private Button Y;

    @FXML
    private Button U;

    @FXML
    private Button I;

    @FXML
    private Button O;

    @FXML
    private Button P;

    @FXML
    private Button A;

    @FXML
    private Button S;

    @FXML
    private Button D;

    @FXML
    private Button F;

    @FXML
    private Button G;

    @FXML
    private Button H;

    @FXML
    private Button J;

    @FXML
    private Button K;

    @FXML
    private Button L;

    @FXML
    private Button Z;

    @FXML
    private Button X;

    @FXML
    private Button C;

    @FXML
    private Button V;

    @FXML
    private Button B;

    @FXML
    private Button N;

    @FXML
    private Button M;

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

    @FXML
    private HBox qwerty;
    @FXML
    private HBox asdf;
    @FXML
    private HBox zxcv;

    @FXML
    private VBox keyboard;

    //Game obj

    private Game game = new Game();
    private char guess;
    private int tries = -1;
    private int maxTries = 5;
    private int triesPerLife;

    private String imageUrl;


    public GameController() throws FileNotFoundException {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        gameover_label.setVisible(false);

        System.out.println(game.getMysteryWord());
        System.out.println(game.getFormalCurrentGuess());
        label_mystery.setText(game.getFormalCurrentGuess());

    }

    //Event that occurs once a keyboard is clicked.
    //reads the guess char
    //
    @FXML
    void printLetter(MouseEvent event) throws FileNotFoundException {


        //reads guess char
        guess = ((Button) event.getSource()).getText().toLowerCase().charAt(0);

        //debug souts
        System.out.println(guess);
        System.out.println(game.checkGuess(guess));

        //check if the guess is correct
        if (game.checkGuess(guess)) {
            //change the color of keyboard button when the guess is correct
            ((Button) event.getSource()).setStyle("-fx-background-color: forestgreen");
            //update the UI with new guessed chars
            updaterLabel();

            //debug souts
            System.out.println(game.getFormalCurrentGuess());
            System.out.println("Is it guessed: " + game.isAlreadyGuessed());

            //when the whole mystery word is correctly guessed
            if (game.isAlreadyGuessed()) {
                gameover_label.setText("You Win!");
                gameover_label.setVisible(true);
                gameover_label.setStyle("-fx-text-fill: #007e1f");
            }
        }


        //if the char guess is not correct
        if (!(game.checkGuess(guess))) {

            //consume one try
            tries = tries + 1;
            //imageUrl variable updates based on try
            updateDrawingBasedOnCurrentTry();

            //debugging souts
            System.out.println(tries);
            System.out.println(imageUrl);

            //draw the hangman based on the try value, assign new image url to the imageView
            hangman_drawing.setImage(new Image(getClass().getResourceAsStream(imageUrl)));

            //set button style to red color to indicate the wrong guess
            ((Button) event.getSource()).setStyle("-fx-background-color: #ac3636");

            //check loss
            if (tries > maxTries) {
                //show loss msg
                gameover_label.setText("You lose!");
                gameover_label.setVisible(true);
                gameover_label.setStyle("-fx-text-fill: #8c2424");

                //after 5 sec the game will repeat with new word
                autoStartNewGame();

            }


        }


//        updaterLabel();


    }


    @FXML
    void pickAnotherWord(ActionEvent event) throws IOException {


        //reset the UI to new game state
        setKeyboardStyleToDefault();
        resetImageAndScore();


        //get new Mystery word and initialize the dashing replacement
        game.setMysteryWord(game.getNewMesteryWord());
        game.initCurrentGuess();


        //Debugging souts
        System.out.println(game.getMysteryWord());
        System.out.println(game.getFormalCurrentGuess());

        //update the dashed word with correct guessed chars
        updaterLabel();


    }


    //decides in which stage the game is based on tries consumed. update image url
    private void updateDrawingBasedOnCurrentTry() {
        switch (tries) {
            case 0 -> this.imageUrl = "/pngs/hangman/scaffold-0.png";
            case 1 -> this.imageUrl = "/pngs/hangman/scaffold-1.png";
            case 2 -> this.imageUrl = "/pngs/hangman/scaffold-2.png";
            case 3 -> this.imageUrl = "/pngs/hangman/scaffold-3.png";
            case 4 -> this.imageUrl = "/pngs/hangman/scaffold-4.png";
            case 5 -> this.imageUrl = "/pngs/hangman/scaffold-5.png";
            case 6 -> this.imageUrl = "/pngs/hangman/scaffold-6.png";

        }

    }


    //update lable in UI for the mystery dashed word
    public void updaterLabel() {


        label_mystery.setText(game.getFormalCurrentGuess());
    }


    //Reset keyboard style
    private void setKeyboardStyleToDefault() {
        Q.setStyle("-fx-background-color: #b8afaf;");
        W.setStyle("-fx-background-color: #b8afaf;");
        E.setStyle("-fx-background-color: #b8afaf;");
        R.setStyle("-fx-background-color: #b8afaf;");
        T.setStyle("-fx-background-color: #b8afaf;");
        Y.setStyle("-fx-background-color: #b8afaf;");
        U.setStyle("-fx-background-color: #b8afaf;");
        I.setStyle("-fx-background-color: #b8afaf;");
        O.setStyle("-fx-background-color: #b8afaf;");
        P.setStyle("-fx-background-color: #b8afaf;");
        A.setStyle("-fx-background-color: #b8afaf;");
        S.setStyle("-fx-background-color: #b8afaf;");
        D.setStyle("-fx-background-color: #b8afaf;");
        F.setStyle("-fx-background-color: #b8afaf;");
        G.setStyle("-fx-background-color: #b8afaf;");
        H.setStyle("-fx-background-color: #b8afaf;");
        J.setStyle("-fx-background-color: #b8afaf;");
        K.setStyle("-fx-background-color: #b8afaf;");
        L.setStyle("-fx-background-color: #b8afaf;");
        Z.setStyle("-fx-background-color: #b8afaf;");
        X.setStyle("-fx-background-color: #b8afaf;");
        C.setStyle("-fx-background-color: #b8afaf;");
        V.setStyle("-fx-background-color: #b8afaf;");
        B.setStyle("-fx-background-color: #b8afaf;");
        N.setStyle("-fx-background-color: #b8afaf;");
        M.setStyle("-fx-background-color: #b8afaf;");


    }

    //UI reset
    private void resetImageAndScore() {
        tries = -1;
        gameover_label.setText("");
        hangman_drawing.setImage(null);
    }


    //time line task that repeats the same sequence when picking new word , in other words reset the game with new word to guess
    private void autoStartNewGame() {

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), ev -> {
            System.out.println("This should happen 5 sec after the game over and only for one time ***");

            //reset the UI to new game state
            setKeyboardStyleToDefault();
            resetImageAndScore();


            //get new Mystery word and initialize the dashing replacement
            game.setMysteryWord(game.getNewMesteryWord());
            game.initCurrentGuess();


            //Debugging souts
            System.out.println(game.getMysteryWord());
            System.out.println(game.getFormalCurrentGuess());

            //update the dashed word lable in ui with correct guessed chars
            updaterLabel();
        }));
        timeline.setCycleCount(1);
        timeline.play();

    }





    public void saveCodeHereIfUDoNotNeedIt() {
        // letter_mystery.setText(((Button)event.getSource()).getText());


    }
}
