package ba.unsa.etf.rpr;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

public class MasterStudent extends Student {

    private int []ocjeneMaster=new int[100];
    private int brojMasterOcjena=0;

    public MasterStudent(String imePrezime) {
        super(imePrezime);
    }

    public void dodajOcjenuMaster(int ocjena) throws IlegalnaOcjena {
        if(ocjena<5 || ocjena>10) throw new IlegalnaOcjena("Ilegalna ocjena "+ocjena);
        if(brojMasterOcjena>99) throw new IllegalArgumentException("Dostignut maksimalan broj ocjena");
        ocjeneMaster[brojMasterOcjena]=ocjena;
        brojMasterOcjena++;
    }

    public double prosjekMaster(){
        if(brojMasterOcjena==0) return 0;

        double suma=0;
        for(int i=0;i<brojMasterOcjena;i++){
            suma+=ocjeneMaster[i];
        }
        return suma/brojMasterOcjena;
    }

    public double prosjek(){
        return super.prosjek()+prosjekMaster()/2;
    }

    public String rodjendan(LocalDate rodjedan){
        String vrati="";
        Month trenutnoVrijeme=rodjedan.getMonth();
        int dan=rodjedan.getDayOfMonth();


        if(trenutnoVrijeme== Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).getMonth() &&
                dan==Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).getDayOfMonth()){
            vrati="Sretan rodjendan!";
        }else return vrati;
        return vrati;
    }



    @Override
    public String toString() {
        double a=(super.prosjek()+prosjekMaster()/2)*10;
        a=Math.round(a);
        a/=10;
        return "Master student "+getImePrezime()+" ("+getBrojIndeksa()+"), prosjek ocjena: "+a;
    }
}
