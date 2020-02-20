package com.hashcode;

import java.io.FileWriter;
import java.io.IOException;

public class WriterInFile {
    public static void Write(){
        try {
            FileWriter myWriter = new FileWriter(Manager.EXAMPLE + "_out.txt");

            String toWrite = "";
//            myWriter.write(Logic.libraryWorking.size()+"\n");
//            for (Library l : Logic.libraryWorking) {
//                myWriter.write(l.id+ " " + l.ScanBooks.size()+"\n");
//
//                myWriter.
//            }

             toWrite+= Logic.libraryWorking.size()+"\n";

            for (Library l : Logic.libraryWorking) {
                toWrite+= l.id+ " " + l.ScanBooks.size()+"\n";
                for (Book b : l.ScanBooks) {
                    toWrite += b.id + " ";
                }
                toWrite += "\n";
            }

            myWriter.write(toWrite);
            myWriter.close();

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
