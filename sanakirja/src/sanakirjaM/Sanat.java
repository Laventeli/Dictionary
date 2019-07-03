package sanakirjaM;

/**
 * Sanat-luokka, joka osaa mm. lis‰t‰ uuden sanan
 * @author Marketa
 * @version 1 Jul 2017
 *
 */
public class Sanat {
    
    private static final int MAX_SANOJA = 5;
    private Sana[] alkiot = new Sana[MAX_SANOJA];
    private int lkm;
  //  private String tiedostonNimi = "";
    
    /**
     * alustus
     */
    public Sanat() {
        ///
    }
    
    
    /**
    * Lis‰‰ uuden sanan tietorakenteeseen. Ottaa sanan omistukseensa.
    * @param sana lis‰tt‰v‰n sanan viite.
    * @throws SailoException Poikkeus joka heitet‰‰n
    * @example
    * <pre name="test">
    * #THROWS SailoException 
    * Sanat sanat = new Sanat();
    * Sana koira1 = new Sana(), koira2 = new Sana();
    * sanat.getLkm() === 0;
    * sanat.lisaa(koira1); sanat.getLkm() === 1;
    * sanat.lisaa(koira2); sanat.getLkm() === 2;
    * sanat.lisaa(koira1); sanat.getLkm() === 3;
    * sanat.anna(0) === koira1;
    * sanat.anna(1) === koira2;
    * sanat.anna(2) === koira1;
    * sanat.anna(1) == koira1 === false;
    * sanat.anna(1) == koira2 === true;
    * sanat.anna(3) === koira1; #THROWS IndexOutOfBoundsException 
    * sanat.lisaa(koira1); sanat.getLkm() === 4;
    * sanat.lisaa(koira1); sanat.getLkm() === 5;
    * sanat.lisaa(koira1);  #THROWS SailoException
    * </pre>
    */
    public void lisaa(Sana sana) throws SailoException {
        if (lkm >= alkiot.length) throw new SailoException("Liikaa alkioita");
        alkiot[lkm++] = sana;
    }
    
    /**
     * Palauttaa viitten i:teen sanaan
     * @param i monennenko sanan viite halutaan
     * @return viite sanaan, jonka indeksi on i
     * @throws IndexOutOfBoundsException jos i ei ole sallittu
     */
    public Sana anna(int i) throws IndexOutOfBoundsException {
        if (i < 0 || lkm <= i)
            throw new IndexOutOfBoundsException("Laiton indeksi: " + i);
        return alkiot[i];
    }
    
    /**
     * Palauttaa sanakirjan sanojen lukum‰‰r‰n
     * @return sanojen lukum‰‰r‰
     */
    public int getLkm() {
        return lkm;
    }
    
    /**
     * Palauttaa sanan id:n perusteella
     * @param sid sanan id
     * @return sana, joka palautetaan
     */
    public Sana getSana(int sid) {
        Sana sana = new Sana();
        for (Sana sanaNyt : alkiot) {
            if (sanaNyt.getSid() == sid) sana = sanaNyt;
        }
        return sana;
    }
    
    /**
     * Palauttaa sanan nimen perusteella 
     * @param nimi sanan nimi
     * @return sana, joka palautetaan
     */
    public Sana getSana(String nimi) {
        Sana sana = new Sana();
        for (Sana sanaNyt : alkiot) {
            if (sana.getNimi() == nimi) sana = sanaNyt;
        }
        return sana;
    }

    /**
     * Palauttaa etsitt‰v‰n sanan indeksi alkiot-taulukossa
     * @param sana sana,jonka indeksi etsit‰‰n
     * @return sanan indeksi
     */
    public int getSananIndex(Sana sana) {
        int sid = sana.getSid();
        for (int i = 0; i < alkiot.length; i++) {
            if (sid == alkiot[i].getSid()) return i;
        }
        return -1;
    }
    
    /**
     * Testiohjelma sanastolle
     * @param args ei k‰ytˆss‰
     */
    public static void main(String[] args) {
        Sanat sanat = new Sanat();
        
        Sana koira1 = new Sana();
        Sana koira2 = new Sana();
        
        koira1.taytaKoira();
        koira2.taytaKoira();

        koira1.rekisteroi();
        koira2.rekisteroi();
        
        
        try {
            sanat.lisaa(koira1);
            sanat.lisaa(koira2);
        
        System.out.println("==========Sanat testi===========");
    
        for (int i = 0; i < sanat.getLkm(); i++) {
            Sana sana = sanat.anna(i);
            System.out.println("Sanan nro: " + i);
            sana.tulosta(System.out);
        }
        
        Sana koira3 = new Sana();
        koira3.taytaKoira();
        koira3.rekisteroi();
        sanat.lisaa(koira3);
        sanat.lisaa(koira3);
        sanat.lisaa(koira3);
        sanat.lisaa(koira3);
        sanat.lisaa(koira3);
        
        } catch (SailoException e) {
            System.err.println(e.getMessage());
        }
        
        System.out.println("==========Sanat testi===========");
        
        for (int i = 0; i < sanat.getLkm(); i++) {
            Sana sana = sanat.anna(i);
            System.out.println("Sanan nro: " + i);
            sana.tulosta(System.out);
        }
    }

}
