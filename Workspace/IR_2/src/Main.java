import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("/Users/heinerludwig/Documents/Studium/Information Retrieval/Seminar/Arbeit/2. Aufgabe/Workspace/test.jpg"));
		} catch (IOException e) {
			System.out.println(e);
		}
		
		ImagePartitioner partitioner = new ImagePartitioner();
		ZickZackReader reader = new ZickZackReader();
		CosinusTransformator transformer = new CosinusTransformator();
		
		partitioner.setImage(img);
		
		transformer.setBlockColorMatrix(partitioner.getColorMatrix());
		
		// the integer and list names are the same as in the slides inside the XML-code on slide 8
		reader.setMatrix(transformer.getValue(colorValue.Y));
		Integer YDCCoeff = reader.getDCValue();
		List<Integer> YACCoeff5 = reader.get5ACValues();
		
		reader.setMatrix(transformer.getValue(colorValue.Cb));
		Integer CbDCCoeff = reader.getDCValue();
		List<Integer> CbACCoeff2 = reader.get2ACValues();
		
		reader.setMatrix(transformer.getValue(colorValue.Cr));
		Integer CrDCCoeff = reader.getDCValue();
		List<Integer> CrACCoeff2 = reader.get2ACValues();
		
	}

}