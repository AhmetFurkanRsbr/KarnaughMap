import java.util.ArrayList;

public class Fonksiyon {

    static int fonksiyondakiDegiskenSayisi = 0;
    static int fonkisyondakiMintermSayisi = 0;
    static String fonksiyonIfadesi = "";

    static ArrayList mintermlerBinaryDeger = new ArrayList();
    static ArrayList fonksiyonBinary = new ArrayList<>();
    static ArrayList fonksiyonMintermler = new ArrayList<>();
    static ArrayList<String> fonksiyondakiDegiskenler = new ArrayList<String>();


    static void fonksiyondakiMintermSayisiHesapla() {
        int endIndex = 0;
        int i=0;
       do{

          if(fonksiyonIfadesi.contains("+")){
            endIndex = fonksiyonIfadesi.indexOf("+");

            fonksiyonMintermler.add(fonksiyonIfadesi.substring(0, endIndex));

            fonksiyonIfadesi = fonksiyonIfadesi.substring(endIndex + 1);
          }else{
            fonksiyonMintermler.add(fonksiyonIfadesi);
            fonksiyonIfadesi="";
          }
        System.out.println((i+1)+". ifade : " + fonksiyonMintermler.get(i));
          i++;

       }while (!fonksiyonIfadesi.equals(""));

      fonkisyondakiMintermSayisi = fonksiyonMintermler.size();

    }

    static void mintermBinaryFonksiyonaDonustur(String Ifade){

            char []ifade = Ifade.toCharArray();
            boolean dizideEksikElemanVar = false ;
            boolean dizideVar = true;

            if(ifade.length != fonksiyondakiDegiskenSayisi){
                dizideEksikElemanVar = true ;
            }else {
                dizideEksikElemanVar = false;
            }

            String anlikIfade= "";

            if(!dizideEksikElemanVar){
                for(int i=0;i<fonksiyondakiDegiskenSayisi;i++){
                    for(int m=0;m<ifade.length;m++) {
                        anlikIfade = String.valueOf(ifade[m]);
                        if (fonksiyondakiDegiskenler.get(i).equals(anlikIfade)) {
                            fonksiyonBinary.add(0);
                        } else if (fonksiyondakiDegiskenler.get(i).toUpperCase().equals(anlikIfade)) {
                            fonksiyonBinary.add(1);
                        }
                    }
                }

            }else{
                for(int i=0;i<fonksiyondakiDegiskenSayisi;i++) {

                    for(int k=0;k<ifade.length;k++) {
                     anlikIfade = String.valueOf(ifade[k]);
                    if (fonksiyondakiDegiskenler.get(i).toLowerCase().equals(anlikIfade)){
                        dizideVar = true;
                        fonksiyonBinary.add(0);
                        break;
                    } else if (fonksiyondakiDegiskenler.get(i).toUpperCase().equals(anlikIfade)) {
                        dizideVar = true;
                        fonksiyonBinary.add(1);
                        break;
                    } else {
                        dizideVar = false;
                    }
                  }
                    if(!dizideVar){
                        fonksiyonBinary.add("X");
                    }
                }
            }
    }

}
