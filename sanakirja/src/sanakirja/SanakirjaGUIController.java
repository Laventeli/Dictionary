package sanakirja;
 
import java.io.PrintStream;
//import java.awt.Desktop;
//import java.io.IOException;
//import java.net.URI;
//import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import fi.jyu.mit.fxgui.TextAreaOutputStream;
//import fi.jyu.mit.fxgui.ModalController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import sanakirjaM.Rekisteri;
import sanakirjaM.Relaatio;
import sanakirjaM.SailoException;
import sanakirjaM.Sana;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
import sanakirjaM.Sanakirja;

/**
 * Luokka k‰yttˆliittym‰n tapahtumien hoittamiseksi
 * @author Marketa
 * @version 31 May 2017
 *
 */
public class SanakirjaGUIController implements Initializable {
    
    
    @FXML private ListChooser<Sana> chooserSanat;
    
    @FXML private ScrollPane panelSana;
    
    @FXML private void handleUusiRekisteri() {
        uusiRekisteri();
    }
    
    @FXML private void handlePoistaRekisteri() {
        Dialogs.showMessageDialog("Ei osata viel‰ poistaa");
    }
    
    @FXML private void handlePoistaSana() {
        Dialogs.showMessageDialog("Ei osata viel‰ poistaa sanaa");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
         alusta();      
    }
    
    @FXML private void handleTulosta() {
    	TulostusController.tulosta(null);
    } 
    
  
    @FXML private void handleAvaaAlku() {
       SanakirjanNimiController.avaa(null);
    }

	@FXML private void handleHakeminen() {
        Dialogs.showMessageDialog("Ei voi viel‰ hakea");
    }
    
    @FXML private void handleMuokkaaSana() {
        MuokkaaminenController.muokkaa(null);
    }
    
    @FXML private void handleLisaaSana() {
    //	LisaaminenController.lisaa(null);
        uusiSana();
    }
    
    
    /**
     * K‰sitell‰‰n tallennusk‰sky
     */
    @FXML private void handleTallenna() {
        tallenna();
    }
    
    
    /**
     * K‰sitell‰‰n lopetusk‰sky
     */
    @FXML private void handleLopeta() {
        tallenna();
        Platform.exit();
    }

    /**
     * Tarkistetaan onko tallennus tehty
     * @return true jos saa sulkaa sovelluksen, false jos ei
     */
    public boolean voikoSulkea() {
        tallenna();
        return true;
    }
    
    @FXML private void handleTietoja() {
             Dialogs.showMessageDialog("Ei osata viel‰ tietoja");
         }
    
  //===========================================
    private Sanakirja sanakirja;
    private TextArea areaSana = new TextArea();
    private Sana sanaKohdalla;

    
    /**
     * Tekee uuden sanan editointia varten
     */
    public void uusiSana() {
        
        Sana uusi = new Sana();
        uusi.rekisteroi();
        uusi.taytaKoira();
        try {
            sanakirja.lisaa(uusi);
        } catch (SailoException e) {
            Dialogs.showMessageDialog("Ongelmia uuden luomisessa: " + e.getMessage());
            return;
        }
        hae(uusi.getSid());
    }
    
    /**
     * Tekee uuden rekisterin
     */
    public void uusiRekisteri() {
        if (sanaKohdalla == null) return;
        Rekisteri rekisteri = new Rekisteri();
        rekisteri.rekisteroi();
        rekisteri.taytaRekisteri();
        
        uusiRelaatio(rekisteri);
        sanakirja.lisaa(rekisteri);
        hae(sanaKohdalla.getSid());
    }
    
    /**
     * Luo uusi relaatio, jossa on sanan sek‰ rekisterin id:t
     * @param rekisteri rekisteri, jolle luodaan relaatio
     */
    public void uusiRelaatio(Rekisteri rekisteri) {
        Relaatio rel = new Relaatio();
        rel.rekisteroi();
        rel.taytaRelaatio(sanaKohdalla.getSid(), rekisteri.getRekNro());
        sanakirja.lisaa(rel);
    }
    
    /**
     * Hae sanan tiedot listaan
     * @param sanaNro sanan numero, joka aktivoidaan haun j‰lkeen
     */
    protected void hae(int sanaNro) {
        chooserSanat.clear();
        int index = 0;
        for (int i = 0; i < sanakirja.getSanojaLkm(); i++) {
            Sana sana = sanakirja.annaSana(i);
            if (sana.getSid() == sanaNro) index = i;
            chooserSanat.add(sana.getNimi(), sana);
        }
        chooserSanat.getSelectionModel().select(index);
        
    }
    
    /**
     * Tietojen tallennus
     */
    private void tallenna() {
        Dialogs.showMessageDialog("Tallennetetaan! Mutta ei toimi viel‰");
    }

    /**
     * Alustaa GridPanen tilalle yksi is tekstikentt‰, johon voi tulostaa sanojen
     * tiedot. Alustetaan myˆs sanalistan kuuntelija
     */
    protected void alusta() {
        panelSana.setContent(areaSana);
        areaSana.setFont(new Font("Courier New", 12));
        panelSana.setFitToHeight(true);
        
        chooserSanat.clear();
        chooserSanat.addSelectionListener(e -> naytaSana());
    }
    
    /**
     * N‰ytt‰‰ listasta valitun sanan tiedot, tilap‰isesti yhteen isoon edit-kentt‰‰n
     */
    protected void naytaSana() {
        sanaKohdalla = chooserSanat.getSelectedObject();
        
        if (sanaKohdalla == null) return;
        
        areaSana.setText("");
        try (PrintStream os = TextAreaOutputStream.getTextPrintStream(areaSana)) {
            tulosta(os, sanaKohdalla);
        }
    }
    
    
    
    private void tulosta(PrintStream os, Sana sana) {
        os.println("---------------------------");
        sana.tulosta(os);
        os.println("---------------------------");
        List<Relaatio> loydetyt = sanakirja.annaRekisterit(sana);
        for (Relaatio relaatio  : loydetyt) {
            int rid = relaatio.getRid();
            Rekisteri rekisteri = sanakirja.getRekisteri(rid);
            rekisteri.tulosta(os);
        }
 
    }

    /**
     * @param sanakirja sanakirja jota k‰sitell‰‰n
     */
    public void setSanakirja(Sanakirja sanakirja) {
       this.sanakirja = sanakirja;
       naytaSana();
    }

}
