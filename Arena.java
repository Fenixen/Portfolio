import java.sql.SQLOutput;

public class Arena {

    /**
     * prvni bojovnik
     */
    private Bojovnik bojovnikA;

    /**
     * druhy bojovnik
     */
    private Bojovnik bojovnikB;

    /**
     * hraci kostka
     */
    private Kostka kostka;

    /**
     * arena, kde bojovnici bojuji
     * @param bojovnikA
     * @param bojovnikB
     * @param kostka
     */
    public Arena(Bojovnik bojovnikA, Bojovnik bojovnikB, Kostka kostka){
        this.bojovnikA = bojovnikA;
        this.bojovnikB = bojovnikB;
        this.kostka = kostka;
    }

    /**
     * grafika
     */
    private void vykresli(){
        System.out.println("   __    ____  ____  _  _    __   \n" +
                "  /__\\  (  _ \\( ___)( \\( )  /__\\  \n" +
                " /(__)\\  )   / )__)  )  (  /(__)\\ \n" +
                "(__)(__)(_)\\_)(____)(_)\\_)(__)(__)");
        System.out.println("Zdravi bojovniku: \n");
        vypisBojovnika(bojovnikA);
        System.out.println();
        vypisBojovnika(bojovnikB);
        System.out.println();
    }
    private void vypisZpravu(String zprava){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException ex) {
            System.err.println("Chyba, nepodarilo se uspat vlakno");
        }
        System.out.println(zprava);
    }

    public void zapas(){
        Bojovnik bojovnikA = this.bojovnikA;
        Bojovnik bojovnikB = this.bojovnikB;
        System.out.println("Vitejte v arene");
        System.out.printf("Dnes se utkaji %s s %s. %n", bojovnikA, bojovnikB);
        //prohozeni bojovniku
        boolean zacinaBojovnikB = (kostka.hod() <= kostka.vratPocetSten() / 2);
        if (zacinaBojovnikB){
            bojovnikA = this.bojovnikB;
            bojovnikB = this.bojovnikA;
        }
        System.out.println("Zacinat bude bojovnik " + bojovnikA + "\nZapas muze zacit...");

        // cyklus s bojem
        while (bojovnikA.jeZivy() && bojovnikB.jeZivy()){
            bojovnikA.utoc(bojovnikB);
            vykresli();
            vypisZpravu(bojovnikA.vratPosledniZpravu()); // zprava o utoku
            vypisZpravu(bojovnikB.vratPosledniZpravu()); // zprava o obrane
            if (bojovnikB.jeZivy()) {
                bojovnikB.utoc(bojovnikA);
                vykresli();
                vypisZpravu(bojovnikB.vratPosledniZpravu()); // zprava o utoku
                vypisZpravu(bojovnikA.vratPosledniZpravu()); // zprava o obrane
            }
            System.out.println();
        }
        if (bojovnikA.jeZivy()){
            System.out.printf("Vyhrava bojovnik %s%n", bojovnikA);
        }
        else if (bojovnikB.jeZivy()){
            System.out.printf("Vyhrava bojovnik %s%n", bojovnikB);
        }
    }

    private void vypisBojovnika(Bojovnik bojovnik){
        System.out.println(bojovnik);
        System.out.print("Zivot: ");
        System.out.println(bojovnik.grafickyUkazatel(bojovnik.zivot, bojovnik.maximalniZivot));
        if (bojovnik instanceof Mag){
            System.out.print("Mana: ");
            System.out.println(((Mag) bojovnik).grafickaMana());
        }
    }

}
