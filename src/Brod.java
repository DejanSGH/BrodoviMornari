import java.util.ArrayList;

public abstract class Brod {

    protected String naziv;
    protected String vrstaBroda;
    private int brojPosade;
    protected int prosecanKvalitetPosade;
    private Mornar kapetanBroda;
    private Mornar najgoriMornar;
    protected ArrayList<Mornar> posada;

    public Brod(String naziv, int brojPosade, Mornar kapetanBroda) {
        this.naziv = naziv;
        this.brojPosade = brojPosade;
        this.kapetanBroda = kapetanBroda;
        this.posada = new ArrayList<Mornar>();
        dodajMornara(kapetanBroda);
    }

    private void koJeKapetan(ArrayList<Mornar> posada) {

        int indeksMornara = 0;
        for (int i = 0; i < posada.size(); i++) {
            if (posada.get(indeksMornara).getKvalitet() < posada.get(i).getKvalitet()) {
                indeksMornara = i;
            }
        }
        this.kapetanBroda = posada.get(indeksMornara);

    }

    private void najgoriMornar(ArrayList<Mornar> posada){
        if(posada.size() > 1) {
            int indeksMornara = 0;
            for (int i = 0; i < posada.size(); i++) {
                if (posada.get(indeksMornara).getKvalitet() > posada.get(i).getKvalitet()) {
                    indeksMornara = i;
                }
            }
            this.najgoriMornar = posada.get(indeksMornara);
        }
    }

    public void dodajMornara(Mornar mornar) {
        if (posada.size() < brojPosade) {
            posada.add(mornar);
            koJeKapetan(this.posada);
        } else {
            System.out.println("Kapacitet broda pun");
        }
    }

    public String getNaziv() {
        return naziv;
    }

    public int getBrojPosade() {
        return brojPosade;
    }

    public Mornar getKapetanBroda() {
        return kapetanBroda;
    }

    public Mornar dohvatiMornara(int indeksMornara) throws GIndeks{
        if(posada.size() >= indeksMornara && indeksMornara != 0){
            return posada.get(indeksMornara-1);
        }
        throw new GIndeks();
    }

    public abstract char vrsta();


    public Mornar getNajgoriMornar() {
        najgoriMornar(posada);
        return najgoriMornar;
    }

    private void racunajKvalitetPosade(){
        int rezultat = 0;
        if(posada.size() == 0){
            prosecanKvalitetPosade = 0;
            return;
        }
        for (int i = 0; i < this.posada.size(); i++) {
            rezultat += posada.get(i).getKvalitet();
        }
        prosecanKvalitetPosade = (int)(rezultat / posada.size());
    }


    public int getProsecanKvalitetPosade() {
        racunajKvalitetPosade();
        return prosecanKvalitetPosade;
    }

    public void isprazniBrod(){
        while(posada.size() > 0){
            posada.remove(0);
        }
    }

    public boolean izbrisiMornara(Mornar mornar){
        posada.remove(mornar);
        return true;
    }

    public void napadni(Brod b) throws GIndeks {
        if(uslovNapada(b)) {
            if(prosecanKvalitetPosade > b.prosecanKvalitetPosade) {
                obracunajSe(b);
                b.isprazniBrod(); }
            else if(b.prosecanKvalitetPosade>prosecanKvalitetPosade) {
                b.obracunajSe(this);
                isprazniBrod(); } }
    }

    protected abstract boolean uslovNapada(Brod b);
    protected abstract void obracunajSe(Brod b) throws GIndeks;
}
