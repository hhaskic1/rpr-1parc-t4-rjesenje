package ba.unsa.etf.rpr;

public class BachelorStudent extends Student {


    public BachelorStudent(String imePrezime) {
        super(imePrezime);
    }

    @Override
    public double prosjek() {
        return super.prosjek();
    }

    @Override
    public String toString() {
        double a=prosjek()*10;
        a=Math.round(a);
        a/=10;
        return "Bachelor student "+getImePrezime()+" ("+getBrojIndeksa()+"), prosjek ocjena: "+a;
    }
}
