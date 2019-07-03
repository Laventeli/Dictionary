/**
 * 
 */
package sanakirjaM;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Rekisterit-luokka, joka osaa mm. lisätä uuden rekisterin
 * @author Marketa
 * @version 3 Jul 2017
 *
 */
public class Rekisterit implements Iterable<Rekisteri>{

   // private String tiedostonNimi = "";
    
    private final Collection<Rekisteri> alkiot = new ArrayList<Rekisteri>();
    
    /**
     * Alustus
     */
    public Rekisterit() {
        ///
    }
    
    /**
     * Lisää uuden rekisterin tietorakenteeseen.
     * @param rekisteri lisättävän rekisterin viite.
     * @example
     * <pre name="test">
     * Rekisterit rekisterit = new Rekisterit();
     * Rekisteri yleiskieli1 = new Rekisteri(), yleiskieli2 = new Rekisteri();
     * rekisterit.getLkm() === 0;
     * rekisterit.lisaa(yleiskieli1); rekisterit.getLkm() === 1;
     * rekisterit.lisaa(yleiskieli2); rekisterit.getLkm() === 2;
     * rekisterit.lisaa(yleiskieli1); rekisterit.getLkm() === 3;
     * rekisterit.lisaa(yleiskieli1); rekisterit.getLkm() === 4;
     * </pre>
     */
    public void lisaa(Rekisteri rekisteri) {
        alkiot.add(rekisteri);
    }
    
     /**
     * Palauttaa sanakirjan rekisterien lukumäärän
     * @return rekisterien lukumäärä
     */
    public int getLkm() {
        return alkiot.size();
    }

    /**
     * Annetaan rekisteri rid:n perusteella
     * @param rid rekisterin id
     * @return rekisteri, joka vastaa annettua id:tä
     */
    public Rekisteri getRekisteri(int rid) {
        Rekisteri rekisteri = new Rekisteri();
        for (Rekisteri rek : alkiot) {
            if (rek.getRekNro() == rid) rekisteri = rek;
        }
        return rekisteri;
    }
    
    /**
     * Anetaan rekisteri nimen perusteella
     * @param nimi rekisterin nimi
     * @return rekisteri, joka vastaa annettua nimeä
     * @example
     * <pre name="test">
     * Rekisterit rekisterit = new Rekisterit();
     * Rekisteri rek1 = new Rekisteri();
     * rek1.taytaRekisteri();
     * rek1.rekisteroi(); 
     * rekisterit.lisaa(rek1);
     * rekisterit.getRekisteri("yleiskieli") === rek1;
     * </pre>
     */
    public Rekisteri getRekisteri(String nimi) {
        Rekisteri rekisteri = new Rekisteri();
        for (Rekisteri rek : alkiot) {
            if (rek.getNimi() == nimi) rekisteri = rek;
        }
        return rekisteri;
    }
    
    
    /**
     * Iteraattori kaikkien rekisterien läpikäymisen
     */
    @Override
    public Iterator<Rekisteri> iterator() {
        return alkiot.iterator();
    }
    
    /**
     * Testiohjelma rekisterille
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Rekisterit rekisterit = new Rekisterit();
        
        Rekisteri yleiskieli1 = new Rekisteri();
        Rekisteri yleiskieli2 = new Rekisteri();
        Rekisteri yleiskieli3 = new Rekisteri();
        
        yleiskieli1.taytaRekisteri();
        yleiskieli2.taytaRekisteri();
        yleiskieli3.taytaRekisteri();
        
        yleiskieli1.rekisteroi();
        yleiskieli2.rekisteroi();
        yleiskieli3.rekisteroi();
        
       
        rekisterit.lisaa(yleiskieli1);
        rekisterit.lisaa(yleiskieli2);
        rekisterit.lisaa(yleiskieli3);
        
        System.out.println("============= Rekisterin testi =================");
        /*
        List<Rekisteri> rekisterit2 = rekisterit.annaRekisterit(2);
        for (Rekisteri rekisteri : rekisterit2) {
            System.out.print(rekisteri.getSananId() + " ");
            rekisteri.tulosta(System.out);
        } */
    }
}
