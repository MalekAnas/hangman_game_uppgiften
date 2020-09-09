package se.ecutbildning.game_core;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordStreamer {


    private static final String fileName = "emgmix.txt";

    private ArrayList<String> words = new ArrayList<>();


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





    public String getRandomWord() {

        if (words.isEmpty())
            return "No_Data";

        return words.get((int) (Math.random() * words.size()));


    }



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




