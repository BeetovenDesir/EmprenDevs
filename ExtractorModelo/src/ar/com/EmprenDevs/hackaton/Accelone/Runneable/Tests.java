package ar.com.EmprenDevs.hackaton.Accelone.Runneable;

import java.io.File;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier;

public class Tests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Ininiciando la conexion a watson...");
		VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
		service.setApiKey("1d9c4021ed5c0f186fc2e0707db3448b71e76d6d");
		System.out.println(" ==============================================================");
		System.out.println("Se conecto Correctamente a Watson ");
		System.out.println(" ===============================================================");
		System.out.println(" Entrenando  a Watson ");
	    ClassifierOptions createOptions = new ClassifierOptions.Builder().classifierName("Animals")
	        .addClass("Perro", new File("src/preubaDos/perro.zip"))
	        .addClass("Gatos", new File("src/preubaDos/gato.zip"))
	        .negativeExamples(new File("src/preubaDos/example.zip")).build();
		System.out.println(" Transaccion Existosa :::::::::::::::::::::::::::::");
	    VisualClassifier Animals = service.createClassifier(createOptions).execute();
	    System.out.println(Animals);
		System.out.println(" FIN::::::::::::::::::::::::::::::::::::::::::::::::::: ");
		
		
	}

}
