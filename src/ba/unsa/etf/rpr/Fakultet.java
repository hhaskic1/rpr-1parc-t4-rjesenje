package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

public class Fakultet {

    private ArrayList<Osoba> osobe=new ArrayList<>();

    public void dodajOsobu(Osoba o){
        osobe.add(o);
    }

    public Set<Student> studenti(){

        Set<Student> studenti=new TreeSet<>();
        for(int i=0;i<osobe.size();i++){
            if(osobe.get(i) instanceof Student){
                studenti.add((Student) osobe.get(i));
            }
        }

        return studenti;
    }

    public List<Osoba> filtriraj(Function<Osoba,Boolean> function){
        List<Osoba> lista=new ArrayList<>();

        for(int i=0;i<osobe.size();i++){
            if(function.apply(osobe.get(i))){
                lista.add(osobe.get(i));
            }
        }
        return lista;
    }

    public List<BachelorStudent> topBachelor(){
        List<BachelorStudent> lista= (List<BachelorStudent>) osobe.stream().filter(osoba -> {return osoba instanceof BachelorStudent && ((BachelorStudent) osoba).prosjek()>=8;});
        return lista;


    }

    @Override
    public String toString() {
       String s = "";
        for(int i=0;i<osobe.size();i++){
           s+=osobe.get(i).toString()+"\n";
       }
       return s;
    }
}
