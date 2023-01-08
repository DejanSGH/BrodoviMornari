import java.util.ArrayList;

public class Brod {

    private String naziv;
    private int brojPosade;
    private Mornar kapetanBroda;
    private ArrayList<Mornar> posada;

    public Brod(String naziv, int brojPosade) {
        this.naziv = naziv;
        this.brojPosade = brojPosade;
        this.posada = new ArrayList<Mornar>();
    }

    private void koJeKapetan(ArrayList<Mornar> posada){
        if(!posada.isEmpty()){
            int indeksMornara = 0;
            for (int i = 0; i < posada.size(); i++) {
                if(posada.get(indeksMornara).getKvalitet() > posada.get(i).getKvalitet()){
                    indeksMornara = i;
                }
            }
            this.kapetanBroda = posada.get(indeksMornara);
        }

    }

    public void dodajMornara(Mornar mornar){
        if(posada.size() < brojPosade) {
            posada.add(mornar);
        }
        System.out.println("Kapacitet broda pun");
    }
}
