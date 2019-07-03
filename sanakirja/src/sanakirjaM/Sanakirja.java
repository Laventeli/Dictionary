/**
 * 
 */
package sanakirjaM;

import java.util.List;

/**
 * @author Marketa
 * @version 1 Jul 2017
 *
 */
public class Sanakirja {

    private final Sanat sanat = new Sanat(); // final - ei voi enää kirjoittaa että se on null
    private final Rekisterit rekisterit = new Rekisterit();
    private final Relaatiot relaatiot = new Relaatiot();
    /**
     * Palauttaa i:n sanan
     * @param i monesko sana palautetaan
     * @return viite i:teen sanaan
     * @throws IndexOutOfBoundsException jos i väärin
     */
    public Sana annaSana(int i) throws IndexOutOfBoundsException{
       return sanat.anna(i);
    }


    /**
     * Palauttaa sanakirjan sanamäärän
     * @return sananmäärä
     */
    public int getSanojaLkm() {
        return sanat.getLkm();
    }
    
    /**
     * Palauttaa rekisterien lukumäärän
     * @return lukumäärä
     */
    public int getRekisteriaLkm() {
        return rekisterit.getLkm();
    }

    /**
     * Lisää sanakirjaan uuden sanan
     * @param sana lisättävä sana
     * @throws SailoException jos lisäystä ei voida tehdä
     * @example
     * <pre name="test">
     * #THROWS SailoException
     * Sanakirja sanakirja = new Sanakirja();
     * Sana koira1 = new Sana(), koira2 = new Sana();
     * koira1.rekisteroi(); koira2.rekisteroi();
     * sanakirja.getSanojaLkm() === 0;
     * sanakirja.lisaa(koira1); sanakirja.getSanojaLkm() === 1;
     * sanakirja.lisaa(koira2); sanakirja.getSanojaLkm() === 2;
     * sanakirja.lisaa(koira1); sanakirja.getSanojaLkm() === 3;
     * sanakirja.annaSana(0) === koira1;
     * sanakirja.annaSana(1) === koira2;
     * sanakirja.annaSana(2) === koira1;
     * sanakirja.annaSana(3) === koira1; #THROWS IndexOutOfBoundsException
     * sanakirja.lisaa(koira1); sanakirja.getSanojaLkm() === 4;
     * sanakirja.lisaa(koira1); sanakirja.getSanojaLkm() === 5;
     * sanakirja.lisaa(koira1); #THROWS SailoException
     * </pre>
     */
    public void lisaa(Sana sana) throws SailoException {
        sanat.lisaa(sana);
    }
    
    /**
     * Lisää sanakirjaan uuden rekisterin
     * @param rekisteri lisättävä rekisteri
     * @example
     * Sanakirja sanakirja = new Sanakirja();
     * Rekisteri yleiskieli1 = new Rekisteri(), yleiskieli2 = new Rekisteri();
     * yleiskieli1.rekisteroi(); yleiskieli2.rekisteroi();
     * sanakirja.getRekisteriaLkm() === 0;
     * sanakirja.lisaa(yleiskieli1); sanakirja.getRekisteriaLkm() === 1;
     * sanakirja.lisaa(yleiskieli2); sanakirja.getRekisteriaLkm() === 2;
     * sanakirja.lisaa(yleiskieli1); sanakirja.getRekisteriaLkm() === 3;
     * <pre name="test">
     * </pre>
     */
    public void lisaa(Rekisteri rekisteri) {
        rekisterit.lisaa(rekisteri);
    }
    
    /**
     * Lisää sanakirjaan uuden relaation
     * @param relaatio lisättävä relaatio
     */
    public void lisaa(Relaatio relaatio) {
        relaatiot.lisaa(relaatio);
    }
    
    /**
     * Lisää uuden relaation
     * @param sana sanan id
     * @param rekisteri rekisterin id
     */
    public void lisaa(Sana sana, Rekisteri rekisteri) {
        Relaatio uusi = new Relaatio(sana.getSid(), rekisteri.getRekNro());
        uusi.rekisteroi();
        relaatiot.lisaa(uusi);
    }
    
