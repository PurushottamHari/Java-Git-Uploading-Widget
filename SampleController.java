package application;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class SampleController {

	
    @FXML
    public AnchorPane rootPane;
	
 
    
    @FXML
    void commitOnGit() throws IOException {
    	
    	Runtime rt = Runtime.getRuntime();
    	rt.exec("C:\\Users\\PURUSHOTTAM\\AppData\\Local\\GitHubDesktop\\GitHubDesktop.exe");

    }

    @FXML
    void copyPasteFile() {

		try {
		//Reading from fileCount
		FileReader fr = null;
		fr = new FileReader("D:\\Purushottam\\GitStuff\\Coding\\Coding-Questions-\\CodeCount.txt");
		
	    BufferedReader br=new BufferedReader(fr);    
	    int newF = -1;
	    
	    //Initializing filecount
			newF = Integer.parseInt(br.readLine());
			newF++;			
			FileWriter fw = new FileWriter("D:\\\\Purushottam\\\\GitStuff\\\\Coding\\\\Coding-Questions-\\\\CodeCount.txt");
			fw.write(Integer.toString(newF));
	
		
	 
	   System.out.println(newF);   
	   String newFileName = "Code_"+Integer.toString(newF)+".txt";
	   String path = "D://Purushottam//GitStuff//Coding//Coding-Questions-//"+newFileName;
	   System.out.println(path);
	   File newFile = new File(path);
	    
	   //Create the new File!
	  
		newFile.createNewFile();
		System.out.println("Created!");
	
	   
	   Desktop desk = Desktop.getDesktop();
	   //Open the file
	   
		desk.open(newFile);
		
		
		br.close();
		fr.close();
		fw.close();
		
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
		}
	 
	
    }
    
    public void exit() {
    	
    	System.exit(0);
    }

}
