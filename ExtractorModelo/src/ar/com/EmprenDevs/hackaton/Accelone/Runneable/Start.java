package ar.com.EmprenDevs.hackaton.Accelone.Runneable;

/**
 * 
 * @beetoven.desir
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;

import ar.com.EmprenDevs.hackaton.Accelone.Servlets.HttpDownloadUtility;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" I ");
		System.out.println("Inicando la session la conexion");
		
		String fileURL = "http://10.10.11.118/pupila-server/myphoto.jpg";
		String saveDir = "D:/hackaton/workspace/ExtractorModelo/src/Files";
		
		try {
			HttpDownloadUtility.descargar(fileURL, saveDir);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println(" INICIANDO CLASIFICACION DE IMAGE ");
		System.out.println("======================================================================");	
		System.out.println("                                                                      ");
		System.out.println(" CONECTANDO A WATSON :::::::::::::::::::::::::::::::::::::::::::::::::::");
		VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
		service.setApiKey("1d9c4021ed5c0f186fc2e0707db3448b71e76d6d");
		System.out.println("EN PROCESO ");
		 System.out.println("----------------------------------------------------------------------");
		    ClassifyImagesOptions options =
		        new ClassifyImagesOptions.Builder().images(new File("src/Files/ima.png")).build();
		    VisualClassification result = service.classify(options).execute();
		    System.out.println(result);
		    
		    System.out.println("-----------------------------------------------------------------------");
		    System.out.println("                                                                      ");
		    System.out.println("=======================================================================");
		    options = new ClassifyImagesOptions.Builder().images(new File("src/Files/perro.jpg"))
		        .classifierIds("gatos").build();
		    result = service.classify(options).execute();
		    System.out.println("SE CLASIFICO COMO UN:  ");
		    System.out.println(result);
		    System.out.println("  ------------------------------------------------------------   ");
		    System.out.println(" SE TERMINO LA CLASIFICACION ");
		    
		    	
	
		//ServerSocket server = null;
		 Socket socket;
		 int puerto = 80;
		 String ip = "10.10.11.118";
		 
		 try {
			//server = new ServerSocket(ip,puerto);
			socket = new Socket(ip,puerto);
			System.out.println("aceptado");
			
			System.out.println(" ========================================================  ");
			ObjectOutputStream out= new ObjectOutputStream(socket.getOutputStream());
			
			FileInputStream File = new FileInputStream("src/Files/ima.png");
			System.out.println("                                                                      ");
			byte []  buf = new byte[4096];
			
			while (true) {
				int len = File.read(buf);
				if(len==-1 ) break;
				out.write(buf,0,len);
			}
			System.out.println(" SE MANDO LA IMAGEN ========================================================= ");
			System.out.println("                                                                      ");
			socket.setSoTimeout(450);;
			System.out.println("cerrando la session");
			socket.close();
			File.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Occurio un error no pudo cargar los datos");
		}
		
	}
	
	
}
