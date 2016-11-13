package ar.com.EmprenDevs.hackaton.Accelone.service;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.Socket;



import ar.com.EmprenDevs.hackaton.Accelone.Servlets.HttpDownloadUtility;

public class SessionSocketsOut {
	private static final int BUFFER_SIZE = 4096;
	public String saveDir = "D:/hackaton/workspace/ExtractorModelo/src/Files";
	// puede ser que le pase la ruta del prroyectono mas
	public String fileName = "";
	
	Socket salida;
	int puerto= 80;
	String ip = "10.10.11.118";
	//BufferedReader File,sendMessage;
	PrintStream response;
	private String rutaImagen;
	
//	http://10.10.11.118/pupila-server/myphoto.jpg
	
	
	public SessionSocketsOut() {
		super();
	}


	public void IniciandoEntrada() throws InterruptedException, IOException {
		
		try {
			salida =new Socket(ip,puerto);
			//appEntrada.setSoTimeout();
			System.out.println("se abrio la session para el puerto : " + puerto + 
					"El ip : " +ip);
			
			//File = new BufferedReader(new InputStreamReader(appEntrada.getInputStream()));
			System.out.println("sacando datos");
//			
//			InputStream inputStream = salida.getInputStream();
//			String saveFilePath = saveDir + File.separator + fileName;
//			System.out.println("La ruta del arichivo es:  " +saveFilePath);
//			fileName = saveDir.substring(saveFilePath.lastIndexOf("/") + 1,
//					saveDir.length());
//			System.out.println("El nombre del archivo es:  " +fileName);
			
			
//
//			ObjectOutputStream out= new ObjectOutputStream(salida.getOutputStream());
//			
//			FileInputStream File = new FileInputStream("src/Files/ima.png");
//			
//			byte []  buf = new byte[4096];
//			
//			while (true) {
//				int len = File.read(buf);
//				if(len==-1 ) break;
//				out.write(buf,0,len);
//			}
//			
			
			// opens an output stream to save into file
//			FileOutputStream outputStream = new FileOutputStream(saveFilePath);
//		
//			int bytesRead = -1;
//			byte[] buffer = new byte[BUFFER_SIZE];
//			while ((bytesRead = inputStream.read(buffer)) != -1) {
//				outputStream.write(buffer, 0, bytesRead);
//			}
//			outputStream.close();
//			inputStream.close();
			
			
			
			/** Este es para mandar alerta de recibido. mno se usara por ahora.
			 sendMessage = new BufferedReader(new InputStreamReader(mensage));
			 response = new PrintStream(appEntrada.getOutputStream());
			**/
			
			
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("error puerto ocupado: " +e);
			response.close();
			//File.close();
			salida.close(); // no hay que cerrar las en estee metodo.. 
			System.out.println("se cerro todos los puertos abiertos.");
			//e.printStackTrace();
		}catch(ConnectException n){
			System.out.println("error :" +n);
		
	}catch(IOException i){
			System.out.println("no responde : " +i);
			
		}
	}
	
	public void cerrandoSockets (){
		
	
		 try {
			response.close();
			//File.close();
			salida.close(); // no hay que cerrar las en estee metodo.. 
			System.out.println("se cerro todos los puertos abiertos.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//			e.getCause();
			System.out.println("errores:  "+e);
			
		} 
		 
	}
	
	public String rutaImagen(String ruta){
	String rutaDir = "D:/hackaton/workspace/ExtractorModelo/src/Files/";
	   this.rutaImagen=rutaDir.concat(ruta);
		return this.rutaImagen;
	}
	
}
