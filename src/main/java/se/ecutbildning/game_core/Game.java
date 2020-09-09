package se.ecutbildning.game_core;

import javafx.beans.binding.StringBinding;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Game {

    private static StringBuilder currentGuess;
    WordStreamer wordStreamer = new WordStreamer();
    private String mesteryWord = "";
    private ArrayList<Character >  previousGuesses =new ArrayList<>();


    public Game() throws FileNotFoundException {

    }

    public static void main(String[] args) throws IOException {


        Game game = new Game();

    }













    // - - - a - - e
    //Dashing a word.
    public StringBuilder initCurrentGuess(String str){
        currentGuess = new StringBuilder();
        for (int i = 0; i < str.length()/2 ; i++){

            currentGuess.append("_");
        }
        return currentGuess;
    }


    //check if guess is equal to one of mystery word's chars



    //get formal current guess 'normal string'
    public String getFormalCurrentGuess(){
        return currentGuess.toString();
    }












































    //Getters And Setters
    public String getMesteryWord() {
        return wordStreamer.getRandomWord();
    }

    public void setMesteryWord(String mesteryWord) {
        this.mesteryWord = mesteryWord;
    }

    public ArrayList<Character> getPreviousGuesses() {
        return previousGuesses;
    }

    public void setPreviousGuesses(ArrayList<Character> previousGuesses) {
        this.previousGuesses = previousGuesses;
    }


    public static StringBuilder getCurrentGuess() {
        return currentGuess;
    }


}
