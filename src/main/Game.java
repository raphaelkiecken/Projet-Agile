package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.donjon.Donjon;
import main.donjon.DonjonGenerator;
import main.entity.Renaud;

public class Game {
    public final static String FILENAME_TEST = "Titlescreen.txt";
    public final static Renaud PLAYER = new Renaud();
    public final static DonjonGenerator DONJON_GENERATOR = new DonjonGenerator(new Donjon(), PLAYER);

    public static void main(String[] args) {
        /*
        System.out.println(FileLoader.load(FILENAME_TEST));
        String choice = readStringNotNull();
        if (choice.charAt(0) == 'b') {
            BestiaryLoader.load();
        }
        */
        DONJON_GENERATOR.drawDonjon();
    }

    public static String readStringNotNull(){
        String s = null;
        try{
            do{
                s = readString();
            }while(s == null);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return s;
    }

    public static String readString() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static void clearScreen(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
