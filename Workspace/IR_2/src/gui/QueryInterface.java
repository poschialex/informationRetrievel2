package gui;

import java.util.List;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public interface QueryInterface {
	public void runQuery(String Path, ScrollPane pane);
	public boolean checkPath(String path);
	public void displayResults(ScrollPane pane, List<String> paths);
}
