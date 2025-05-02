public class Bojovnik {
    /**
     * Jmeno bojovnika
     */
    protected String jmeno;

    /**
     * zivot v HP
     */
    protected int zivot;

    /**
     * maximalni zivot
     */
    protected int maximalniZivot;

    /**
     * utok v HP
     */
    protected int utok;

    /**
     * obrana v HP
     */
    protected int obrana;

    /**
     * instance hraci kostky
     */
    protected Kostka kostka;

    /**
     * posledni zprava
     */
    private String zprava;

    /**
     * Bojovnik
     * @param jmeno
     * @param zivot
     * @param utok
     * @param obrana
     * @param kostka
     */
    public Bojovnik(String jmeno, int zivot, int utok, int obrana, Kostka kostka){
        this.jmeno = jmeno;
        this.zivot = zivot;
        this.maximalniZivot = zivot;
        this.utok = utok;
        this.obrana = obrana;
        this.kostka = kostka;
    }

    /**
     * vrati jmeno bojovnika
     * @return jmeno
     */
    @Override
    public String toString(){
        return jmeno;
    }

    /**
     * zije bojovnik?
     */
    public boolean jeZivy(){
        return (zivot > 0);
        /**
         * to stejne jako
         * if (zivot > 0) {
         *      return true;
         * } else {
         *      return false;
         * }
         */
    }

    /**
     * ukazatel zivotu
     * @return zivot
     */
    protected String grafickyUkazatel(int aktualni, int maximalni){
        String grafickyZivot = "[";
        int celkem = 20;
        double pocetDilku = Math.round(((double) aktualni / maximalni) * celkem);
        if ((pocetDilku == 0) && (jeZivy())) {
            pocetDilku = 1;
        }
        for (int i = 0; i < pocetDilku; i++){
            grafickyZivot += "■";
        }
        for (int i = 0; i < celkem - pocetDilku; i++){
            grafickyZivot += " ";
        }
        grafickyZivot += "]";
        grafickyZivot += " " + aktualni + " hp";
        return grafickyZivot;
    }

    public void branSe(int uder){
        int zraneni = uder - (obrana + kostka.hod());
        if (zraneni > 0){
            zivot -= zraneni;
            zprava = String.format("%s utrpel poskozeni %d hp", jmeno, zraneni);
            if (zivot <= 0){
                zivot = 0;
                zprava += " a zemrel";
            }
        } else {
            zprava = String.format("%s odrazil utok", jmeno);
        }
        nastavZpravu(zprava);
    }

    public void utoc(Bojovnik souper){
        int uder = utok + kostka.hod();
        nastavZpravu(String.format("%s utoci s uderem za %s hp", jmeno, uder));
        souper.branSe(uder);
    }

    protected void nastavZpravu(String zprava){
        this.zprava = zprava;
    }

    public String vratPosledniZpravu(){
        return zprava;
    }


}
