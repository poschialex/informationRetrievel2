package gui;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
	private Stage stage;
	private Pane searchLayout;
	
	@Override
    public void start(Stage stage) {
        this.stage = stage;
        this.stage.setTitle("Image Search");
        
        initLayout();
    }
	
	private void initLayout(){
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("layout.fxml"));
            searchLayout = (Pane) loader.load();

            Scene scene = new Scene(searchLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
    	TextField path = (TextField) stage.getScene().lookup("#path");
		Button browse = (Button) stage.getScene().lookup("#browse");

		browse.setOnAction(new EventHandler<ActionEvent>() {
	            @Override 
	            public void handle(ActionEvent e) {
	            	path.setText((new DummyBrowsing()).browse(path.getText()));	            		
	            }
	        });
		
		ScrollPane resultPane = (ScrollPane) stage.getScene().lookup("#results");
		ImageView iv = (ImageView) stage.getScene().lookup("#queryobject");
		
		Button search = (Button) stage.getScene().lookup("#search");
		search.setOnAction(new EventHandler<ActionEvent>() {
	            @Override 
	            public void handle(ActionEvent e) {
	                (new DummyQuery()).runQuery(path.getText(), resultPane);
	            	File file = new File(path.getText());
	            	if (file.exists()){
	            		Image image = new Image(file.toURI().toString());
	            		iv.setImage(image);
	            	}
	            	
	            }
	        });
	}
	
    public static void main(String[] args) {
        launch(args);
    }
}
