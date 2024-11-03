public class Farketmez {
   /*
    public static void mintermdekiFarketmeziBulAyarla(String mintermSatirDegiskenDegeri,String mintermSutunDegiskenDegeri,String[][]karnaughMatrisBasliklar){
        anlikMintermSatirdakiEksikSayisi =0;
        anlikMintermSutundakiEksikSayisi =0;
        String satirFarketmezXYokEdilmisHali="";
        String sutunFarketmezXYokEdilmisHali="";
        String[][] basliklarinFarketmeziYokEdilmisHali = new String[satirSayisi+1][sutunSayisi];
        farketmezSatirIndexleri.clear();
        farketmezSutunIndexleri.clear();

        int ifadeIndex=0;

        //Matristeki başlıkları geçici diziye aktarılması karşılaştırma bu dizideki başlıklar ile yapılacak.
        for(int f=0;f<satirSayisi+1;f++){
            for(int m=0;m<sutunSayisi;m++){
                basliklarinFarketmeziYokEdilmisHali[f][m]=karnaughMatrisBasliklar[f][m];
            }
        }

        //Verilen mintermin satırlarında kaç tane farketmez olduğunu hesaplar.
        while ((ifadeIndex = mintermSatirDegiskenDegeri.indexOf("X",ifadeIndex)) != -1) {
            anlikMintermSatirdakiEksikSayisi++;
            farketmezSatirIndexleri.add(ifadeIndex);
            ifadeIndex += "X".length();
        }
        ifadeIndex=0;

        //Verilen mintermin sütunlarında kaç tane farketmez olduğunu hesaplar.
        while ((ifadeIndex = mintermSutunDegiskenDegeri.indexOf("X",ifadeIndex)) != -1) {
            anlikMintermSutundakiEksikSayisi++;
            farketmezSutunIndexleri.add(ifadeIndex);
            ifadeIndex += "X".length();
        }
        //Satırda Farketmez varsa String ifadede kaçıncı sırada olduğunu buluyor
        int baslangicIndex=0;
        int sonIndex=0;
        if(anlikMintermSatirdakiEksikSayisi >0) {
            System.out.println("h: " + farketmezSatirIndexleri.size() + " hs: " + anlikMintermSatirdakiEksikSayisi);
            for (int h = 0; h < anlikMintermSatirdakiEksikSayisi; h++) {
                sonIndex = farketmezSatirIndexleri.get(h);
                satirFarketmezXYokEdilmisHali = mintermSatirDegiskenDegeri.substring(baslangicIndex, sonIndex);
                System.out.println("farketmez silinmiş şuanki hali " + sutunFarketmezXYokEdilmisHali);
           /* for(int m=0;m<satirSayisi+1;m++){
                basliklarinFarketmeziYokEdilmisHali[m][0]=basliklarinFarketmeziYokEdilmisHali[m][0].substring(baslangicIndex,sonIndex);
                       // karnaughMatrisBasliklar[m][0].substring(baslangicIndex,sonIndex);
            }*/
    /*
                for(int m=0;m<satirSayisi+1;m++){
                    if(m!=0) {
                        basliklarinFarketmeziYokEdilmisHali [m][0] = satirFarketmezXYokEdilmisHali;
                    }
                    // karnaughMatrisBasliklar[m][0].substring(baslangicIndex,sonIndex);
                }
                baslangicIndex = sonIndex;
            }
        }else{
            System.out.println("farketmez olmadığı için  şuanki hali " + sutunFarketmezXYokEdilmisHali);
            satirFarketmezXYokEdilmisHali = mintermSatirDegiskenDegeri;
        }


        System.out.println("m: "+farketmezSutunIndexleri.size()+" ms: "+ anlikMintermSutundakiEksikSayisi);
        baslangicIndex=0;
        sonIndex=0;
        if(anlikMintermSutundakiEksikSayisi >0) {
            for (int h = 0; h < anlikMintermSutundakiEksikSayisi; h++) {
                sonIndex = farketmezSutunIndexleri.get(h);
                sutunFarketmezXYokEdilmisHali = mintermSutunDegiskenDegeri.substring(baslangicIndex, sonIndex);
            /*for(int m=0;m<sutunSayisi;m++){
                basliklarinFarketmeziYokEdilmisHali[0][m]=sutunFarketmezXYokEdilmisHali.substring(baslangicIndex,sonIndex);
                // basliklarinFarketmeziYokEdilmisHali[0][m]=basliklarinFarketmeziYokEdilmisHali[0][m].substring(baslangicIndex,sonIndex);
                        //karnaughMatrisBasliklar[0][m].substring(baslangicIndex,sonIndex);
            }*//*
                for(int m=0;m<sutunSayisi;m++){
                    basliklarinFarketmeziYokEdilmisHali[0][m]=sutunFarketmezXYokEdilmisHali;
                    // basliklarinFarketmeziYokEdilmisHali[0][m]=basliklarinFarketmeziYokEdilmisHali[0][m].substring(baslangicIndex,sonIndex);
                    //karnaughMatrisBasliklar[0][m].substring(baslangicIndex,sonIndex);
                }
                baslangicIndex = sonIndex;
            }
        }else{
            sutunFarketmezXYokEdilmisHali = mintermSutunDegiskenDegeri;
        }
        System.out.println("sutun farketmez yok edilmiş hali: "+sutunFarketmezXYokEdilmisHali);


        farketmezSatirIndexleri.clear();
        farketmezSutunIndexleri.clear();
        for(int k=0;k<satirSayisi;k++) {
            if(basliklarinFarketmeziYokEdilmisHali[k+1][0].equals(satirFarketmezXYokEdilmisHali)){
                farketmezSatirIndexleri.add(k);
            }
        }
        //-------------------------------
        //Sütun olarak doğru konumu bulma
        for(int k=0;k<sutunSayisi;k++){
            if(basliklarinFarketmeziYokEdilmisHali[0][k].equals(sutunFarketmezXYokEdilmisHali)){
                farketmezSutunIndexleri.add(k);
                System.out.println("huhu: "+basliklarinFarketmeziYokEdilmisHali[0][k]+"  heey: "+sutunFarketmezXYokEdilmisHali);
            }
            /*
            if(mintermSutunDegiskenDegeri.contains("X")){
                if(karnaughMatrisBasliklar[0][k].equals(sutunFarketmezXYokEdilmisHali)){
                    farketmezSutunIndexleri.add(k);
                }
                System.out.println("evet sütunda "+anlikMintermSutundakiFarketmezSayisi +" tane Farketmez var");

           /* }else if(karnaughMatrisBasliklar[0][k].equals(mintermSutunDegiskenDegeri)){
                break;
            }else{
                continue;
            }*//*
        }
        System.out.println("f: "+farketmezSatirIndexleri.size()+" fs: "+farketmezSutunIndexleri.size());
        System.out.println("l: "+farketmezSatirIndexleri.toString()+" ls: "+farketmezSutunIndexleri.toString());
        for(int f=0;f<farketmezSatirIndexleri.size();f++){
            for(int m=0;m<farketmezSutunIndexleri.size();m++){
                karnaughMatris[farketmezSatirIndexleri.get(f)][farketmezSutunIndexleri.get(m)]="1X";
                System.out.println("geldimm");
            }
            //karnaughMatris[farketmezSatirIndexleri.get(f)][farketmezSutunIndexleri.get(f)]="X";
            //System.out.println("geldimm");
        }

    }
    */
}
