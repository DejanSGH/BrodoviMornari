public class Main {
    public static void main(String[] args) {
        Mornar m1 = new Mornar("A", 50), m2 = new Mornar("B", 100), m3 = new Mornar("C", 60), m4 = new
                Mornar("D", 40);
        GusarskiBrod g1 = new GusarskiBrod("Pearl", 5, m1);
        KraljevskiBrod k1 = new KraljevskiBrod("St. John", 2, m3);
        try {
            g1.dodajMornara(m2);
            g1.dodajMornara(new Mornar("E", 60));
            k1.dodajMornara(m4);
            System.out.println("Broj mornara na gusarskom brodu: " + g1.getBrojPosade());
            System.out.println("Kapetan gusarskog broda: " + g1.getKapetanBroda());
            try {
                System.out.println("Mornar kraljevskog broda na poziciji 1: " + k1.dohvatiMornara(1));
            } catch (GIndeks e) {
            }
            System.out.println("*** Ispis brodova ***");
            System.out.println(g1);
            System.out.println(k1);
            g1.napadni(k1);
            System.out.println("*** Ispis brodova nakon napada ***");
            System.out.println(g1);
            System.out.println(k1);
        } catch (Exception e) {
            System.err.println(e);
        }
        }
    }
