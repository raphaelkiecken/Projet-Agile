package main;

import main.file.FileLoader;

public class MonsterView {
    public static void main(String[] args) {
        System.out.println(FileLoader.load("crs.txt"));
        System.out.println(FileLoader.load("ARS.txt"));

    }
}