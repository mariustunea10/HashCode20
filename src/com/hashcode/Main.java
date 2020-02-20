package com.hashcode;

import java.io.Console;

public class Main {

    public static void main(String[] args) {

        Manager.Read();
        Manager.SortByDaysAllLibs();
        System.out.println("SortByDaysAllLibs over");
        Manager.SortBooksInAllLibs();
        System.out.println("SortBooksInAllLibs over");
        Logic.IterateStrategy1();
        System.out.println("IterateStrategy1 over");
        WriterInFile.Write();
    }
}
