package sanakirja;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
/**
 * Luokka, joka hoitaa sanan muokkaamisen
 * @author Marketa
 * @version 14 Jun 2017
 *
 */
public class MuokkaaminenController implements ModalControllerInterface<String> {
		
		@FXML private SplitPane muokkaaminenAlue;

	    @FXML private void handleCancel() {
	    	ModalController.closeStage(muokkaaminenAlue);
	    }

		@FXML private void handleMuokattu() {
			Dialogs.showMessageDialog("Ei viel‰ toimi");
			ModalController.closeStage(muokkaaminenAlue);
	    }
         
		/**
		 * N‰yttp‰‰ muokkaamiesen ikkunan
		 * @param muokkaaminen muokattu teksti
		 */
		public static void muokkaa(String muokkaaminen) {
             ModalController.showModeless(MuokkaaminenController.class.getResource("MuokkaaminenView.fxml"),
                     "Muokkaaminen", muokkaaminen);
        }


		@Override
		public void handleShown() {
			// TODO Auto-generated method stub
		}


		@Override
		public String getResult() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setDefault(String arg0) {
			// TODO Auto-generated method stub
	
		}
}
