import java.util.Arrays;

public class GusarskiBrod extends Brod {

    private String vrstaBroda = "G";

    public GusarskiBrod(String naziv, int brojPosade, Mornar kapetanBroda) {
        super(naziv, brojPosade,kapetanBroda);
    }

    public String toString(){
        //врста - назив : квалитет_посаде
        String ispis = this.vrstaBroda + " - " + this.naziv + " : " + getProsecanKvalitetPosade();
        return ispis + "\n" + Arrays.asList(posada);
    }
}
