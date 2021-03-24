package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	AlienDictionary a = new AlienDictionary();
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInsert;

    @FXML
    private Button btnTraslate;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button btnClear;

    @FXML
    void doClear(ActionEvent event) {
    	a.reset();
    	txtArea.clear();
    	txtInsert.clear();
    }

    @FXML
    void doTraslate(ActionEvent event) {
    	
    	String testo = txtInsert.getText();
    	String[] parole;
    	parole = testo.split(" ");
    	
    	if(parole.length == 1 && controlloCaratteri(parole[0])==true) {
    		//ricerca
    		parole[0] = parole[0].toUpperCase();
    		
    		if(a.translate(parole[0])!=null)
    			txtArea.setText(a.translate(parole[0]));
    		else {
    			txtArea.setText("Parola non presente nel dizionario");
    		}
    	}
    	else if(parole.length==2 && controlloCaratteri(parole[0])==true && controlloCaratteri(parole[1])==true) {
    		//inserimento
    		
    		parole[0] = parole[0].toUpperCase();
    		parole[1] = parole[1].toUpperCase();

    		
    		a.addWord(parole[0], parole[1]);
    		txtArea.setText("Parola inserita");
    		txtInsert.clear();
    		
    	}
    	else {
    		txtArea.setText("ERRORE! Inserisci le parole correttamente. Ricorda che puoi mettere solo carattero numerici");
    	}
    }
    
    public boolean controlloCaratteri(String s) {
    	
    	if(s.matches("((?=.*\\d).{1,200})")==true) {
    		return false;
    	}
    	else 
    		return true;
    }

    @FXML
    void initialize() {
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTraslate != null : "fx:id=\"btnTraslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
