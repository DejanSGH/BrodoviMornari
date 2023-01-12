import java.util.Arrays;

public class KraljevskiBrod extends Brod {

    public static char vrstaBroda = 'K';

    public KraljevskiBrod(String naziv, int brojPosade, Mornar kapetanBroda) {
        super(naziv, brojPosade, kapetanBroda);

    }

    public String toString(){
        //врста - назив : квалитет_посаде
        String ispis = this.vrstaBroda + " - " + this.naziv + " : " + getProsecanKvalitetPosade();
        return ispis + "\n" + Arrays.asList(posada);
    }

    @Override
    protected boolean uslovNapada(Brod b) {
        return b.vrsta()!=vrstaBroda;
    }
    @Override
    protected void obracunajSe(Brod b) throws GIndeks {
        while(this.getBrojPosade() < posada.size()) {
            Mornar m = b.getKapetanBroda();

            if(m==null){
                break;
            }
            if(m.getKvalitet() > getNajgoriMornar().getKvalitet())
                posada.add(m);
            else break;
        }
    }

    @Override
    public char vrsta() {
        return vrstaBroda;
    }
}
