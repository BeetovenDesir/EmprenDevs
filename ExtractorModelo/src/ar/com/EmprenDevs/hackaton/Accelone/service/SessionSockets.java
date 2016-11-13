package ar.com.EmprenDevs.hackaton.Accelone.service;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A sockets port services
 * @author Beetoven Desir
 *
 */
public class SessionSockets {

	 public ServerSocket server;
	 public Socket socket;
	 int puerto = 80;
	 String ip = "10.10.11.118";
	 DataOutputStream dataOut;
	 BufferedReader dataInt;
	 
	 public void inicializando() throws InterruptedException{
		
		 try {
			//server = new ServerSocket(ip,puerto);
			socket = new Socket(ip,puerto);
			socket = server.accept();
			System.out.println("aceptado");
			

			ObjectOutputStream out= new ObjectOutputStream(socket.getOutputStream());
			
			FileInputStream File = new FileInputStream("src/Files/ima.png");
			
			byte []  buf = new byte[4096];
			
			while (true) {
				int len = File.read(buf);
				if(len==-1 ) break;
				out.write(buf,0,len);
			}
			
			socket.setSoTimeout(450);;
			System.out.println("cerrando la session");
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Occurio un error no pudo cargar los datos");
		}
		 
	 }
	 
}
