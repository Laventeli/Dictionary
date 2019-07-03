/**
 * 
 */
package sanakirjaM;

import java.io.PrintStream;

/**
 * @author Marketa
 * @version 5 Jul 2017
 *
 */
public class Relaatio {
    
    private int sid; //sanan id
    private int rid; //rekisterin id
    private int relId; // relaation id
    private String merkinta = "";
    
    private static int seuraavaNro = 1;
    
    /**
     * alustus
     */
    public Relaatio() {
        //
    }
    
    /**
     * Alustetaan relaation
     * @param relId relaation id
     * @param sid sanan id
     * @param rid rekisterin id
     * @param merkinta merkinta
     */
    public Relaatio(int relId, int sid, int rid, String merkinta) {
        this.relId = relId; 
        this.sid = sid;
        this.rid = rid;
        this.merkinta = merkinta;
    }
    
    /**
     * Alustetaan relaation
     * @param sid sanan id
     * @param rid rekisterin id
     * @param relId relaation id
     */
    public Relaatio(int relId, int sid, int rid) {
        this.relId = relId; 
        this.sid = sid;
        this.rid = rid;
        this.merkinta = "ei tietty murre";
    }
    
    /**
     * ALustetaan relaation
     * @param sid sanan id
     * @param rid rekisterin id
     */
    public Relaatio(int sid, int rid) {
        this.sid = sid;
        this.rid = rid;
        this.merkinta = "ei tietty murre";
    }
    
    /**
     * apumetodi, täytetään testiarvot
     * @param sana viite sanan tietoihin
     * @param rekisteri viite rekisterin tietoihin
     */
    public void taytaRelaatio(int sana, int rekisteri) {
        sid = sana;
        rid = rekisteri;
        merkinta = "ei tietty murre";
    }
    
    /**
     * Tulostetaan sanan tiedot
     * @param out tietovirta johon tulostetaan
     */ 
    public void tulosta(PrintStream out) {
        out.println("Relaation id: " + relId + "; sanan id: " + sid + "; rekisterin id: " + rid);
        out.println("Merkintä: " + merkinta);
    }
    
    /**
     * Antaa relaatiolle seuraavan id numeron
     * @return relaation uusi id numero
     * @example
     * <pre name="test">
     * Relaatio rel1 = new Relaatio();
     * rel1.getIdNro() === 0;
     * rel1.rekisteroi();
     * Relaatio rel2 = new Relaatio();
     * rel2.rekisteroi();
     * int n1 = rel1.getIdNro();
     * int n2 = rel2.getIdNro();
     * n1 === n2-1;
     * </pre>
     */
    public int rekisteroi() {
        if(relId != 0) return relId;
        relId = seuraavaNro++;
        return relId;
    }
    
    /**
     * @return relaation id
     */
    public int getIdNro() {
        return relId;
    }
    
    /** Palautetaan sanan id numero
     * @return sanan id
     */
    public int getSid() {
        return sid;
    }
    
    /** Palautetaan rekisterin id numero
     * @return rekisterinn id
     */
    public int getRid() {
        return rid;
    }
    
    @Override
    public String toString() {
        return getIdNro() + "|" + getSid() + "|" + getRid();
    }
    
    /**
     * Testiohjelma Relaatiolle
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Relaatio rel1 = new Relaatio();
        Relaatio rel2 = new Relaatio();
        Relaatio rel3 = new Relaatio();
        Relaatio rel4 = new Relaatio();
        Relaatio rel5 = new Relaatio();
        Relaatio rel6 = new Relaatio();
        
        rel1.taytaRelaatio(1, 1);
        rel2.taytaRelaatio(1, 2);
        rel3.taytaRelaatio(2, 2);
        rel4.taytaRelaatio(3, 3);
        rel5.taytaRelaatio(4, 3);
        rel6.taytaRelaatio(4, 5);
        
        rel1.rekisteroi();
        rel2.rekisteroi();
        rel3.rekisteroi();
        rel4.rekisteroi();
        rel5.rekisteroi();
        rel6.rekisteroi();
        
        rel1.tulosta(System.out);
        rel2.tulosta(System.out);
        rel3.tulosta(System.out);
        rel4.tulosta(System.out);
        rel5.tulosta(System.out);
        rel6.tulosta(System.out);
            
    }

}
