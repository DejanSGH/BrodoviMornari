public class Main {

    public static void main(String[] args) {

        Mornar m1 = new Mornar("Pera", 65);
        Mornar m2 = new Mornar("Mika", 32);
        Mornar m3 = new Mornar("Zika", 83);
        Mornar m4 = new Mornar("Rade", 28);
        System.out.println(m1);

        GusarskiBrod g1 = new GusarskiBrod("Black Pearl", 5, m1);
        g1.dodajMornara(m2);
        g1.dodajMornara(m3);
        g1.dodajMornara(m4);
        System.out.println(g1.getKapetanBroda());
        System.out.println(g1.getNajgoriMornar());
        try {
            System.out.println(g1.dohvatiMornara(0));
        } catch (GIndeks e) {}

        System.out.println(g1);


    }
}
