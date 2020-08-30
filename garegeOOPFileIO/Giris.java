package com.garegeOOPFileIO;

public class Giris implements IslemInterface {

    @Override
    public String islemSec(String islem, Garaj grj, int tip, String plaka) {

        Haberci hbrAl = new Haberci();

        if (aracAlan.get(tip) <= grj.getYer()) {
            int index = grj.aracBulGiris(tip, plaka);

            if (index == -1)
                return ("---------- Bu araç zaten garajda");

            else {
                grj.getAracList().add(new Araclar(tip, aracIsim.get(tip), aracAlan.get(tip), plaka));
                grj.setYer(grj.getYer() - aracAlan.get(tip));

                grj.ekle(hbrAl);

                grj.setAracList(grj.getAracList());
                grj.getAracListBefore().add(new Araclar(tip, aracIsim.get(tip), aracAlan.get(tip), plaka));

                return ("---------- Liste: " + grj.getAracList());
            }
        }
        else
            return ("---------- Otoparkta Yer Yok Önce Çıkış Yapılmalı... " + "Denenen: " + aracIsim.get(tip) + " - Kapladığı alan: " + aracAlan.get(tip) + " - Plaka: " + plaka);
    }
}
