import java.util.Random;

/**
 * Trida reprezentuje hraci kostku
 */
public class Kostka {
    /**
     * Generator nahodnych cisel
     */
    private Random random;

    /**
     * Pocet sten kostky
     */
    private int pocetSten;

    /**
     * Vytvori novou instanci hraci kostky
     */
    public Kostka(int pocetSten){    // toto je konstruktor
        this.pocetSten = pocetSten;
        random = new Random();
    }

    public Kostka(){  // toto je dalsi konstruktor bez parametru
        pocetSten = 6;
        random = new Random();
    }

    /**
     * Vrati pocet sten hraci kostky
     * @return Pocet sten hraci kostky
     */
    public int vratPocetSten() {
        return pocetSten;
    }

    /**
     * Vykona hod kostkou
     * @return cislo od 1 do poctu sten
     */
    public int hod(){
        return random.nextInt(pocetSten) + 1;
    }

    /**
     * Vraci textovou reprezenataci kostky
     * @return Textova reprezentace kostky
     */
    @Override
    public String toString(){
        return String.format("Kostka s %s stenami", pocetSten);
    }
}

