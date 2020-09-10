package se.ecutbildning.game_core;


import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Game {

    private static StringBuilder currentGuess;
    WordStreamer wordStreamer = new WordStreamer();
    private String mysteryWord;
    private ArrayList<Character >  previousGuesses =new ArrayList<>();


    public Game() throws FileNotFoundException {


        this.mysteryWord = wordStreamer.getRandomWord();
        initCurrentGuess();
    }















    // - - - a - - e
    //Dashing a word.
    public StringBuilder initCurrentGuess(){
        currentGuess = new StringBuilder();
        currentGuess.append("_".repeat(this.mysteryWord.length() / 2));
        return currentGuess;
    }


    //check if guess is equal to one of mystery word's chars

    public boolean checkGuess(char guess) {


        for (int i = 0; i < this.mysteryWord.length() ; i++) {

            if (this.mysteryWord.charAt(i) == guess) {

                this.previousGuesses.add(guess);
                currentGuess.setCharAt(i/2, guess);
                return true;
            }

        }


        return false;
    }


    //get formal current guess 'normal string'
    public String getFormalCurrentGuess(){
        return currentGuess.toString();
    }












































    //Getters And Setters
    public String getNewMesteryWord() {
        return wordStreamer.getRandomWord();
    }

    public void setMysteryWord(String mysteryWord) {
        this.mysteryWord = mysteryWord;
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

    public String getMysteryWord() {
        return mysteryWord;
    }
}