    /**
     * Palautaa annetun sanan relaatioiden listan.
     * @param sana sana,jonka rekisterit etsitään
     * @return lista sanan relaatioista
     * @example
     * <pre name="test">
     * #import java.util.*;
     * Sanakirja sanakirja = new Sanakirja();
     * Sana koira1 = new Sana(), koira2 = new Sana(), koira3 = new Sana();
     * koira1.rekisteroi(); koira2.rekisteroi(); koira3.rekisteroi();
     * int sid1 = koira1.getSid();
     * int sid2 = koira2.getSid();
     * Rekisteri rek1 = new Rekisteri(), rek2 = new Rekisteri(), rek3 = new Rekisteri();
     * int rid1 = rek1.rekisteroi(); 
     * int rid2 = rek2.rekisteroi(); 
     * int rid3 = rek3.rekisteroi();
     * Relaatio rel1 = new Relaatio(sid1, rid1);
     * Relaatio rel2 = new Relaatio(sid1, rid2);
     * Relaatio rel3 = new Relaatio(sid2, rid3);
     * sanakirja.lisaa(rel1);
     * sanakirja.lisaa(rel2);
     * sanakirja.lisaa(rel3);
     * List<Relaatio> loydetyt;
     * loydetyt = sanakirja.annaRekisterit(koira1);
     * loydetyt.size() === 2;
     * loydetyt = sanakirja.annaRekisterit(koira2);
     * loydetyt.size() === 1;
     * 
     * </pre>
     */
    public List<Relaatio> annaRekisterit(Sana sana) {
        int sid = sana.getSid();
        List<Relaatio> loydetyt = relaatiot.annaRekisterit(sid);
        return loydetyt;
    }
    
    /**
     * Palauttaa rekisterin sen id:n perusteella
     * @param rid rekisterin id
     * @return rekisteri
     */
    public Rekisteri getRekisteri(int rid) {
        Rekisteri rekisteri = rekisterit.getRekisteri(rid);
        return rekisteri;
    }
    
    /**
     * Palauttaa rekisterin nimen perusteella
     * @param nimi rekisterin nimi
     * @return rekisteri
     */
    public Rekisteri getRekisteri(String nimi) {
        Rekisteri rekisteri = rekisterit.getRekisteri(nimi);
        return rekisteri;
    }
    
    /**
     * Palauttaa sanan id:n perusteella
     * @param sid sanan id
     * @return sana
     */
    public Sana getSana(int sid) {
        Sana sana = sanat.getSana(sid);
        return sana;
    }
    
    /**
     * Palauttaa sanan nimen perusteella
     * @param nimi sanan nimi
     * @return nimi
     */
    public Sana getSana(String nimi) {
        Sana sana = sanat.getSana(nimi);
        return sana;
    }
    
    /**
     * Testiohjelma sanakirjasta
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Sanakirja sanakirja = new Sanakirja();
        
        try {
            Sana koira1 = new Sana();
            Sana koira2 = new Sana();
            Sana koira3 = new Sana();
        
            koira1.rekisteroi();
            koira1.taytaKoira();
            koira2.rekisteroi();
            koira2.taytaKoira();
            koira3.rekisteroi(); 
            koira3.taytaKoira();
            
            sanakirja.lisaa(koira1);
            sanakirja.lisaa(koira2);
            sanakirja.lisaa(koira3);
            
            int sid1 = koira1.getSid();
            int sid2 = koira2.getSid();
            int sid3 = koira3.getSid();
            
            Rekisteri yleiskieli1 = new Rekisteri();
            Rekisteri yleiskieli2 = new Rekisteri();
            Rekisteri yleiskieli3 = new Rekisteri();
            
            yleiskieli1.rekisteroi();
            yleiskieli2.rekisteroi();
            yleiskieli3.rekisteroi();
            
            yleiskieli1.taytaRekisteri();
            yleiskieli2.taytaRekisteri();
            yleiskieli3.taytaRekisteri();
            
            
            int rid1 = yleiskieli1.getRekNro();
            int rid2 = yleiskieli2.getRekNro();
            int rid3 = yleiskieli3.getRekNro();
            
            
            sanakirja.lisaa(yleiskieli1);
            sanakirja.lisaa(yleiskieli2);
            sanakirja.lisaa(yleiskieli3);
            
            Relaatio rel1 = new Relaatio(sid1, rid1);
            Relaatio rel2 = new Relaatio(sid1, rid2);
            Relaatio rel3 = new Relaatio(sid2, rid3);
            Relaatio rel4 = new Relaatio(sid3, rid3);
            
            rel1.rekisteroi();
            rel2.rekisteroi();
            rel3.rekisteroi();
            rel4.rekisteroi();
    
            sanakirja.lisaa(rel1);
            sanakirja.lisaa(rel2);
            sanakirja.lisaa(rel3);
            sanakirja.lisaa(rel4);
            
            System.out.println("===============Sanakirjan testi===============");
        
            for(int i = 0; i < sanakirja.getSanojaLkm(); i++) {
                Sana sana = sanakirja.annaSana(i);
                System.out.println("Sana paikassa: " + i);
                sana.tulosta(System.out);
                List<Relaatio> loydetty = sanakirja.annaRekisterit(sana);
                
                for (Relaatio relaatio : loydetty) {
                    int rid = relaatio.getRid();
                    Rekisteri rekisteri = sanakirja.rekisterit.getRekisteri(rid);
                    rekisteri.tulosta(System.out);
                }
            }
           
        } catch (SailoException e) {
            System.err.println("Vikaa: " + e.getMessage());
        }
    }

}
