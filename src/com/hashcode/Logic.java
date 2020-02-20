package com.hashcode;

import java.util.ArrayList;

public class Logic {

    static ArrayList<Library> libraryWorking = new ArrayList<>();

    public static void IterateStrategy1(){

        int i;
        int libToken = 0;
        for(i = 0; i < Manager.NrDays; i++){
            Library l = Manager.AllLibs.get(libToken);
            if(l.Time==0){
                libraryWorking.add(l);
                libToken++;
            }
            else{
                l.Time-=1;
            }
            DoWork();
        }
    }

    public static void DoWork(){
        for (Library l:libraryWorking) {
            l.
        }
    }
}
