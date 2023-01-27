import java.util.ArrayList;

public class Flota {
    private ArrayList<Brod> brodovi;
    private String name;
    private char vrstaBroda;

    public Flota(String name) {
        this.brodovi = brodovi;
        this.name = name;
        brodovi = new ArrayList<Brod>();
    }

    public Brod dohvatiBrod(int indeksBroda) throws GIndeks{
        if(brodovi.size() >= indeksBroda && indeksBroda > -1){
            return brodovi.get(indeksBroda);
        }
        throw new GIndeks();
    }

    public void dodajBrod(Brod brod){
        if(brodovi.size() == 0){
            brodovi.add(brod);
            vrstaBroda = brod.vrsta();
        }
        if(brodovi.size() > 0){
            if(vrstaBroda == brod.vrsta()){
                brodovi.add(brod);
            }
            else{
                System.out.println("Nije moguce dodati " + brod.vrsta() + " jer brodovi u ovoj floti pripadaju vrsti " + this.vrstaBroda);
            }
        }
    }

    public int prosecanKvalitetFlote(){
        int rezultat = 0;
        for (int i = 0; i < brodovi.size(); i++) {
            rezultat += brodovi.get(i).getProsecanKvalitetPosade();
        }
        return rezultat;
    }

    public String toString(){
//        Flota(врста) назив : квалитет, након чега се у новим редовима
//        исписују појединачни бродови, по један брод у реду. Пре него што се дода први брод у
//        флоту, врста је – (цртица)
        if(brodovi.size() == 0){
            this.vrstaBroda = '-';
        }
        return "Flota (" + this.vrstaBroda + ")" + " " + this.name + " : " + this.prosecanKvalitetFlote();
    }
}
