package ar.com.EmprenDevs.hackaton.Accelone.Runneable;

import java.io.File;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;

public class TesterWatson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
		service.setApiKey("1d9c4021ed5c0f186fc2e0707db3448b71e76d6d");
		
		 System.out.println("Classify an image");
		    ClassifyImagesOptions options =
		        new ClassifyImagesOptions.Builder().images(new File("src/Files/ima.png")).build();
		    VisualClassification result = service.classify(options).execute();
		    System.out.println(result);
		    
		    System.out.println("Classify using the 'Car' classifier");
		    options = new ClassifyImagesOptions.Builder().images(new File("src/Files/perro.jpg"))
		        .classifierIds("gatos").build();
		    result = service.classify(options).execute();
		    System.out.println(result);
		   
		
	}

}
