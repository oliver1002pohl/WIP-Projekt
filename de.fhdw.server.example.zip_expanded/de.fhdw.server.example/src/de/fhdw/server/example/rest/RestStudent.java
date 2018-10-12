package de.fhdw.server.example.rest;


import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RestStudent {
	private ArrayList<String> RestStudents = new ArrayList<String>();

	public ArrayList<String> getRestStudents() {
		return RestStudents;
	}

	public void setRestStudents(ArrayList<String> Studentslist) {
		this.RestStudents = Studentslist;
	}

}