public class Mornar {

    private String ime;
    private int kvalitet;

    public Mornar(String ime, int kvalitet) {
        this.ime = ime;
        this.kvalitet = kvalitet;
    }

    public String getIme() {
        return ime;
    }

    public int getKvalitet() {
        return kvalitet;
    }

    public String toString(){
        //облику М_име : квалитет.
        return "M_"+this.ime + " : " + this.kvalitet;
    }
}
