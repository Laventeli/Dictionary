/**
 * 
 */
package sanakirjaM;


import java.io.OutputStream;
import java.io.PrintStream;


/**
 * Rekisteri, joka osaa mm. itse huolehtia idnro:staan
 * @author Marketa
 * @version 3 Jul 2017
 *
 */
public class Rekisteri {
    
    private int rid;
//    private int sanaNro;
    private String nimi = "";
    
    
    private static int seuraavaNro = 1;
    
    /**
     * Alustus
     */
    public Rekisteri() {
        ///
    }
    
    /**
     * Tulostetaan rekisterin tiedot
     * @param out tietovirta johon tulostetaan
     */
    public void tulosta(PrintStream out) {
        if (rid == 0 || nimi == null) return;
        out.println("RekisterinID: " + String.format("%03d", this.rid) + "; Nimi: " + nimi);
    }
    
    /**
     * Tulostetaan rekisterin tiedot
     * @param os tietovirta johon tulostetaan
     */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    } 
    
    /**
     * Saadaan täytettyä testiarvot rekisterille
     */
    public void taytaRekisteri() {
        nimi = "yleiskieli";
    }
    
    /**
     * Antaa rekisterille seuraavan rekisterinumeron
     * @return rekisterin uusi id numero
     * @example
     * <pre name="test">
     *  Rekisteri yleiskieli1 = new Rekisteri();
     *  yleiskieli1.getRekNro() === 0;
     *  yleiskieli1.rekisteroi();
     *  Rekisteri yleiskieli2 = new Rekisteri();
     *  yleiskieli2.rekisteroi();
     *  int n1 = yleiskieli1.getRekNro();
     *  int n2 = yleiskieli2.getRekNro();
     *  n1 === n2-1;
     * </pre>
     */
    public int rekisteroi() {
        rid = seuraavaNro++;
        return rid;
    }
    
    /**
     * Palautetaan rekisterin nimi.
     * @return rekisterin nimi
     */
    public String getNimi() {
        return nimi;
    }
    
    /**
     * @return rekisterin id numero
     */
    public int getRekNro() {
        return rid;
    }
    
    @Override
    public String toString() {
        return getRekNro() + "|" + nimi;
    }
    
    /**
     * Asetetaan rekisterille annettu id
     * @param id asetettava id
     */
    public void setRid(int id) {
        rid = id;
        if (rid >= seuraavaNro) seuraavaNro = rid + 1;
    }
    
    /**
     * Sanan rekisteri-luokka
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Rekisteri puhekieli1 = new Rekisteri();
        Rekisteri puhekieli2 = new Rekisteri();
        Rekisteri puhekieli3 = new Rekisteri();
        
        puhekieli1.rekisteroi();
        puhekieli2.rekisteroi();
        puhekieli3.rekisteroi();
        
        puhekieli1.taytaRekisteri();
        puhekieli2.taytaRekisteri();
        puhekieli3.taytaRekisteri();
        
        puhekieli1.tulosta(System.out);
        puhekieli2.tulosta(System.out);
        puhekieli3.tulosta(System.out);
    
    }

}
