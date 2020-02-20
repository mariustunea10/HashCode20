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
    public static final String A = "src/a_example.txt";
    public static final String B = "src/b_read_on.txt";
    public static final String C = "src/c_incunabula.txt";
    public static final String D = "src/d_tough_choices.txt";
    public static final String E = "src/e_so_many_books.txt";
    public static final String F = "src/f_libraries_of_the_world.txt";


    public static void SortByDaysAllLibs(){
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
            scanner = new Scanner(new File(F)); //TODO

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
                }
                AllLibs.add(l);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Read over.");
    }
}
