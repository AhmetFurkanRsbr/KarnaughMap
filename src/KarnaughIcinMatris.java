import java.util.ArrayList;
import java.util.Arrays;

public class KarnaughIcinMatris {
    static int degiskenSayisi=2;
    static   int satirSayisi=2;
    static int sutunSayisi =0;
    static int toplamOlusacakKutuSayisi=2;
    static int satirBasligindakiBitSayisi=1;
    static   int sutunBasligindakiBitSayisi=1;
    static int satirIndex=0;
    static   int sutunIndex=0;
    static  int matristekiBirSayisi=0;
    static  int matristekiFarketmezSayisi=0;

    static int anlikMintermSatirdakiEksikSayisi =0;
    static int anlikMintermSutundakiEksikSayisi =0;

    static String sutundakiDegerlerString = "";
    static String bitiTamamlayacak0lar = "";
    static String satirdanDolayiGerekliBosluk = "";
    static String sutundanDolayiGerekliBosluk = "";

    static   int []birBitliBinaryGrayKod = {0,1};
    static   int []ikiBitliBinaryGrayKod = {0,1,3,2};
    static   int []ucBitliBinaryGrayKod = {0,1,3,2,6,7,5,4};
    static   int []dortBitliBinaryGrayKod = {0,1,3,2,6,7,5,4,13,15,14,10,11,9,8};
    static   int []besBitliBinaryGrayKod= {0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8, 24, 25, 27, 26, 30, 31, 29, 28, 20, 21, 23, 22, 18, 19, 17, 16};
    static   int []altiBitliBinaryGrayKod = {0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8, 24, 25, 27, 26, 30, 31, 29, 28, 20, 21, 23, 22, 18, 19, 17, 16, 48, 49, 51, 50, 54, 55, 53, 52, 60, 61, 63, 62, 58, 59, 57, 56, 40, 41, 43, 42, 46, 47, 45, 44, 36, 37, 39, 38, 34, 35, 33, 32};
    static   int []aktifBitGrayKod = new int[40];

    static  String [][]karnaughMatris ;
    static  String [][]karnaughMatrisBasliklar ;

    static ArrayList<Integer>farketmezSatirIndexleri = new ArrayList<>();
    static ArrayList<Integer>farketmezSutunIndexleri = new ArrayList<>();

    static String []matrisSatirdakiDegiskenSiralamasi ;
    static String []matrisSutundakiDegiskenSiralamasi ;
    static String[][] basliklarinFarketmeziYokEdilmisHali ;

