import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class KarnaughKuralinaGoreGrupla {
    static int []birlerinOlduguSatirKonumu;
    static int []birlerinOlduguSutunKonumu;


    int []gruptakiKomsuSayilari;
    String []komsular;
    //Ortak olan satır mı sütun mu bilgisini tutar.
    String []komsulukTuru;

    static int gruptakiKomsuSayisi=0;
    static int olusabilcekGrupSayisi=0;

    static int []farketmezlerinOlduguSatirKonumu;
    static int []farketmezlerinOlduguSutunKonumu;

    ArrayList<Integer>silinecekElemanIndisleri=new ArrayList<>();
    ArrayList<String> yeniDizi=new ArrayList<>();
    HashSet<String> ortakSatir=new HashSet<>();
    HashSet<String> ortakSutun=new HashSet<>();

    void ortakSatirSutunDurumunaGoreBirleriFarketmezleriGrupla(int []birlerinOlduguSatirKonumu,int []birlerinOlduguSutunKonumu,int []farketmezlerinOlduguSatirKonumu,int []farketmezlerinOlduguSutunKonumu,int satirSayisi,int sutunSayisi,String [] komsular,String [] komsulukTuru){
        olusabilcekGrupSayisi=0;

        int indis=0;
        for(int i=0;i<birlerinOlduguSatirKonumu.length+farketmezlerinOlduguSatirKonumu.length;i++) {
            indis=0;
            do {
                //Eğer satırlar arası fark 1 ise buraya girer
                if(indis!=i && birlerinOlduguSatirKonumu[i] - birlerinOlduguSatirKonumu[indis] == 1 ){
                    //Eğer aynı sütun üstündeyse
                    if(birlerinOlduguSutunKonumu[i] == birlerinOlduguSutunKonumu[indis]){
                        komsulukTuru[olusabilcekGrupSayisi]="Sütun";
                        komsular[olusabilcekGrupSayisi]=""+birlerinOlduguSatirKonumu[indis]+""+birlerinOlduguSatirKonumu[i]+""+birlerinOlduguSutunKonumu[indis]+""+birlerinOlduguSutunKonumu[i];
                        olusabilcekGrupSayisi++;
                    }
                    //Eğer aynı satır üstündeyse buraya girer.
                } else if (indis!=i && birlerinOlduguSatirKonumu[i] == birlerinOlduguSatirKonumu[indis] ) {
                    //eğer sutunlar arası fark 1 ise yani sütun oalrak komşularsa
                    if (birlerinOlduguSutunKonumu[i] - birlerinOlduguSutunKonumu[indis] == 1) {
                        komsulukTuru[olusabilcekGrupSayisi]="Satır";
                        komsular[olusabilcekGrupSayisi]=""+birlerinOlduguSatirKonumu[indis]+""+birlerinOlduguSatirKonumu[i]+""+birlerinOlduguSutunKonumu[indis]+""+birlerinOlduguSutunKonumu[i];
                        olusabilcekGrupSayisi++;
                    }
                    //Eğere sutunlar arası fark sutun sayısından 1 eksik ise yani ekstra şekilde komşu ise
                    else if( birlerinOlduguSutunKonumu[i] - birlerinOlduguSutunKonumu[indis] == (sutunSayisi-1) ){
                        komsulukTuru[olusabilcekGrupSayisi]="Satır";
                        komsular[olusabilcekGrupSayisi]=""+birlerinOlduguSatirKonumu[indis]+""+birlerinOlduguSatirKonumu[i]+""+birlerinOlduguSutunKonumu[indis]+""+birlerinOlduguSutunKonumu[i];
                        olusabilcekGrupSayisi++;

                    }
                    //Eğer satırlar ilk ve son satırsa
                }else if( indis!=i && ((birlerinOlduguSatirKonumu[i] == 0 && birlerinOlduguSatirKonumu[indis] == (satirSayisi-1)) || (birlerinOlduguSatirKonumu[indis] == 0 && birlerinOlduguSatirKonumu[i] == (satirSayisi-1) ) )) {
                    //Eğer satırlar ilk satır ve son satır ise ve sutunları aynı ise komşudur.
                    if (birlerinOlduguSatirKonumu[indis] - birlerinOlduguSatirKonumu[i] == (satirSayisi - 1) && birlerinOlduguSutunKonumu[i] == birlerinOlduguSutunKonumu[indis]) {
                        komsulukTuru[olusabilcekGrupSayisi] = "Sütun";
                        komsular[olusabilcekGrupSayisi] = "" + birlerinOlduguSatirKonumu[indis] + "" + birlerinOlduguSatirKonumu[i] + "" + birlerinOlduguSutunKonumu[indis] + "" + birlerinOlduguSutunKonumu[i];
                        olusabilcekGrupSayisi++;
                    }
                }

                indis++;
            }while (indis!=birlerinOlduguSatirKonumu.length);
            //}
            //olusabilcekGrupSayisi++;
        }
    }

    boolean dahaFazlaKomsuBarindiranOrtakSatirliVarMi(String[] komsularDizisi,HashSet<String> ortakSatir){
        boolean isDahaFazlaKomsuBarindiranOrtakSatirliVar=false;
        int grupIndex=0;
        String enUzunOrtakSatirlarIcin="";

        for (String OrtakSatir:ortakSatir) {
            grupIndex=0;
            enUzunOrtakSatirlarIcin="";
            for(String grup:komsularDizisi){
                if(grup!=null){

                    if (grup.startsWith(OrtakSatir + OrtakSatir)     &&     ! String.valueOf(grup.charAt(grup.length()-1)).equals(String.valueOf(grup.charAt(grup.length()-2))) ) {
                        if (enUzunOrtakSatirlarIcin.length() < grup.length()) {
                            enUzunOrtakSatirlarIcin = grup;
                            System.out.println("ennnnuzun------: "+enUzunOrtakSatirlarIcin);

                        } else if(enUzunOrtakSatirlarIcin.length()>=0   &&  enUzunOrtakSatirlarIcin.length() > grup.length() ){
                            komsularDizisi[grupIndex] = null;
                            isDahaFazlaKomsuBarindiranOrtakSatirliVar=true;
                        }
                    }
                }
                grupIndex++;
            }
        }


      return isDahaFazlaKomsuBarindiranOrtakSatirliVar;
    }

    boolean dahaFazlaKomsuBarindiranOrtakSutunluVarMi(String[] komsularDizisi,HashSet<String> ortakSutun){
        boolean isDahaFazlaKomsuBarindiranOrtakSutunluVar=false;
        int grupIndex=0;
        String enUzunOrtakSutunlarIcin="";

        for (String OrtakSutun:ortakSutun) {
            grupIndex=0;
            enUzunOrtakSutunlarIcin="";
            for(String grup:komsularDizisi){
                if(grup!=null){

                    if (grup.endsWith(OrtakSutun + OrtakSutun)     &&   ! String.valueOf(grup.charAt(0)).equals(String.valueOf(grup.charAt(1)))   ) {
                        if (enUzunOrtakSutunlarIcin.length() < grup.length()) {
                            enUzunOrtakSutunlarIcin = grup;
                            System.out.println("ennnnuzun*******: "+enUzunOrtakSutunlarIcin);
                        } else if(enUzunOrtakSutunlarIcin.length()>=0    &&   enUzunOrtakSutunlarIcin.length() > grup.length() ) {
                            komsularDizisi[grupIndex] = null;
                        }
                    }
                }
                grupIndex++;
            }
        }

     return isDahaFazlaKomsuBarindiranOrtakSutunluVar;
    }

    void matristekiBirVeFarketmezlerinSatirSutunIndisleriniAktar(int [] birlerinOlduguSatirKonumu,int []birlerinOlduguSutunKonumu,int []farketmezlerinOlduguSatirKonumu,int []farketmezlerinOlduguSutunKonumu,int satirSayisi,int sutunSayisi,String [][] karnaughMatris){
        int anlikDiziyeEklenenBirKonumSayisi=0;
        int anlikDiziyeEklenenFarketmezKonumSayisi=0;

        //Diziye matristeki 1 lerin ve farketmezlerin satır sütun indislerini aktarır.
        for(int i=0;i<satirSayisi;i++){
            for(int j=0;j<sutunSayisi;j++){
                if(karnaughMatris[i][j].equals("1")){
                    birlerinOlduguSatirKonumu[anlikDiziyeEklenenBirKonumSayisi]=i;
                    birlerinOlduguSutunKonumu[anlikDiziyeEklenenBirKonumSayisi]=j;
                    anlikDiziyeEklenenBirKonumSayisi++;
                }else if(karnaughMatris[i][j].equals("X")){
                    farketmezlerinOlduguSatirKonumu[anlikDiziyeEklenenFarketmezKonumSayisi]=i;
                    farketmezlerinOlduguSutunKonumu[anlikDiziyeEklenenFarketmezKonumSayisi]=j;
                    anlikDiziyeEklenenFarketmezKonumSayisi++;
                }
            }
        }
    }

    //Eğer ekstra komşuluk(ilk satır - son satır  / ilk sütun - son sütun ile komşuluk ) varsa ve komşuluk dizisindeyse aynı zamanda bu ekstra komşuluk olan konum fiziksel komşuluğu da varsa ekstra komşuluk dizisinden silinr.
    void ekstraKomsuyuDizidenTemizle(String[] komsular,ArrayList<String> yeniDizi){
        int elemanIndis=0;
        silinecekElemanIndisleri.clear();
        for(String eleman:yeniDizi){
            String birincininSatirIndisi= String.valueOf(eleman.charAt(0));
            String ikincininSatirIndisi= String.valueOf(eleman.charAt(1));
            String birincininSutunIndisi= String.valueOf(eleman.charAt((eleman.length()/2)-1));
            String ikincininSutunIndisi= String.valueOf(eleman.charAt(eleman.length()/2));

            //Ortak Satır ise
            if (birincininSatirIndisi.equals(ikincininSatirIndisi)){
                System.out.println("Ortak olan satır");
                System.out.println("sÇ: "+eleman);
                //Eğer komşu indislerde satır kısmı eğer belirtilen satır indisiyle eşitse ve sütun kısmında belirttiğimiz 1. sütun ve 2.sütun varsa diziden silmek için dizideki indisini alır.
                for (String komsularIndisleri:komsular) {
                    if(komsularIndisleri!=null){
                        if (komsularIndisleri.startsWith(birincininSatirIndisi + birincininSatirIndisi) && komsularIndisleri.substring(komsularIndisleri.length() / 2).contains(birincininSutunIndisi) && komsularIndisleri.substring(komsularIndisleri.length() / 2).contains(ikincininSutunIndisi)) {
                            System.out.println("evet ben varım   "+eleman);
                            silinecekElemanIndisleri.add(elemanIndis);
                        }
                    }else{
                        continue;
                    }
                }


                //Ortak Sütun ise
            }else if(birincininSutunIndisi.equals(ikincininSutunIndisi)){
                System.out.println("Ortak olan sütun");
                System.out.println(eleman);
                for (String komsularIndisleri:komsular) {
                    if(komsularIndisleri!=null){
                        //Eğer komşu indislerde sutun kısmı eğer belirtilen sutun indisiyle eşitse ve satır kısmında belirttiğimiz 1. satır ve 2.satır varsa diziden silmek için dizideki indisini alır.
                        if(komsularIndisleri.endsWith( birincininSutunIndisi + birincininSutunIndisi ) && komsularIndisleri.substring(0,komsularIndisleri.length()/2).contains(birincininSatirIndisi) && komsularIndisleri.substring(0,komsularIndisleri.length()/2).contains(ikincininSatirIndisi)){
                            System.out.println("busefer burdayım   "+ eleman);
                            silinecekElemanIndisleri.add(elemanIndis);
                        }
                    }else{
                        continue;
                    }
                }
            }
            elemanIndis++;
        }

        for(int silineceElemanIndis:silinecekElemanIndisleri){
            yeniDizi.remove(silineceElemanIndis);
        }
    }

    void fizikselVeEkstraKomsulugaGoreGruplayarakDiziyeAktar(int satirSayisi,int sutunSayisi,String[] komsular,String[] komsulukTuru){
        for(int i=0;i<olusabilcekGrupSayisi;i++){
            String anlikSatir="";
            String sonrakiSatirDegeri="";
            String sonrakiSutunDegeri="";
            String sonrakiSatirSutunBirlestirilmisDeger="";
            boolean isDongudenCik=false;



            if(komsular[i]!=null){
                if(komsulukTuru[i].equals("Satır")){
                    do {
                        gruptakiKomsuSayisi = komsular[i].length() / 2;

                        anlikSatir = komsular[i].substring(gruptakiKomsuSayisi);
                        //System.out.println("anlık sütun: " + anlikSatir);
                        //System.out.println("x: "+Integer.parseInt(anlikSatir.substring(gruptakiKomsuSayisi-1)));
                        //System.out.println("y: "+Integer.parseInt(anlikSatir.substring(gruptakiKomsuSayisi-2,gruptakiKomsuSayisi-1)));
                        if(Integer.parseInt(anlikSatir.substring(gruptakiKomsuSayisi-1))  - Integer.parseInt(anlikSatir.substring(gruptakiKomsuSayisi-2,gruptakiKomsuSayisi-1))  >1 ){
                            yeniDizi.add(komsular[i]);
                            komsular[i]=null;
                            break;
                        }


                        sonrakiSatirDegeri = komsular[i].substring(0, 2);
                        //System.out.println("sonraki satir deger: " + sonrakiSatirDegeri);

                        for (char deger : anlikSatir.toCharArray()) {
                            int sayisalDegeri = (int) Integer.parseInt("" + deger);
                            if(sutunSayisi-1 !=sayisalDegeri){
                                //sonrakiSutunDegeri +=
                                sonrakiSutunDegeri += String.valueOf(sayisalDegeri + 1);

                            }else {
                                break;
                            }
                        }
                        if(sonrakiSutunDegeri.length()>=2){
                            sonrakiSutunDegeri = sonrakiSutunDegeri.substring(sonrakiSutunDegeri.length()-2);
                        }

                        //System.out.println("sonraki sutun deger: " + sonrakiSutunDegeri);

                        gruptakiKomsuSayisi = komsular[i].length() / 2;

                        //System.out.println("bunu arat: "+sonrakiSatirDegeri + sonrakiSutunDegeri);
                        if (Arrays.stream(komsular).toList().contains(sonrakiSatirDegeri + sonrakiSutunDegeri)) {
                            //System.out.println(i+". Dizide varrr!!!:  "+sonrakiSatirDegeri + sonrakiSutunDegeri);
                            int grupIndex=0;
                            /*for(String grup:komsular){
                                if(grup!=null){
                                    if (grup.contains(sonrakiSatirDegeri + sonrakiSutunDegeri)){
                                        komsular[grupIndex]=null;
                                        System.out.println("klmlllllll");
                                    }
                                    grupIndex++;
                                }else {
                                    break;
                                }
                            }*/
                            ortakSatir.add(String.valueOf(komsular[i].charAt(0)));
                            komsular[i] = komsular[i].substring(0, gruptakiKomsuSayisi) + komsular[i].toCharArray()[0] + komsular[i].substring(gruptakiKomsuSayisi) + sonrakiSutunDegeri.substring(sonrakiSutunDegeri.length() - 1);
                            //System.out.println("hello: "+Integer.parseInt( String.valueOf(komsular[i].charAt(komsular[i].length()-1))));
                            if( Integer.parseInt( String.valueOf(komsular[i].charAt(komsular[i].length()-1))) == sutunSayisi-1 ){
                                isDongudenCik = true;
                            }else{
                                isDongudenCik = false;
                            }
                        } else {
                            isDongudenCik = true;
                        }


                        //System.out.println("sayac: "+sayac+"   grupsayısı: "+olusabilcekGrupSayisi);
                    }while (!isDongudenCik); //&& sayac<olusabilcekGrupSayisi);
                    // System.out.println("sssssssssssssssssssssssssssssssssssssssss");

                }else if (komsulukTuru[i].equals("Sütun")){
                    anlikSatir="";
                    sonrakiSatirDegeri="";
                    sonrakiSutunDegeri="";
                    do {
                        gruptakiKomsuSayisi = komsular[i].length() / 2;

                        anlikSatir = komsular[i].substring(0,gruptakiKomsuSayisi);
                        //System.out.println("anlık sütun: " + anlikSatir);
                        //System.out.println("x: "+Integer.parseInt(anlikSatir.substring(gruptakiKomsuSayisi-1)));
                        //System.out.println("y: "+Integer.parseInt(anlikSatir.substring(gruptakiKomsuSayisi-2,gruptakiKomsuSayisi-1)));
                        if(Math.abs(Integer.parseInt(anlikSatir.substring(gruptakiKomsuSayisi-1))  - Integer.parseInt(anlikSatir.substring(gruptakiKomsuSayisi-2,gruptakiKomsuSayisi-1)))  >1 ){
                            yeniDizi.add(komsular[i]);
                            komsular[i]=null;
                            break;
                        }


                        sonrakiSutunDegeri = komsular[i].substring(2,4);
                        //System.out.println("sonraki satir deger: " + sonrakiSatirDegeri);

                        for (char deger : anlikSatir.toCharArray()) {
                            int sayisalDegeri = (int) Integer.parseInt("" + deger);
                            if(satirSayisi-1 != sayisalDegeri){
                                //sonrakiSutunDegeri +=
                                sonrakiSatirDegeri += String.valueOf(sayisalDegeri + 1);

                            }else {
                                break;
                            }
                        }
                        if(sonrakiSatirDegeri.length()>=2){
                            sonrakiSatirDegeri = sonrakiSatirDegeri.substring(sonrakiSatirDegeri.length()-2);
                        }

                        //System.out.println("sonraki sutun deger: " + sonrakiSutunDegeri);

                        gruptakiKomsuSayisi = komsular[i].length() / 2;

                        //System.out.println("bunu arat: "+sonrakiSatirDegeri + sonrakiSutunDegeri);
                        if (Arrays.stream(komsular).toList().contains(sonrakiSatirDegeri + sonrakiSutunDegeri)) {
                            //System.out.println(i+". Dizide varrr!!!:  "+sonrakiSatirDegeri + sonrakiSutunDegeri);
                            int grupIndex=0;

                            ortakSutun.add(String.valueOf(komsular[i].charAt(komsular[i].length()-1)));

                            komsular[i] = komsular[i].substring(0,gruptakiKomsuSayisi) + sonrakiSatirDegeri.substring(sonrakiSatirDegeri.length()-1) ;
                            for(int f=0;f<gruptakiKomsuSayisi+1;f++){
                                komsular[i] += sonrakiSutunDegeri.substring(0,1);
                            }
                            //komsular[i] = komsular[i].substring(0, gruptakiKomsuSayisi) + komsular[i].toCharArray()[0] + komsular[i].substring(gruptakiKomsuSayisi) + sonrakiSutunDegeri.substring(sonrakiSutunDegeri.length() - 1);
                            //System.out.println("hello: "+Integer.parseInt( String.valueOf(komsular[i].charAt(komsular[i].length()-1))));
                            if( Integer.parseInt( String.valueOf(komsular[i].charAt(komsular[i].length()-1))) == satirSayisi-1 ){
                                isDongudenCik = true;
                            }else{
                                isDongudenCik = false;
                            }
                        } else {
                            isDongudenCik = true;
                        }


                        //System.out.println("sayac: "+sayac+"   grupsayısı: "+olusabilcekGrupSayisi);
                    }while (!isDongudenCik); //&& sayac<olusabilcekGrupSayisi);
                    // System.out.println("sssssssssssssssssssssssssssssssssssssssss");

                }
            }else {
                break;
            }
        }
    }

    void gruplardaTekrarEdenleriDizilerdenTemizle(String[] komsularDizisi){
        /*String [] geciciKomsularTersten = new  String[komsular.length];
        String [] geciciKomsularTerstenAlinanlarinNormali = new  String[komsular.length];
        int []silinecekIndex = new  int[komsular.length];
         */
        for(String  el:komsularDizisi){
                System.out.println("-*- "+el);

        }/*
        //Komsu dizesindekiler tersten bir geçici diziye aktarılır sonrasında eşitlik varmı sorgusu yapmak için
        int index=0;
        for(String komsuDizesi:komsular){
            System.out.println("İŞ: "+komsuDizesi);
            String geciciIfade="";
          if(komsuDizesi!=null){
            for(int k=0;k<komsuDizesi.length();k++){
              geciciIfade += komsuDizesi.charAt(komsuDizesi.length()-1-k);
            }
            geciciKomsularTersten[index] = geciciIfade ;
            geciciKomsularTerstenAlinanlarinNormali[index]=komsuDizesi;
            index++;
          }
        }
        /////////////////////////////////////////////////////////////////////////////////////
        index=0;
        for (int m=0;m<komsular.length;m++){
            System.out.println("selam: "+geciciKomsularTersten[m] + " ---: "+komsular[m]);
            if(komsular[m] != null) {
                System.out.println("selam: "+geciciKomsularTersten[m]);
                for (int f=0;f<geciciKomsularTersten.length;f++) {
                    System.out.println("kk");
                    System.out.println("ss"+Arrays.stream(komsular).toList());
                    if (komsular[m].equals(geciciKomsularTersten[f]) && Arrays.stream(komsular).toList().contains(geciciKomsularTerstenAlinanlarinNormali[f])) {
                       silinecekIndex[index]=m;
                        System.out.println("silicem: "+komsular[m]);
                       komsular[m]=null;
                       index++;
                    }
                }
            }

        }

      */
    }

    KarnaughKuralinaGoreGrupla(String[][] karnaughMatris,int satirSayisi,int sutunSayisi,int matristekiBirSayisi,int matristekiFarketmezSayisi){
        komsular = new String[satirSayisi*sutunSayisi*2];
        komsulukTuru = new String[satirSayisi*sutunSayisi*2];

        birlerinOlduguSatirKonumu=new int[matristekiBirSayisi];
        birlerinOlduguSutunKonumu=new int[matristekiBirSayisi];

        farketmezlerinOlduguSatirKonumu=new int[matristekiFarketmezSayisi];
        farketmezlerinOlduguSutunKonumu=new int[matristekiFarketmezSayisi];


        //Diziye matristeki 1 lerin ve farketmezlerin satır sütun indislerini aktarır.
        matristekiBirVeFarketmezlerinSatirSutunIndisleriniAktar(birlerinOlduguSatirKonumu,birlerinOlduguSutunKonumu,farketmezlerinOlduguSatirKonumu,farketmezlerinOlduguSutunKonumu,satirSayisi,sutunSayisi,karnaughMatris);

        ortakSatirSutunDurumunaGoreBirleriFarketmezleriGrupla(birlerinOlduguSatirKonumu,birlerinOlduguSutunKonumu,farketmezlerinOlduguSatirKonumu,farketmezlerinOlduguSutunKonumu,satirSayisi,sutunSayisi,komsular,komsulukTuru);


        System.out.println("oluşabilcek grup sayısı: "+olusabilcekGrupSayisi);
        for(String komsu:komsular){
            if(komsu!=null){
                System.out.println(komsu);
            }
        }

        fizikselVeEkstraKomsulugaGoreGruplayarakDiziyeAktar(satirSayisi,sutunSayisi,komsular,komsulukTuru);

        System.out.println("OrtakSatırlar:");
        for (String OrtakSatir:ortakSatir) {
            System.out.println(OrtakSatir);
        }
        System.out.println("--------------------");
        System.out.println("OrtakSutunlar:");
        for (String OrtakSutun:ortakSutun) {
            System.out.println(OrtakSutun);
        }
        System.out.println("--------------------");


        dahaFazlaKomsuBarindiranOrtakSatirliVarMi(komsular,ortakSatir);
        dahaFazlaKomsuBarindiranOrtakSutunluVarMi(komsular,ortakSutun);

        gruplardaTekrarEdenleriDizilerdenTemizle(komsular);



        System.out.println("huhuuuuuu");
        for(String komsu:komsular){
            if(komsu!=null){
                System.out.println(komsu);
            }
        }
        System.out.println("heyyyyyoo");

        ekstraKomsuyuDizidenTemizle(komsular,yeniDizi);

        System.out.println("yeni halimm");
        for(String eleman:yeniDizi){
            System.out.println(eleman);
        }

    }

}
