package de.fhdw.javafx.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    void hanldleButtonAction(ActionEvent event) throws IOException {
    	double v1;
    	double v2;

    	v1 = Double.parseDouble(x1.getText());
    	v2 = Double.parseDouble(x2.getText());

    	double erg = 0;

    	if (event.getSource().equals(x3)){
    		erg = v1 - v2;

    	}

    	else if (event.getSource().equals(x4)){
    		//erg = v1 + v2;
    		erg = calc(v1,v2);
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

public double calc (double v1, double v2) throws ParseException, IOException{

	HttpClient client = HttpClients.createDefault();
	HttpGet get  =  new HttpGet(String.format("http://localhost:9998/rest/plus/%s/%s",v1,v2));
	HttpResponse response = client.execute(get);
	if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
		String json = EntityUtils.toString(response.getEntity());
		Gson gson = new GsonBuilder().create();
		RestData restData =  gson.fromJson(json, RestData.class);
		return restData.getA();
	}
	return 0;
}

}