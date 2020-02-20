package com.hashcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Manager {

    public static int NrBooks;
    public static int NrLib;
    public static int NrDays;
    public static ArrayList<Book> AllBooks = new ArrayList<>();
    public static ArrayList<Library> AllLibs = new ArrayList<>();
    public static final String A = "a_example";
    public static final String B = "b_read_on";
    public static final String C = "c_incunabula";
    public static final String D = "d_tough_choices";
    public static final String E = "e_so_many_books";
    public static final String F = "f_libraries_of_the_world";


    public static final String EXAMPLE = E;


//    public static void SortByDaysAllLibs(){
//        AllLibs.sort((h1, h2) -> Integer.compare(h1.Time, h2.Time));
//        System.out.println(AllLibs.size());
//    }

    public static void SortByDaysAllLibs(){
//        AllLibs.sort((h1, h2) -> Integer.compare(h2.totalScore, h1.totalScore));

        AllLibs.sort((h1, h2) -> Integer.compare(h2.NoOfBookPerDay, h1.NoOfBookPerDay));
        AllLibs.sort((h1, h2) -> Integer.compare(h2.totalScore, h1.totalScore));
        AllLibs.sort((h1, h2) -> Integer.compare(h1.Time, h2.Time));
        System.out.println(AllLibs.size());
    }



    public static void SortBookByIdInLib(Library library){
        library.Books.sort((h1, h2) -> Integer.compare(h2.score, h1.score));
        System.out.println(AllLibs.size());
    }

    public static void SortBooksInAllLibs(){
        for (Library l: AllLibs
             ) {
            SortBookByIdInLib(l);
        }
    }

    public static void Read(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/" + EXAMPLE + ".txt")); //TODO

            NrBooks = scanner.nextInt();
            NrLib = scanner.nextInt();
            NrDays = scanner.nextInt();
            String line = scanner.nextLine();
            line = scanner.nextLine();
            String[] splited = line.split(" ");
            int idBook = 0;
            for (String s: splited) {
                Book b = new Book();
                b.id = idBook++;
                b.score = Integer.parseInt(s);
                b.scaned = false;

                AllBooks.add(b);
            }

            int libraryIndex = 0;
            while(scanner.hasNextLine()){

                line = scanner.nextLine();
                if(line.isEmpty())
                    break;
                Library l = new Library();
                l.id = libraryIndex;
                libraryIndex++;
                splited = line.split(" ");
                l.NoOfBooks = Integer.parseInt(splited[0]);
                l.Time = Integer.parseInt(splited[1]);
                l.NoOfBookPerDay = Integer.parseInt(splited[2]);
                line = scanner.nextLine();
                splited = line.split(" ");
                for(int i =0; i< l.NoOfBooks;i++){
                    int pos = Integer.parseInt(splited[i]);
                    l.Books.add(AllBooks.get(pos));
                    l.totalScore = l.totalScore + AllBooks.get(pos).score;
                }
                AllLibs.add(l);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Read over.");
    }
}
