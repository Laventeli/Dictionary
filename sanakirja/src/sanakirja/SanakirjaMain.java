package sanakirja;
	
import javafx.application.Application;
import javafx.application.Platform;
//import javafx.application.Platform;
import javafx.stage.Stage;
import sanakirjaM.Sanakirja;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * P��ohjelma Sanakirja ohjelman k�ynnist�minen
 * @author Marketa
 * @version 31 May 2017
 *
 */
public class SanakirjaMain extends Application {
	@Override
	public void start(Stage primaryStage) {
	    try {
	        final FXMLLoader ldr = new FXMLLoader(getClass().getResource("SanakirjaGUIView.fxml")); // korjaa tiedostonimi
	        final Pane root = (Pane)ldr.load();
	        final SanakirjaGUIController sanakirjaCtrl = (SanakirjaGUIController)ldr.getController(); // korjaa nimet
	        
	        final Scene scene = new Scene(root);
	        scene.getStylesheets().add(getClass().getResource("sanakirja.css").toExternalForm()); // korjaa tiedostonimi
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Sanakirja"); // korjaa title
	        
	        // Platform.setImplicitExit(false); // jos t�m�n laittaa, pit�� itse sulkea
	        
	        Sanakirja sanakirja = new Sanakirja();
	        sanakirjaCtrl.setSanakirja(sanakirja);
	        
	        primaryStage.setOnCloseRequest((event) -> {
	            // Kutsutaan voikoSulkea-metodia
	            if ( !sanakirjaCtrl.voikoSulkea() ) event.consume(); // korjaa nimi 
	            
	        });
	        
	        primaryStage.show();
	        /*
	        Application.Parameters params = getParameters();
	        if (params.getRaw().size() > 0)
	            sanakirjaCtrl.lueTiedosto(params.getRaw().get(0));
	        else
	            if (!sanakirjaCtrl.avaa()) Platform.exit();
	        */
	    } catch(Exception e) {
	        e.printStackTrace();
	        System.err.println(e.getMessage());
	    }
	}
	
	/**
	 * K�ynnistp�� k�ytt�liittym�n
	 * @param args Ei k�yt�ss� komentorivin parametrit
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
