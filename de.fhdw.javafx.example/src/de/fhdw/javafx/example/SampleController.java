package de.fhdw.javafx.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SampleController {

    @FXML
    private Button x3;

    @FXML
    private Button x4;

    @FXML
    private Button x5;

    @FXML
    private Button x6;

    @FXML
    private Label x8;

    @FXML
    private Button x7;

    @FXML
    private TextField x1;

    @FXML
    private TextField x2;

    @FXML
    void hanldleButtonAction(ActionEvent event) {
    	double v1;
    	double v2;

    	v1 = Double.parseDouble(x1.getText());
    	v2 = Double.parseDouble(x2.getText());

    	double erg = 0;

    	if (event.getSource().equals(x3)){
    		erg = v1 - v2;

    	}

    	else if (event.getSource().equals(x4)){
    		erg = v1 + v2;

    	}


    	else if (event.getSource().equals(x5)){
    		erg = v1 / v2;

    	}

    	else if (event.getSource().equals(x6)){
    		erg = v1 * v2;

    	}

    	else if (event.getSource().equals(x7)){
    		x1.clear();
    		x2.clear();
    		x1.requestFocus();
    	}

    	x8.setText(String.valueOf(erg));
    }

}