    public static void matrisinSatirlariniAyarlaDiziyeAktar(String sutunBasligiString,String satirBasligiString,ArrayList satirBasliklari,ArrayList sutunBasliklari){

        int baslangicIndex=0;
        int sonIndex=sutunBasligindakiBitSayisi;
        String matrisIcinSutunBasligiBosluksuzString =sutunBasligiString.trim().replaceAll("\\s+","");

        for(int k=0;k<sutunSayisi;k++){
            karnaughMatrisBasliklar[0][k]=matrisIcinSutunBasligiBosluksuzString.substring(baslangicIndex,sonIndex);
            //karnaughMatris[0][k]=matrisIcinSutunBasligiBosluksuzString.substring(baslangicIndex,sonIndex);
            baslangicIndex += sutunBasligindakiBitSayisi;
            sonIndex += sutunBasligindakiBitSayisi;
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        baslangicIndex=0;
        sonIndex=satirBasligindakiBitSayisi;
        String matrisIcinSatirBasligiBosluksuzString =satirBasligiString.trim().replaceAll("\\s+","");

        for(int k=0;k<satirSayisi;k++){
            //karnaughMatrisBasliklar[k][0]=satirBasliklari.get(k).toString().trim();
            karnaughMatrisBasliklar[k+1][0]=matrisIcinSatirBasligiBosluksuzString.substring(baslangicIndex,sonIndex);
            //karnaughMatris[k][0]=matrisIcinSatirBasligiBosluksuzString.substring(baslangicIndex,sonIndex);
            baslangicIndex += satirBasligindakiBitSayisi;
            sonIndex += satirBasligindakiBitSayisi;
        }
    }

    public static void mintermdekiOlmayaniBulAyarla(String mintermSatirDegiskenDegeri,String mintermSutunDegiskenDegeri,String[][]karnaughMatrisBasliklar){
        anlikMintermSatirdakiEksikSayisi =0;
        anlikMintermSutundakiEksikSayisi =0;

        String  satirEksiklerXYokEdilmisHali="";
        String  sutunEksiklerXYokEdilmisHali="";
        ArrayList<Integer> eksikSatirIndexleri = new ArrayList<>();
        ArrayList<Integer> eksikSutunIndexleri = new ArrayList<>();

        String[][] basliklarinEksigiYokEdilmisHali = new String[satirSayisi+1][sutunSayisi];
        //Geçici diziye matrisin başlık değerlerinin aktarılması
        for(int f=0;f<satirSayisi+1;f++){
            for(int k=0;k<sutunSayisi;k++){
                if(f==0 || k==0){
                    basliklarinEksigiYokEdilmisHali[f][k] = karnaughMatrisBasliklar[f][k];
                }
            }
        }

        farketmezSatirIndexleri.clear();
        farketmezSutunIndexleri.clear();
        eksikSatirIndexleri.clear();
        eksikSutunIndexleri.clear();

        int ifadeIndex=0;
       //Mintermin satırında hangi indislerinde farketmez olduğunu belirler
        //Ve hangi indiste olduğunu diziye ekler
        while ((ifadeIndex = mintermSatirDegiskenDegeri.indexOf("X",ifadeIndex)) != -1) {
            anlikMintermSatirdakiEksikSayisi++;
            eksikSatirIndexleri.add(ifadeIndex);
            ifadeIndex += "X".length();
        }
        ifadeIndex=0;
        //Verilen mintermin sütunlarında kaç tane farketmez olduğunu hesaplar.
        //Ve hangi indiste olduğunu diziye ekler
        while ((ifadeIndex = mintermSutunDegiskenDegeri.indexOf("X",ifadeIndex)) != -1) {
            anlikMintermSutundakiEksikSayisi++;
            eksikSutunIndexleri.add(ifadeIndex);
            //System.out.println("sutun ifade ındekss: "+ifadeIndex+ "  -- sonuç : "+mintermSutunDegiskenDegeri.indexOf("X",ifadeIndex));
            ifadeIndex += "X".length();
        }

        //Satırdaki eksik elemanları satır ifadesinden çıkarır.
        int baslangicIndex=-1;
        int sonIndex=0;
        if(anlikMintermSatirdakiEksikSayisi == mintermSatirDegiskenDegeri.length()) {
            eksikSatirIndexleri.clear();
            for(int f=0;f<satirSayisi;f++){
                eksikSatirIndexleri.add(f);
            }
            satirEksiklerXYokEdilmisHali="";
        }else if(anlikMintermSatirdakiEksikSayisi > 0) {
            //System.out.println("h: " + eksikSatirIndexleri.size()+ " hs: " + anlikMintermSatirdakiEksikSayisi);
            for (int h = 0; h < anlikMintermSatirdakiEksikSayisi; h++) {
                sonIndex = eksikSatirIndexleri.get(h);
                //System.out.println("sonıSatir: " + sonIndex + " minDegiSatir: " + mintermSatirDegiskenDegeri);
                if(sonIndex==0 && mintermSatirDegiskenDegeri.length()>1){
                    satirEksiklerXYokEdilmisHali = mintermSatirDegiskenDegeri.substring(sonIndex+1);
                }else if(mintermSatirDegiskenDegeri.length()-1>=sonIndex){
                    satirEksiklerXYokEdilmisHali = mintermSatirDegiskenDegeri.substring(baslangicIndex+1, sonIndex);
                }else if(!(mintermSatirDegiskenDegeri.length()<sonIndex)){
                    satirEksiklerXYokEdilmisHali += mintermSatirDegiskenDegeri.substring(sonIndex+1);
                }
                //System.out.println("farketmez silinmiş şuanki hali " + satirEksiklerXYokEdilmisHali);

                //Satır başlıklarından da aynı indislerin silinmesi
                //System.out.println("ss: "+satirSayisi+" sq:"+basliklarinEksigiYokEdilmisHali.length);
                for(int m=1;m<satirSayisi+1;m++){
                    String baslikGeciciIfade="";
                    for(int k=0;k<eksikSatirIndexleri.size();k++){

                        baslangicIndex=-1;
                        sonIndex=eksikSatirIndexleri.get(k);
                        baslikGeciciIfade = basliklarinEksigiYokEdilmisHali[m][0].substring((baslangicIndex+1),sonIndex);

                        //eğer ifadenin devamı varsa sonuna ekle
                        if(sonIndex<=mintermSatirDegiskenDegeri.length()-2){
                            baslikGeciciIfade += basliklarinEksigiYokEdilmisHali[m][0].substring(sonIndex+1);
                        }
                       // System.out.println("Eklenen: "+basliklarinEksigiYokEdilmisHali[m][0]);
                    }
                    basliklarinEksigiYokEdilmisHali[m][0]=baslikGeciciIfade;
               }

                baslangicIndex = sonIndex;
            }
        }else{
            //Eğer Minterm  satır ifadesinde eksik değişken yoksa eksikler yok edilmiş hali direkt mintermsatır haline eşittir.
            satirEksiklerXYokEdilmisHali = mintermSatirDegiskenDegeri;
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Sütundaki eksik elemanları satır ifadesinden çıkarır.
        baslangicIndex=-1;
        sonIndex=0;
        if(anlikMintermSutundakiEksikSayisi == mintermSutunDegiskenDegeri.length()) {
            eksikSutunIndexleri.clear();
            for(int f=0;f<sutunSayisi;f++){
                eksikSutunIndexleri.add(f);
            }
            sutunEksiklerXYokEdilmisHali="";
        }else if(anlikMintermSutundakiEksikSayisi > 0) {
            System.out.println("f: " + eksikSutunIndexleri.size()+ " fs: " + anlikMintermSutundakiEksikSayisi);
            for (int h = 0; h < anlikMintermSutundakiEksikSayisi; h++) {
                sonIndex = eksikSutunIndexleri.get(h);
                //System.out.println("sonı: " + sonIndex + " minDegi: " + mintermSutunDegiskenDegeri);
                if(sonIndex==0 && mintermSutunDegiskenDegeri.length()>1){
                    sutunEksiklerXYokEdilmisHali = mintermSutunDegiskenDegeri.substring(sonIndex+1);
                }else if(mintermSutunDegiskenDegeri.length()-1>=sonIndex){
                    sutunEksiklerXYokEdilmisHali = mintermSutunDegiskenDegeri.substring(baslangicIndex+1, sonIndex);
                }else if(!(mintermSutunDegiskenDegeri.length()<sonIndex)){
                    sutunEksiklerXYokEdilmisHali += mintermSutunDegiskenDegeri.substring(sonIndex+1);
                }
                //System.out.println("farketmez silinmiş şuanki hali " + sutunEksiklerXYokEdilmisHali);

                //Sütun başlıklarından da aynı indislerin silinmesi
                //System.out.println("ss: "+sutunSayisi+" sq:"+basliklarinEksigiYokEdilmisHali.length);
                for(int m=0;m<sutunSayisi;m++){
                    String baslikGeciciIfade="";
                    for(int k=0;k<eksikSutunIndexleri.size();k++){

                        baslangicIndex=-1;
                        sonIndex=eksikSutunIndexleri.get(k);
                        //System.out.println("bs:"+basliklarinEksigiYokEdilmisHali[0][m]+" BASı: " +(baslangicIndex+1)+ "  sonI: "+sonIndex);

                        baslikGeciciIfade = basliklarinEksigiYokEdilmisHali[0][m].substring((baslangicIndex+1),sonIndex);

                        //eğer ifadenin devamı varsa sonuna ekle
                        if(sonIndex<=mintermSatirDegiskenDegeri.length()-2){
                            baslikGeciciIfade += basliklarinEksigiYokEdilmisHali[0][m].substring(sonIndex+1);
                        }
                        //System.out.println("Eklenen: "+basliklarinEksigiYokEdilmisHali[0][m]);
                    }
                    basliklarinEksigiYokEdilmisHali[0][m]=baslikGeciciIfade;
                }

                baslangicIndex = sonIndex;
            }
        }else{
            //Eğer Minterm  sütun ifadesinde eksik değişken yoksa eksikler yok edilmiş hali direkt mintermsutun haline eşittir.
            sutunEksiklerXYokEdilmisHali = mintermSutunDegiskenDegeri;
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        eksikSatirIndexleri.clear();
        eksikSutunIndexleri.clear();

        if(anlikMintermSatirdakiEksikSayisi == mintermSatirDegiskenDegeri.length()) {
            for(int f=0;f<satirSayisi;f++){
                eksikSatirIndexleri.add(f);
            }
            for(int t=1;t<satirSayisi+1;t++){
                basliklarinEksigiYokEdilmisHali[t][0]="";
            }
        }//else {
            //Satır olarak doğru konum bulma
            for (int k = 1; k < satirSayisi + 1; k++) {
                //System.out.println("baslik matris: " + basliklarinEksigiYokEdilmisHali[k][0] + "   satirHali:  " + satirEksiklerXYokEdilmisHali);
                if (basliklarinEksigiYokEdilmisHali[k][0].equals(satirEksiklerXYokEdilmisHali)) {
                    eksikSatirIndexleri.add(k - 1);
                }
                //-------------------------------
            }
       // }
        if(anlikMintermSutundakiEksikSayisi == mintermSutunDegiskenDegeri.length()) {
            for(int f=0;f<sutunSayisi;f++){
                eksikSutunIndexleri.add(f);
            }
            sutunEksiklerXYokEdilmisHali="";
            for(int t=0;t<sutunSayisi;t++){
                basliklarinEksigiYokEdilmisHali[0][t]="";
            }
        }//else{
        //Sütun olarak doğru konumu bulma
          for(int k=0;k<sutunSayisi;k++){
             //System.out.println("baslik matris: "+ basliklarinEksigiYokEdilmisHali[0][k]+"   sutunHali:  "+sutunEksiklerXYokEdilmisHali);
             if(basliklarinEksigiYokEdilmisHali[0][k].equals(sutunEksiklerXYokEdilmisHali)){
                eksikSutunIndexleri.add(k);
             }
          }
       //}
        //System.out.println("satir: "+eksikSatirIndexleri.size()+"-- sutun: "+eksikSutunIndexleri.size() );
        for(int f=0;f<eksikSatirIndexleri.size();f++){
            for(int m=0;m<eksikSutunIndexleri.size();m++){
                karnaughMatris[eksikSatirIndexleri.get(f)][eksikSutunIndexleri.get(m)]="1";
                //karnaughMatris[eksikSatirIndexleri.get(f)][eksikSutunIndexleri.get(m)]="1X";
                //System.out.println("1x eklenecek satir: "+eksikSatirIndexleri.get(f)+"-- 1x eklenecek sutun: "+eksikSutunIndexleri.get(m) );
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void matriseVerileriYerlestir(){
        //Matrisin değişkenlerin karşılaştırılması için satır ve sütun değişkenlerini tutacak olan dizilerin değişken sayısına göre oluşturulması.
        matrisSatirdakiDegiskenSiralamasi = new String[satirBasligindakiBitSayisi];
        matrisSutundakiDegiskenSiralamasi = new String[sutunBasligindakiBitSayisi];
        //---------------
        //Dizilere değişken isimlerinin atanması.
        int h=0;
        for(h=0;h<satirBasligindakiBitSayisi;h++){
            matrisSatirdakiDegiskenSiralamasi[h]=Fonksiyon.fonksiyondakiDegiskenler.get(h);
        }

        for(int k=0;k<satirBasligindakiBitSayisi;k++){
            matrisSutundakiDegiskenSiralamasi[k]=Fonksiyon.fonksiyondakiDegiskenler.get(h);
            h++;
        }
        //---------------
        //Minterm ifadenin binary değerine göre matrisin uygun olan indexi bulma.
        for(Object binaryMinterm:Fonksiyon.mintermlerBinaryDeger) {
            String mintermDegiskenDegeri = "";
            String mintermSatirDegiskenDegeri = "";
            String mintermSutunDegiskenDegeri = "";
            satirIndex = 0;
            sutunIndex = 0;
            anlikMintermSatirdakiEksikSayisi = 0;
            anlikMintermSutundakiEksikSayisi = 0;

            int ifadeIndex = 0;

            int m = 0;
            //Satır olarak doğru konumu bulma
            mintermSatirDegiskenDegeri = binaryMinterm.toString().substring(0, satirBasligindakiBitSayisi);
            mintermSutunDegiskenDegeri = binaryMinterm.toString().substring(satirBasligindakiBitSayisi);

            if (mintermSatirDegiskenDegeri.contains("X") || mintermSutunDegiskenDegeri.contains("X")) {
                //System.out.println("++SATIR: " + mintermSatirDegiskenDegeri + "    SÜTUN:  " + mintermSutunDegiskenDegeri);
                mintermdekiOlmayaniBulAyarla(mintermSatirDegiskenDegeri, mintermSutunDegiskenDegeri, karnaughMatrisBasliklar.clone());
            }else {

                for (int k = 0; k < satirSayisi; k++) {
                    if (karnaughMatrisBasliklar[k + 1][0].equals(mintermSatirDegiskenDegeri)) {
                        satirIndex = k;
                        break;
                    } else {
                        continue;
                    }
                }
                //-------------------------------
                //Sütun olarak doğru konumu bulma
                for (int k = 0; k < sutunSayisi; k++) {
                    if (karnaughMatrisBasliklar[0][k].equals(mintermSutunDegiskenDegeri)) {
                        sutunIndex = k;
                        break;
                    } else {
                        continue;
                    }
                }

                //-------------------------------
                System.out.println("bu mintermin indisi: " + satirIndex + "  ->  " + sutunIndex);

                karnaughMatris[satirIndex][sutunIndex] = "1";

            }

        }
        /*
        System.out.print("satır index: ");
        for (Integer satirEleman:farketmezSatirIndexleri){
            System.out.print(" "+satirEleman.toString());
        }

        //System.out.print("\nsutun index: ");
        for (Integer sutunEleman: farketmezSutunIndexleri){
            System.out.print(" "+sutunEleman.toString());
        }
        */

        System.out.println("\n-------------------\n\n\n\n");
        String matrisCizgisi="";
        for(int m=0;m<satirBasligindakiBitSayisi+2;m++){
            System.out.print(" ");
        }
        for(int l=0;l<satirSayisi;l++){
            if(l==0){
                for(int k=0;k<sutunSayisi;k++){
                    System.out.print(""+karnaughMatrisBasliklar[0][k]+" ");
                }
                System.out.println();
                matrisCizgisi=satirdanDolayiGerekliBosluk;
                for(int m=0;m<sutunBasligindakiBitSayisi*(Math.pow(2,sutunBasligindakiBitSayisi+1));m++){
                  matrisCizgisi +="-";
                }
                System.out.println(matrisCizgisi);
            }

            for(int j=0;j<sutunSayisi;j++){
                if(j==0){
                     System.out.print(karnaughMatrisBasliklar[l+1][0]);
                }
                System.out.print(" | "+karnaughMatris[l][j]);
            }
            System.out.println(" |");
        }
        System.out.println(matrisCizgisi);
    }

    public static void matrisiOlustur(){

            ArrayList satirBasliklari = new ArrayList();
            ArrayList sutunBasliklari = new ArrayList();

                degiskenSayisi=Fonksiyon.fonksiyondakiDegiskenSayisi;
                toplamOlusacakKutuSayisi = (int) Math.pow(2, degiskenSayisi);

               if(degiskenSayisi%2==0) {
                   satirSayisi=degiskenSayisi;
               }else{
                    satirSayisi = (int) Math.pow(2,((degiskenSayisi-1)/2));
               }
               sutunSayisi = toplamOlusacakKutuSayisi / satirSayisi;

            satirBasligindakiBitSayisi =Integer.toBinaryString(satirSayisi-1).length();
            sutunBasligindakiBitSayisi = Integer.toBinaryString(sutunSayisi-1).length();


            karnaughMatris = new String[satirSayisi][sutunSayisi];
            karnaughMatrisBasliklar = new String[satirSayisi+1][sutunSayisi];

            for(int f=0;f<satirSayisi;f++){
                for(int d=0;d<sutunSayisi;d++){
                     karnaughMatris[f][d]="0";
                }
            }

             sutundakiDegerlerString = "";
             bitiTamamlayacak0lar = "";
             satirdanDolayiGerekliBosluk = "";
             sutundanDolayiGerekliBosluk = "";


            for(int m=0;m<satirBasligindakiBitSayisi+3;m++){
                satirdanDolayiGerekliBosluk +=" ";
            }
            for(int m=0;m<sutunBasligindakiBitSayisi+1;m++){
                sutundanDolayiGerekliBosluk +=" ";
            }

            if(sutunBasligindakiBitSayisi==1){
                //System.out.println("sutundaki bit sayısı  bir");
                aktifBitGrayKod = birBitliBinaryGrayKod ;
            } else if(sutunBasligindakiBitSayisi==2){
                //System.out.println("sutundaki bit sayısı  iki");
                aktifBitGrayKod = ikiBitliBinaryGrayKod ;
            } else if (sutunBasligindakiBitSayisi==3) {
                //System.out.println("sutundaki bit sayısı  üç");
                aktifBitGrayKod = ucBitliBinaryGrayKod ;
            } else if (sutunBasligindakiBitSayisi==4) {
                //System.out.println("sutundaki bit sayısı dört");
                aktifBitGrayKod = dortBitliBinaryGrayKod ;
            } else if (sutunBasligindakiBitSayisi==5) {
                //System.out.println("sutundaki bit sayısı beş");
                aktifBitGrayKod = besBitliBinaryGrayKod ;
            } else if (sutunBasligindakiBitSayisi==6) {
                //System.out.println("sutundaki bit sayısı altı");
                aktifBitGrayKod = altiBitliBinaryGrayKod ;
            }


            sutundakiDegerlerString += satirdanDolayiGerekliBosluk;

                  for (int f=0;f<sutunSayisi;f++) {

                      if (Integer.toBinaryString(aktifBitGrayKod[f]).length() < sutunBasligindakiBitSayisi) {
                          bitiTamamlayacak0lar = "";
                          for (int k = 0; k < sutunBasligindakiBitSayisi - Integer.toBinaryString(aktifBitGrayKod[f]).length(); k++) {
                              bitiTamamlayacak0lar += "0";
                          }
                          sutundakiDegerlerString += bitiTamamlayacak0lar;

                          sutundakiDegerlerString += Integer.toBinaryString(aktifBitGrayKod[f]);
                      } else {

                          sutundakiDegerlerString += Integer.toBinaryString(aktifBitGrayKod[f]);
                      }
                      sutunBasliklari.add(sutundakiDegerlerString.trim());
                      sutundakiDegerlerString = "";

                  }

            String satirdakiDegerlerString = "";
            bitiTamamlayacak0lar = "";

            for (int f=0;f<satirSayisi;f++){
                if(Integer.toBinaryString(aktifBitGrayKod[f]).length()<satirBasligindakiBitSayisi){
                    bitiTamamlayacak0lar="";
                    for(int k=0;k<satirBasligindakiBitSayisi - Integer.toBinaryString(aktifBitGrayKod[f]).length();k++){
                        bitiTamamlayacak0lar += "0";
                    }
                    satirdakiDegerlerString += bitiTamamlayacak0lar;

                    satirdakiDegerlerString += Integer.toBinaryString(aktifBitGrayKod[f]);

                }else {
                    satirdakiDegerlerString += Integer.toBinaryString(aktifBitGrayKod[f]);
                }
                satirBasliklari.add(satirdakiDegerlerString);
                satirdakiDegerlerString="";
            }
            satirdanDolayiGerekliBosluk = "";
            for(int m=0;m<sutunBasligindakiBitSayisi+1;m++){
                satirdanDolayiGerekliBosluk +=" ";
            }
            sutundakiDegerlerString +=satirdanDolayiGerekliBosluk;

                int [][]binaryMatris= new int[satirSayisi][sutunSayisi];

                for(int m=0;m<satirSayisi;m++){
                    for(int k=0;k<sutunSayisi;k++){
                        binaryMatris[m][k]=0;
                    }
                }

                      String sutunBasligiString="";
                   for (Object sutunBasligi:sutunBasliklari) {
                       sutunBasligiString += sutunBasligi.toString().trim() + "  ";
                   }
                   String satirBasligiString="";
                   for(int m=0;m<satirSayisi;m++){
                       satirBasligiString +=satirBasliklari.get(m).toString();
                   }
              //////////////////////////////////////////

            matrisinSatirlariniAyarlaDiziyeAktar(sutunBasligiString,satirBasligiString,satirBasliklari,sutunBasliklari);
            matriseVerileriYerlestir();

            /////////////////////////////////
    }
    public static int matristekiBirSayisiHesapla(){
        matristekiBirSayisi=0;
        for(int k=0;k<satirSayisi;k++){
            for(int j=0;j<sutunSayisi;j++){
              if(karnaughMatris[k][j].equals("1")){
                  matristekiBirSayisi++;
              }
            }
        }
        return matristekiBirSayisi;
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    public static int matristekiFarketmezSayisiHesapla(){
        matristekiFarketmezSayisi=0;
        for(int k=0;k<satirSayisi;k++){
            for(int j=0;j<sutunSayisi;j++){
                if(karnaughMatris[k][j].equals("X")){
                    matristekiFarketmezSayisi++;
                }
            }
        }
        return matristekiFarketmezSayisi;
    }

}
