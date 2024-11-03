public class Main{

    public static void main(String[] args) {
        boolean isProgramBitir = false;
        do {
            System.out.println("\n\n\n\t\tFonksiyonu (x,y,z) , (A,B,C,D) veya (0,1) lerden oluşturunuz.\n\n");


            Fonksiyon.fonksiyonIfadesi="";
            Fonksiyon.fonksiyondakiDegiskenler.clear();
            Fonksiyon.fonksiyonMintermler.clear();
            Fonksiyon.mintermlerBinaryDeger.clear();
            Fonksiyon.fonksiyonMintermler.clear();
            Fonksiyon.fonkisyondakiMintermSayisi=0;
            Fonksiyon.fonksiyondakiDegiskenSayisi=0;
            Fonksiyon.fonksiyonBinary.clear();
            KarnaughIcinMatris.sutunIndex=0;
            KarnaughIcinMatris.satirIndex=0;


            Girdiler.fonksiyondakiDegiskenSayisiniKullanicidanAl();
            Girdiler.fonksiyondakiDegiskenleriKullanicidanAl();

            Girdiler.fonksiyonuKullanicidanAl();

            Fonksiyon.fonksiyondakiMintermSayisiHesapla();
            Fonksiyon.mintermlerBinaryDeger.clear();
            int k = 0;
            for (int m = 0; m < Fonksiyon.fonkisyondakiMintermSayisi; m++) {
                Fonksiyon.mintermBinaryFonksiyonaDonustur(Fonksiyon.fonksiyonMintermler.get(m).toString());

                String mintermIfadesiBinary="";
                System.out.print(m + ". Minterm: ");
                while (k < Fonksiyon.fonksiyondakiDegiskenSayisi + Fonksiyon.fonksiyondakiDegiskenSayisi * m) {
                    System.out.print(Fonksiyon.fonksiyonBinary.get(k));
                    mintermIfadesiBinary += Fonksiyon.fonksiyonBinary.get(k).toString();
                    k++;
                }
                Fonksiyon.mintermlerBinaryDeger.add(mintermIfadesiBinary);
                System.out.println("\n");
            }
            KarnaughIcinMatris.matrisiOlustur();
            KarnaughIcinMatris.matristekiBirSayisiHesapla();
            KarnaughIcinMatris.matristekiFarketmezSayisiHesapla();
            new  KarnaughKuralinaGoreGrupla(KarnaughIcinMatris.karnaughMatris,KarnaughIcinMatris.satirSayisi,KarnaughIcinMatris.sutunSayisi,KarnaughIcinMatris.matristekiBirSayisi,KarnaughIcinMatris.matristekiFarketmezSayisi);
            isProgramBitir = !Girdiler.programBitirilsinMi();
        }while (!isProgramBitir);
    }

}