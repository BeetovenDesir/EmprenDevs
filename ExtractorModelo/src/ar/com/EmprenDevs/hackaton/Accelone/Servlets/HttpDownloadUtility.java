package ar.com.EmprenDevs.hackaton.Accelone.Servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * A utility that downloads a file from a URL.
 * @author Beetoven Desir
 *
 */
public class HttpDownloadUtility {
	private static final int BUFFER_SIZE = 4096;

	/**
	 * Downloads a file from a URL
	 * @param fileURL HTTP URL of the file to be downloaded
	 * @param saveDir path of the directory to save the file
	 * @throws IOException
	 */
	public static void descargar(String archivoURL, String saveDir)
			throws IOException {
		URL url = new URL(archivoURL);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		int responseCode = httpConn.getResponseCode();

		// always check HTTP response code first
		if (responseCode == HttpURLConnection.HTTP_OK) {
			String fileName = "";
			String disposition = httpConn.getHeaderField("Disposition");
			String contentType = httpConn.getContentType();
			long    fecha     =  httpConn.getDate();
			int contentLength = httpConn.getContentLength();

			if (disposition != null) {
				// extracts file name from header field
				int index = disposition.indexOf("filename=");
				if (index > 0) {
					fileName = disposition.substring(index + 10,
							disposition.length() - 1);
				}
			} else {
				// extracts file name from URL
				fileName = archivoURL.substring(archivoURL.lastIndexOf("/") + 1,
						archivoURL.length());
			}
			System.out.println(" LOS DATOS DE LA IMAGEN RECIBIDA  ");
			System.out.println(" =======================================================================   ");
			System.out.println("Tipo de contenido : " + contentType);
			System.out.println("                                                                      ");
			System.out.println("La disposicion de los datos : " + disposition);
			System.out.println("                                                                      ");
			System.out.println("la longitud : " + contentLength);
			System.out.println("                                                                      ");
			System.out.println("El nombre :" + fileName);
			System.out.println("                                                                      ");
			System.out.println("Fecha :" + fecha);
			System.out.println(" =======================================================================    ");

			// opens input stream from the HTTP connection
			InputStream inputStream = httpConn.getInputStream();
			String saveFilePath = saveDir + File.separator + fileName;
			
			// opens an output stream to save into file
			FileOutputStream outputStream = new FileOutputStream(saveFilePath);
			
			int bytesRead = -1;
			byte[] buffer = new byte[BUFFER_SIZE];
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			outputStream.close();
			inputStream.close();

			System.out.println("File downloaded : " +outputStream.getFD());
		} else {
			System.out.println("No file to download. Server replied HTTP code: " + responseCode);
		}
		httpConn.disconnect();
	}
}