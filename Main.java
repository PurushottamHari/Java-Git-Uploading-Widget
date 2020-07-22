package application;
	
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;


public class Main extends Application {
	
	private double xOffset;
	private double yOffset;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.initStyle(StageStyle.UTILITY);
			primaryStage.setOpacity(0);
			primaryStage.show();
			
			
			Stage secStage = new Stage();
			secStage.initStyle(StageStyle.UNDECORATED);
			secStage.initOwner(primaryStage);
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,370,200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			secStage.setScene(scene);
			secStage.initStyle(StageStyle.UNDECORATED);
			secStage.show();
			
			//Set Position
			Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
			secStage.setX(visualBounds.getMaxX() - 40 - scene.getWidth());
			secStage.setY(visualBounds.getMinY() +30 );
			
		
			
			//Drag and Drop
			scene.setOnMousePressed(event->{
				
				xOffset = secStage.getX() - event.getScreenX();
				yOffset = secStage.getY() - event.getScreenY();
			});
			
			scene.setOnMouseDragged(event->{
				secStage.setX(event.getScreenX()+xOffset);
				secStage.setY(event.getScreenY()+yOffset);				
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}


   
}
