package de.fhdw.javafx.example;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RestData {
	private String info;
	private Double a;
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}


}
