/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Dizionario diz = new Dizionario();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtRis"
    private TextArea txtRis; // Value injected by FXMLLoader

    @FXML
    void clear(ActionEvent event) {
    	txtRis.clear();
    }

    @FXML
    void translate(ActionEvent event) {
    	
    	String[] parole = txtParola.getText().split(" ");
    	
    	if(parole.length == 1)
    	{
    		txtRis.setText(diz.translate(parole[0]).toString());
    		
    	}
    	if(parole.length == 2)
    	{
    		diz.add(parole[0], parole[1]);
    	}

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRis != null : "fx:id=\"txtRis\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
