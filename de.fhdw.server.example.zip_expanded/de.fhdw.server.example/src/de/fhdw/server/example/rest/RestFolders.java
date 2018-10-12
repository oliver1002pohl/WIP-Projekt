package de.fhdw.server.example.rest;

import java.io.File;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RestFolders {
	private File[] folders;

	public File[] getFolders() {
		return folders;
	}

	public void setFolders(File[] folders) {
		this.folders = folders;
	}

}
