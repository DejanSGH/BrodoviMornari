import java.util.Arrays;

public class KraljevskiBrod extends Brod {

    private String vrstaBroda = "K";

    public KraljevskiBrod(String naziv, int brojPosade, Mornar kapetanBroda) {
        super(naziv, brojPosade, kapetanBroda);

    }

    public String toString(){
        //врста - назив : квалитет_посаде
        String ispis = this.vrstaBroda + " - " + this.naziv + " : " + getProsecanKvalitetPosade();
        return ispis + "\n" + Arrays.asList(posada);
    }

    @Override
    public void napadni(Brod brod) {
        if(brod.vrstaBroda.compareTo("K") == 0){
            System.out.println("Nije moguce napasti brod");
        }
        else
        {
            System.out.println("Brod napadnut");
            if(this.prosecanKvalitetPosade > brod.prosecanKvalitetPosade){
                System.out.println("Pobeda");
                while(posada.size() < getBrojPosade()){
                    posada.add(brod.getKapetanBroda());
                    brod.ukloniMornara(brod.getKapetanBroda());
                }
            }
        }
    }
}
