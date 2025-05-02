public class TahovyBoj {
    public static void main (String[] args){
        Kostka kostka = new Kostka(10);
        Bojovnik titan = new Bojovnik("Titan", 150, 45, 10, kostka);
        Bojovnik phoebe = new Bojovnik("Phoebe", 80, 50, 10, kostka);
        Bojovnik killer = new Bojovnik("Killer", 80, 55, 15, kostka);
        Bojovnik master = new Bojovnik("Master", 120, 55, 5, kostka);
        Bojovnik infinite = new Bojovnik("Infinite", 240, 10, 10, kostka);
        Bojovnik jupiter = new Bojovnik("Jupiter", 200, 73, 22, kostka);

        // toto je Mag - promenny typ je Bojovnik - dedicnost z Bojovnik
        Bojovnik gandalf = new Mag("Gandalf", 60, 30, 15, kostka, 30, 40);
        Bojovnik ultimateBoss = new Mag("Ultimate Boss", 120, 50, 0, kostka, 30, 20);

        Bojovnik boss = new Bojovnik("Boss", 100, 50, 20, kostka);
        Arena arena = new Arena(ultimateBoss, killer  , kostka);

        arena.zapas();









    }
}
