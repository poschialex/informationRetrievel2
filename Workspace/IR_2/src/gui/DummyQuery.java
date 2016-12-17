package gui;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javax.swing.JOptionPane;

public class DummyQuery implements QueryInterface {
	
	/*initialize query with path to query object and correct frame, run query here
	 * and give list of result images as paths to displayResults() function*/
	@Override
	public void runQuery(String path, ScrollPane pane) {
		if(checkPath(path)){
			File queryObject = new File(path);
			//TODO run query on queryobject, call displayResults() with correct list
			
			// for now: the following dummyData
			List<String> list = new LinkedList<String>();
			list.add("src\\gui\\dummyData\\arabell.jpg");
			list.add("src\\gui\\dummyData\\feodor.jpg");
			list.add("src\\gui\\dummyData\\viluw.jpg");
			list.add("src\\gui\\dummyData\\polli.jpg");
			list.add("src\\gui\\dummyData\\rapunzel.jpg");
			list.add("src\\gui\\dummyData\\bobby.jpg");
			list.add("src\\gui\\dummyData\\krokus.jpg");
			list.add("src\\gui\\dummyData\\apple.jpg");
			
			displayResults(pane, list);
		}
		else{
			//no invalid paths, show error instead
			JOptionPane.showMessageDialog(null, "Entered path is invalid, please choose another.");
		}
	}
	
	//check if path entered in textfield is valid
	@Override
	public boolean checkPath(String path) {
		File file = new File(path);
		return file.exists();
	}

	//display results in gridpane, needs list of result images as paths and correct pane
	@Override
	public void displayResults(ScrollPane pane, List<String> paths) {
		GridPane grid = new GridPane();
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(0, 0, 0, 0));
	    
	    int x = 0, y = 0;

		for(int i = 0; i < paths.size(); i++){
			if ((i % 5 == 0) && (i != 0)){
				x = 0;
				y++;
			}
			File file = new File(paths.get(i));		
			Image image = new Image(file.toURI().toString());
			ImageView iv = new ImageView();
			iv.setImage(image);
			iv.setFitWidth(100);
			iv.setPreserveRatio(true);
			
			grid.add(iv, x, y);
			x++;
		}
		pane.setContent(grid);
	}

}
