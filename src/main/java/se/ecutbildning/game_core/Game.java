package se.ecutbildning.game_core;


import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Game {

    private static StringBuilder currentGuess;
    WordStreamer wordStreamer = new WordStreamer();
    private String mysteryWord;
    private ArrayList<Character> previousGuesses = new ArrayList<>();

    private int tries = -1;


    public Game() throws FileNotFoundException {


        this.mysteryWord = wordStreamer.getRandomWord();
        initCurrentGuess();
    }


    // - - - a - - e
    //Dashing a word.
    public StringBuilder initCurrentGuess() {
        currentGuess = new StringBuilder();
       for (int i = 0; i < this.mysteryWord.length() *2 ;i ++){
           if (i % 2 == 0){
               currentGuess.append("_");
           }
           else {
               currentGuess.append(" ");           }
       }
        return currentGuess;
    }


    //check if guess is equal to one of mystery word's chars

    public boolean checkGuess(char guess) {


        boolean returnValue = false;
        for (int i = 0; i < this.mysteryWord.length(); i++) {

            if (this.mysteryWord.charAt(i) == guess) {


                this.previousGuesses.add(guess);
                currentGuess.setCharAt(i * 2, guess);
                returnValue = true;
            }


        }

        return returnValue;

    }


    //check if the whole word is guessed
    public boolean isAlreadyGuessed() {


        //TODO
        //delete after testing
        System.out.println("Guessed: " + getFormalCurrentGuess());
        System.out.println("Mystery word: " + this.mysteryWord);
        System.out.println("guessed word length: " + getFixedString().length());
        System.out.println("Mystery word length: " + this.mysteryWord.length());

        boolean returnValue = false;
        if (getFixedString().equals(this.mysteryWord)) {
            returnValue = true;
        }




        return returnValue;
    }
//
//
//    //replace guessed letters
//    private void replaceGuessedLetter(){
//        for (char c: previousGuesses) {
//
//            for (char letter: mysteryWord.toCharArray() ) {
//
//                if (c == letter){
//                    currentGuess.
//                }
//            }
//        }
//    }

    //get formal current guess 'normal string'
    public String getFormalCurrentGuess() {
        return currentGuess.toString();
    }

    public String getFixedString(){
        String guessedWord = getFormalCurrentGuess();
        return guessedWord.replace(" ", "" );
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
