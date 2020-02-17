package ba.unsa.etf.rpr;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

public class Docent extends Nastavnik {
    public Docent(String imePrezime) {
        super(imePrezime);
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
        return "Doc. dr "+getImePrezime();
    }
}
