package sanakirjaM;

import java.io.OutputStream;
import java.io.PrintStream;

import static kanta.LisattyTarkastus.*;

/**
 * Sanakirjan sana, joka osaa mm. itse huolehtia tunnusNro:staan
 * @author Marketa
 * @version 1 Jul 2017
 */
public class Sana {
    
    private int sid;
    private String nimi = "";
    private String kaannos = "";
    private String sanaluokka = "";
    private String maaritelma = "";
    private String synonyymi = "";
    private String esimerkki = "";
    private String sanonta = "";
    private String status = "";
    private String lisatty = "";
    
    private static int seuraavaNro = 1;
    
    /**
     * Tulostetaan sanan tiedot
     * @param out tietovirta johon tulostetaan
     */
    public void tulosta(PrintStream out) {
        out.println(String.format("%03d", sid) + " " + nimi);
        out.println(" Käännös: " + kaannos);
        out.println(" Sanaluokka: " + sanaluokka);
        out.println(" Määritelmä: " + maaritelma);
        out.println(" Synonyymi: " + synonyymi);
        out.println(" Esimerkki: " + esimerkki);
        out.println(" Sanonta: " + sanonta);
        out.println(" Status: " + status + "; Lisätty: " + lisatty);
    }
    
    /**
     * Tulostetaan sanan tiedot
     * @param os tietovirta johon tulostetaan
     */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }
    
    /**
     * Apumetodi, jolla saadaan täytettyä testiarvot sanalle
     */
    public void taytaKoira() {
       nimi = "koira " + rand(1000, 9999);
       kaannos = "dog";
       sanaluokka = "substantiivi";
       maaritelma = "nelijalkainen seuraeläin";
       synonyymi = "hauva";
       esimerkki = "Eilen hain koiran.";
       sanonta = "Ei haukkuva koira pure.";
       status = "opittu";
       lisatty = arvoLisatty();;
        
    }
    
    /**
     * @return sanan nimen
     */
    public String getNimi() {
        return nimi;
    }
    
    /**
     * Antaa sanalle seuraavan id numeron
     * @return sanan uusi idNumero
     * @example
     * <pre name="test">
     * Sana koira1 = new Sana();
     * koira1.getSid() === 0;
     * koira1.rekisteroi();
     * Sana koira2 = new Sana();
     * koira2.rekisteroi();
     * int n1 = koira1.getSid();
     * int n2 = koira2.getSid();
     * n1 === n2-1;
     * </pre>
     */
    public int rekisteroi() {
        if (sid != 0) return sid;
        sid = seuraavaNro++;
        return sid;
    }
    
    /**
     * Palauttaa sanan id numeron
     * @return idNro
     */
    public int getSid() {
        return sid;
    }
    
    @Override
    public String toString() {
        return getSid() + "|" +
                nimi + "|" +
                kaannos + "|" +
                sanaluokka + "|" +
                maaritelma + "|" +
                synonyymi + "|" +
                esimerkki + "|" +
                sanonta + "|" +
                status + "|" +
                lisatty; 
    }
    
    /**
     * Testiohjelma Sana-luokalle
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Sana koira = new Sana();
        Sana koira2 = new Sana();
        Sana koira3 = new Sana();
        
        koira.rekisteroi();
        koira2.rekisteroi();
        koira3.rekisteroi();
      //  koira.tulosta(System.out);
        koira.taytaKoira();
        koira2.taytaKoira();
        koira3.taytaKoira();
        
        koira.tulosta(System.out);
        koira2.tulosta(System.out);
        koira3.tulosta(System.out);
    
    }

}
