// class dedena z Bojovnik
class Mag extends Bojovnik {

    /**
     * super sila
     */
    private int mana;

    /**
     * pocet na nabiti many
     */
    private int maximalniMana;

    /**
     * damage pri mane
     */
    private int magickyUtok;

    /**
     * Kontruktor Mag
     * @param jmeno
     * @param zivot
     * @param utok
     * @param obrana
     * @param kostka
     * @param mana
     * @param magickyUtok
     */
    public Mag(String jmeno, int zivot, int utok, int obrana, Kostka kostka, int mana, int magickyUtok){
        super(jmeno, zivot, utok, obrana, kostka); // to co je spolecneho s Bojovnik
        this.mana = mana;
        this.magickyUtok = magickyUtok;
        this.maximalniMana = mana;
    }

    @Override
    public void utoc(Bojovnik souper){
        //int uder = 0;
        //mana neni naplnena
        if (mana < maximalniMana){
            mana += 10;
            if (mana > maximalniMana){
                mana = maximalniMana;
            }
            //bud pouzijeme toto nebo pouzijeme od Bojovnik
            //uder = utok + kostka.hod();
            //nastavZpravu(String.format("%s utoci s uderem za %s hp", jmeno, uder));
            super.utoc(souper);
        } else {
            int uder = utok + magickyUtok + kostka.hod();
            nastavZpravu(String.format("%s pouzil k utoku svoji magii a dava uder za %s hp", jmeno, uder));
            mana = 0;
            souper.branSe(uder);
        }
    }

    public String grafickaMana(){
        return grafickyUkazatel(mana, maximalniMana);
    }
}