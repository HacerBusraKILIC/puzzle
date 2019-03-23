/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ScoreKayit {

    dosyaSec dosya = new dosyaSec();
    String kullanici = dosya.skullaniciAdi;
    static int skor = 0, yedek = 0;

    public void DosyayaEkle(int skor) {
        try {
            File dosya = new File("enyuksekskor.txt");
            FileWriter yazici = new FileWriter(dosya, true);
            BufferedWriter yaz = new BufferedWriter(yazici);
            yaz.write(kullanici + ",");
            yaz.write(skor + ",");
            yaz.newLine();
            yaz.close();
            System.out.println("Ekleme İşlemi Başarılı");
        } catch (Exception hata) {
            hata.printStackTrace();
        }
    }

    public void DosyaOku() throws FileNotFoundException, IOException {
        String str;
        String skorBilgi[] = new String[3];
        int skorBilgiSayac = 0, skor = 0;
        String yol = "enyuksekskor.txt";
        File file = new File(yol);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while ((str = reader.readLine()) != null) {
            //System.out.println(str);
            StringTokenizer st = new StringTokenizer(str, ",");
            while (st.hasMoreTokens()) {
                skorBilgi[skorBilgiSayac] = st.nextToken();
                if (skorBilgiSayac == 1) {
                    yedek = Integer.valueOf(skorBilgi[1]);
                    enYuksekSkor();
                }
                skorBilgiSayac++;
            }
            skorBilgiSayac = 0;
        }
        System.out.println("skor:" + skor);
    }
    
    public static int enYuksekSkor() {
        if (skor < yedek) {
            skor = yedek;
        }
        return skor;
    }
}
