/**
 * 
 */
package sanakirjaM;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marketa
 * @version 5 Jul 2017
 *
 */
public class Relaatiot implements Iterable<Relaatio> {

    private final Collection<Relaatio> alkiot = new ArrayList<Relaatio>();
    
    
    /**
     * alustus
     */
    public Relaatiot() {
        //
    }
    
    /**
     * Lisää uuden relaation
     * @param rel lisättävä relaatio
     * @example
     * <pre name="test">
     * Relaatiot relaatiot = new Relaatiot();
     * Relaatio rel1 = new Relaatio(), rel2 = new Relaatio();
     * relaatiot.getLkm() === 0;
     * relaatiot.lisaa(rel1); relaatiot.getLkm() === 1;
     * relaatiot.lisaa(rel2); relaatiot.getLkm() === 2;
     * relaatiot.lisaa(rel1); relaatiot.getLkm() === 3;
     * relaatiot.lisaa(rel1); relaatiot.getLkm() === 4;
     * </pre>
     */
    public void lisaa(Relaatio rel) {
        alkiot.add(rel);
    }
    
    /**
     * Hakee rekisterit, joita on annetulla sanalla
     * @param sid sanan id, jolle etsitään rekisterit
     * @return lista löydetyistä rekistereistä
     * @example
     * <pre name="test">
     * #import java.util.*;
     * Relaatiot relaatiot = new Relaatiot();
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
     * relaatiot.lisaa(rel1);
     * relaatiot.lisaa(rel2);
     * relaatiot.lisaa(rel3);
     * List<Relaatio> loydetyt;
     * loydetyt = relaatiot.annaRekisterit(sid1);
     * loydetyt.size() === 2;
     * loydetyt = relaatiot.annaRekisterit(sid2);
     * loydetyt.size() === 1;
     * 
     * </pre>
     * 
     * </pre>
     */
    public List<Relaatio> annaRekisterit(int sid) {
        List<Relaatio> loydetyt = new ArrayList<Relaatio>();
        for (Relaatio relaatio : alkiot) 
            if (relaatio.getSid() == sid) loydetyt.add(relaatio);
        return loydetyt;
    }
    
    /**
     * @return relaatioiden lukumäärän
     */
    public int getLkm() {
        return alkiot.size();
    }
    
    /**
     * Iteraattori kaikkien relaatioiden läpikäymisen
     */
    @Override
    public Iterator<Relaatio> iterator() {
        return alkiot.iterator();
    }
    
    
    /**
     * Testiohjelma relaatioille
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Relaatiot relaatiot = new Relaatiot();
        Relaatio eka = new Relaatio(1,1,2);
        Relaatio toka = new Relaatio(2,1,3);
        Relaatio kolmas = new Relaatio(3,2,3,"Savomurre");
        Relaatio neljas = new Relaatio(5,4,3);
        Relaatio viides = new Relaatio(6,4,5, "lapset käyttävät");

        relaatiot.lisaa(eka);
        relaatiot.lisaa(toka);
        relaatiot.lisaa(kolmas);
        relaatiot.lisaa(neljas);
        relaatiot.lisaa(viides);
        
        eka.rekisteroi();
        toka.rekisteroi();
        kolmas.rekisteroi();
        neljas.rekisteroi();
        viides.rekisteroi();
    
        System.out.println("============= Relaatiot testi =================");
        
        List<Relaatio> relaatiot2 = relaatiot.annaRekisterit(4);
        System.out.println("Rekisterien id:t, joissa on sana id 1");
        for (Relaatio rel : relaatiot2) {
            System.out.print(rel.getRid() + "- ");
            rel.tulosta(System.out);
        }
    }




}
