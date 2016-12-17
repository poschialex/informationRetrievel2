package gui;

import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class DummyBrowsing implements BrowsingInterface{
	//browse for files, return results to set for textfield
	@Override
	public String browse(String path) {
		JDialog dialog = new JDialog();
		JFileChooser chooser = new JFileChooser();

		if (path.equals(""))
			//TODO change to right directory
			chooser.setCurrentDirectory(new File("C:\\"));
		else{
			if(checkPath(path))
				chooser.setCurrentDirectory(new File(path));
			else{
				JOptionPane.showMessageDialog(null, "Entered path is invalid, returning to main directory.");
				chooser.setCurrentDirectory(new File("C:\\"));
			}
		}	
    	if (chooser.showOpenDialog(dialog) == JFileChooser.APPROVE_OPTION) {    		
        		return chooser.getSelectedFile().getPath();
        }
    	return path;
	}
	
	//check if current path in textfield is valid
	@Override
	public boolean checkPath(String path){
		File file = new File(path);
		return file.exists();
	}
}
