package com.garegeOOPFileIO;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Main {
    public static int garajBoyut;
    public static int aracTipi;
    public static String plaka;
    public static String islemDonus;

    public static void main(String[] args) throws Exception {
        acilisyazilariniYaz();

        File file = new File("C:\\Users\\Ali Osman Demirkol\\IdeaProjects\\javaOOP\\src\\com\\garegefileOOP\\garajText.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        Scanner giris = new Scanner(reader);
        Scanner klavye = new Scanner(System.in);

        while (true) {
            System.out.print("---------- Garaj Boyutunu Giriniz: ");
            garajBoyut = klavye.nextInt();

            if (garajBoyut >= 5 && garajBoyut <= 50)
                break;
            else
                System.out.println("---------- Garaj Boyutu 5 ile 50 arasında olmalıdır...");
        }

        Garaj grj = new Garaj(garajBoyut);

        // Başlangıçta txt dosyasındaki değerleri ekledik
        while (giris.hasNext() && giris.next().equalsIgnoreCase("G")) {
            int tip = giris.nextInt();
            String plaka = giris.nextLine();
            String islemDonus = Islem.islemSec(new Giris(), "g", grj, tip, plaka);
            System.out.println(islemDonus);
        }

        while (true) {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);

            System.out.print("---------- Araç Girişi için 'G' Araç Çıkışı için 'C' Araçları Listelemek için 'L' Kapatmak için 'K': ");

            String islem = klavye.next();

            String[] ayir = islem.split("-");
            String islemTipi = ayir[0].toUpperCase();

            if (ayir.length > 1) {
                aracTipi = parseInt(ayir[1]);
                plaka = ayir[2].toUpperCase();
            }

            if (islemTipi.equals("G")) {
                islemDonus = Islem.islemSec(new Giris(), islemTipi, grj, aracTipi, plaka);
                System.out.println(islemDonus);

                // txt dosyasına ekleme
                if (!islemDonus.equals("---------- Bu araç zaten garajda")) {
                    bWriter.write("\n" + islemTipi + " " + aracTipi + " " + plaka);
                    bWriter.close();
                }
            } else if (islemTipi.equals("C")) {
                islemDonus = Islem.islemSec(new Cikis(), islemTipi, grj, aracTipi, plaka);
                System.out.println(islemDonus);

                String sil = "G" + " " + aracTipi + " " + plaka;

                // txt dosyasında belirli bir satırı silme
                if (!islemDonus.equals("---------- Bu araç zaten garajda")) {
                    List<String> out = Files.lines(file.toPath())
                            .filter(line -> !line.contains(sil))
                            .collect(Collectors.toList());
                    Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
                }
            } else if (islemTipi.equals("L")) {
                islemDonus = Islem.islemSec(new Liste(), islemTipi, grj, aracTipi, plaka);
                System.out.println(islemDonus);
            } else if (islemTipi.equals("K"))
                break;
        }
    }

    static void acilisyazilariniYaz() {
        System.out.println("-------------------- Garaj Console App --------------------");
        System.out.println("---------------------- Giriş Tipleri ----------------------");
        System.out.println("---------- Tip 1: 'Bisiklet'    Kapladığı Alan: '1' -------");
        System.out.println("---------- Tip 2: 'Motorsiklet' Kapladığı Alan: '1' -------");
        System.out.println("---------- Tip 3: 'Araba'       Kapladığı Alan: '2' -------");
        System.out.println("---------- Tip 4: 'Kamyonet'    Kapladığı Alan: '3' -------");
        System.out.println("---------- Tip 5: 'Otobüs'      Kapladığı Alan: '5' -------");
        System.out.println("---------- Tip 6: 'Tır'         Kapladığı Alan: '8' -------");
        System.out.println("-----------------------------------------------------------");
        System.out.println("---------- Örnek Giriş: 'g-3-43UK622' || 'G-3-43UK622' ----");
        System.out.println("-----------------------------------------------------------");
    }
}