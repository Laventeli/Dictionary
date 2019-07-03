package sanakirja;

//import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
//import javafx.scene.control.TextArea;

import javafx.scene.layout.Pane;

/**
 * Luokka, joka hoitaa tulostuksen
 * @author Marketa
 * @version 9 Jun 2017
 *
 */
public class SanakirjanNimiController implements ModalControllerInterface<String> {
          @FXML Pane AlkkuikkunaAlue;
          
          @FXML private void handleOK() {
              ModalController.closeStage(AlkkuikkunaAlue);
         }
      
          
          @FXML private void handleLopeta() {
        	  ModalController.closeStage(AlkkuikkunaAlue);
          }
     
          
          @Override
          public String getResult() {
              return null;
          } 
      
          
          @Override
          public void setDefault(String oletus) {
              if ( oletus == null ) return;
          }
          
          /**
           * Mit‰ tehdp‰‰n kun dialogi on n‰ytetty
           */
          @Override
          public void handleShown() {
              //
          }
          
          /**
           * N‰yttp‰‰ tulostusalueessa tekstin
           * @param alkuikkuna alku
          */
          public static void avaa(String alkuikkuna) {
              ModalController.showModeless(SanakirjanNimiController.class.getResource("AlkuikkunaView.fxml"),
                      "Alku", alkuikkuna);
         }
}