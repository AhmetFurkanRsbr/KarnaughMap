import java.util.Scanner;

public class Girdiler {
   public static boolean isHataYok=true;

    static void fonksiyonuKullanicidanAl(){
        Scanner girdi = new Scanner(System.in);

        isHataYok = true;

        String fonksiyondakiDegiskenlerString = "";
        String degisken="";


        for(int i=0;i<Fonksiyon.fonksiyondakiDegiskenSayisi;i++){
         degisken = Fonksiyon.fonksiyondakiDegiskenler.get(i);

          fonksiyondakiDegiskenlerString = fonksiyondakiDegiskenlerString.concat(degisken);

           if(Fonksiyon.fonksiyondakiDegiskenSayisi-i != 1){
               fonksiyondakiDegiskenlerString = fonksiyondakiDegiskenlerString.concat(",");
           }
        }

        System.out.print("Fonksiyonu Giriniz--> F("+fonksiyondakiDegiskenlerString+") = ");
        String fonksiyonIfadesiString="";
        try{
            fonksiyonIfadesiString=girdi.nextLine();
            for(char karakter:fonksiyonIfadesiString.toLowerCase().toCharArray()){
                for(String degiskenHarf:Fonksiyon.fonksiyondakiDegiskenler){
                    if(String.valueOf(karakter).equals(degiskenHarf)){
                        isHataYok=true;
                        break;
                    }else{
                     isHataYok=false;
                    }
                }
            }
            if(!isHataYok){
                System.out.println("!! Değişkenlerde olmayan bir karakter girdiniz tekrar deneyiniz !!");
                girdi.reset();
                fonksiyonuKullanicidanAl();
            }else {
                Fonksiyon.fonksiyonIfadesi = fonksiyonIfadesiString;
            }
            girdi.reset();
        }catch (Exception e){
            System.out.println(" Değişkenlerde olmayan bir karakter girdiniz tekrar deneyiniz !!");
            girdi.reset();
            fonksiyonuKullanicidanAl();
        }
        girdi.reset();

    }

    static void fonksiyondakiDegiskenSayisiniKullanicidanAl(){
        Scanner girdi = new Scanner(System.in);
        int girdiInt;
        do{
            try {
                System.out.print("Fonksiyondaki değişken sayısını giriniz: ");
                girdiInt = girdi.nextInt();
                if(girdiInt<2){
                    isHataYok=false;
                }else{
                    Fonksiyon.fonksiyondakiDegiskenSayisi = girdiInt;
                    isHataYok=true;
                }
            }catch (Exception e){
                isHataYok=false;
            }
            girdi.reset();

            if(!isHataYok){
                System.out.println("\n\t!! Değişken Sayısı 2 den büyük bir sayı olmalıdır.Tekrar girin !!\n");
                fonksiyondakiDegiskenSayisiniKullanicidanAl();
            }

        }while (!isHataYok);
    }

    static void fonksiyondakiDegiskenleriKullanicidanAl(){
        Scanner girdi = new Scanner(System.in);
        Fonksiyon.fonksiyondakiDegiskenler.clear();
        for(int i=0;i<Fonksiyon.fonksiyondakiDegiskenSayisi;i++){
            System.out.print("Fonksiyondaki "+(i+1)+". Değişkeni Giriniz: ");
             Fonksiyon.fonksiyondakiDegiskenler.add(Fonksiyon.fonksiyonIfadesi = girdi.next().toLowerCase());
        }
        girdi.reset();
    }

    static boolean programBitirilsinMi(){
        Scanner girdi = new Scanner(System.in);

            System.out.print("Yeni Fonksiyonla Denemek İster misiniz? (e/h) : ");
             String cevap = girdi.next();
             boolean cevapBool = false;
             if(cevap.toLowerCase().equals("e")){
                 cevapBool=true;
             }else{
                 cevapBool=false;
             }

        girdi.reset();
      return  cevapBool;
    }
}
