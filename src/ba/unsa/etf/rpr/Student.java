package ba.unsa.etf.rpr;

public class Student extends Osoba implements Comparable<Student>{
    private String brojIndeksa="";
    private int[] ocjene=new int[100];
    private int brojOcjena=0;

    public void dodajOcjenu(int ocjena) throws IlegalnaOcjena {
        if(ocjena<5 || ocjena>10) throw new IlegalnaOcjena("Ilegalna ocjena "+ocjena);
        if(brojOcjena>99) throw new IllegalArgumentException("Dostignut maksimalan broj ocjena");
        ocjene[brojOcjena]=ocjena;
        brojOcjena++;
    }

    public double prosjek(){
        if(brojOcjena==0) return 0;

        double suma=0;
        for(int i=0;i<brojOcjena;i++){
            suma+=ocjene[i];
        }
        return suma/brojOcjena;
    }

    public Student(String imePrezime) {
        super(imePrezime);
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    @Override
    public String toString() {
        return "Student{}";
    }

    @Override
    public int compareTo(Student o) {
        if(o.prosjek()>prosjek()) return 1;
        if(o.prosjek()<prosjek()) return -1;
        else return 0;
    }
}
