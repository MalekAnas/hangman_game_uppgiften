package se.ecutbildning.game_core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class WordStreamer {


    private static final String fileName = "emgmix.txt";

    private ArrayList<String> words = new ArrayList<>();


    //construct the class with a functionality of reading the txt file and storing the words to an arraylist "words"
    public WordStreamer() throws FileNotFoundException {


        File myfile = new File(fileName);

        String word = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("engmix.txt"))) {
            while ((word = bufferedReader.readLine()) != null) {
                words.add(word);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //to bring a random word
    public String getRandomWord() {

        if (words.isEmpty())
            return "No_Data";

        return words.get((int) (Math.random() * words.size()));


    }


    //for debugging
    public static void getFileInfo(String fileName) {
        File myObj = new File(fileName);
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
        } else {
            System.out.println("The file does not exist.");
        }
    }


}




