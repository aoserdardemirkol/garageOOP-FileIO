package com.garegeOOPFileIO;

import static com.garegeOOPFileIO.IslemInterface.putItems;

public class Islem {
    public static String islemSec(IslemInterface iI, String islem, Garaj grj, int tip, String plaka){
        putItems();

        return iI.islemSec(islem, grj, tip, plaka);
    }
}
