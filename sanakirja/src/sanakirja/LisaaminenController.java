package sanakirja;
import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;


/**
 * Luokka, joka lis‰‰ sanoja
 * @author Marketa
 * @version 14 Jun 2017
 *
 */
public class LisaaminenController implements ModalControllerInterface<String> {
    
    
	    @FXML private SplitPane lisaaminenAlue;

	    @FXML private void handleCancel() {
	    	ModalController.closeStage(lisaaminenAlue);
	    }

	    @FXML private void handleLisaa() {
	    	Dialogs.showMessageDialog("Lis‰tty, mutta ei viel‰ toimi");
	    	ModalController.closeStage(lisaaminenAlue);
	    }

	    /**
	     * N‰yttp‰‰ lisp‰‰misen ikkunan
	     * @param lisaaminen lis‰tty sana
	     */
		public static void lisaa(String lisaaminen) {
			ModalController.showModeless(LisaaminenController.class.getResource("MuokkaaminenView.fxml"),
                    "Uusi sana", lisaaminen);	
		}

		@Override
		public String getResult() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void handleShown() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setDefault(String arg0) {
			// TODO Auto-generated method stub
			
		}
}
