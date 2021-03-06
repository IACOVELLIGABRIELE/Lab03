/**
 * Sample Skeleton for 'SpellChecker.fxml' Controller Class
 */

package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SpellCheckerController {
	
	Dictionary model = new Dictionary();
	

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="choiceBox"
    private ComboBox<String> choiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="txtTesto"
    private TextField txtTesto; // Value injected by FXMLLoader

    @FXML // fx:id="btnSpeelCheck"
    private Button btnSpeelCheck; // Value injected by FXMLLoader

    @FXML // fx:id="txtError"
    private TextArea txtError; // Value injected by FXMLLoader

    @FXML // fx:id="labError"
    private Label labError; // Value injected by FXMLLoader

    @FXML // fx:id="btnClearText"
    private Button btnClearText; // Value injected by FXMLLoader

    @FXML // fx:id="labTime"
    private Label labTime; // Value injected by FXMLLoader
    
   // choiceBox.add("English")
    //choiceBox.add("Italian");                 aggiungere stringhe al choice box

    @FXML
    void doClearText(ActionEvent event) {
    	
    	labTime.setText("");
    	labError.setText("");
    	txtError.clear();
    	txtTesto.clear();
    	

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	labTime.setText("");
    	labError.setText("");
    	
    	int errori = 0;
    	
    	String linguaggio = choiceBox.getValue();
    	LinkedList<String> testoTemp = new LinkedList<String>();
    	
    	String testo = txtTesto.getText();
    	testo.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]]\\\"", "");
    	
    	System.out.println("sono prima del for");
    	
    	for(String c : testo.split(" ")) {
    		testoTemp.add(c.toLowerCase());
    	}
    	
    	
    	model.loadDictionary(linguaggio);
    
    	
    	for(RichWord a : model.spellCheckText(testoTemp) ) {
    		System.out.println("dentro secondo for");
    		if(a.isCorretto() == false) {
    			System.out.println("dentro if del secondo for");
    			txtError.appendText(a.getParola()+"\n");
    			errori++;
    		}
    	}

    	String z = "Tempo di esecuzione "+System.nanoTime()+" s";
    	labTime.setText(z);
    	labError.setText("Sono stati riscontrati "+errori+" errori");
        //txtTesto.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpeelCheck != null : "fx:id=\"btnSpeelCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtError != null : "fx:id=\"txtError\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert labError != null : "fx:id=\"labError\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert labTime != null : "fx:id=\"labTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        choiceBox.setValue("English");
        choiceBox.setItems(FXCollections.observableArrayList("English","Italian"));
    }
}

