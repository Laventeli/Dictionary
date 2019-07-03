package sanakirja;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * Luokka, joka hoitaa tulostuksen
 * @author Marketa
 * @version 9 Jun 2017
 *
 */
public class TulostusController implements ModalControllerInterface<String> {
          @FXML TextArea tulostusAlue;
          
          @FXML private void handleOK() {
              ModalController.closeStage(tulostusAlue);
         }
      
          
          @FXML private void handleTulosta() {
              Dialogs.showMessageDialog("Ei osata viel‰ tulostaa");
          }
     
          
          @Override
          public String getResult() {
              return null;
          } 
      
          
          @Override
          public void setDefault(String oletus) {
              if ( oletus == null ) return;
             tulostusAlue.setText(oletus);
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
           * @param tulostus tulostettava teskti
          */
          public static void tulosta(String tulostus) {
              ModalController.showModeless(TulostusController.class.getResource("TulostusView.fxml"),
                      "Tulostus", tulostus);
         }
}