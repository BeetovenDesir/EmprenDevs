package ar.com.EmprenDevs.hackaton.Accelone.Servlets;

import java.io.IOException;

public class HttpDownloader {

	public static void main(String[] args) {
		String fileURL = "http://10.10.11.118/pupila-server/myphoto.jpg";
		String saveDir = "D:/hackaton/workspace/ExtractorModelo/src/Files";
		
		try {
			HttpDownloadUtility.descargar(fileURL, saveDir);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}