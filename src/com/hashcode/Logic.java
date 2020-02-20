package com.hashcode;

import java.io.Console;
import java.util.ArrayList;

public class Logic {

    static ArrayList<Library> libraryWorking = new ArrayList<>();

    public static void IterateStrategy1(){

        int i;

        for(i = 0; i < Manager.NrDays; i++){
            if(Manager.AllLibs.size()>0){
                Library l = Manager.AllLibs.get(0);
                if(l.Time==0){
                    libraryWorking.add(l);
                    Manager.AllLibs.remove(0);
                }
                else{
                    l.Time-=1;
                }
            }

            DoWork();
        }
    }

    static int dayNo = 0;
    public static void DoWork(){
        System.out.println(dayNo++ + " din "+Manager.NrDays);
        for (Library l:libraryWorking) {
            int perDay = l.NoOfBookPerDay;
            for(int i = 0; i<perDay;i++)
            {
                if(l.Books.size()>0)
                {

                    Book b;
                    do{
                        b = l.Books.get(0);
                        l.Books.remove(0);
                    } while(l.Books.size() > 0 && b.scaned);
                    l.ScanBooks.add(b);
                    b.scaned = true;

                }
            }
        }
    }
}
