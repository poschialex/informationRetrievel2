
enum valueType {
	RGB, YCaCb
}

public class ColorValues {

	private int red;
	private int green;
	private int blue;
	
	private float y;
	private float cb;
	private float ca;
	
	public ColorValues(int colorType1, int colorType2, int colorType3, valueType colorSpace) {
		
		switch(colorSpace) {
			case RGB:
				this.red = colorType1;
				this.green = colorType2;
				this.blue = colorType3;
				break;
				
			case YCaCb:
				this.y = colorType1;
				this.cb = colorType2;
				this.ca = colorType3;
		}
		
		this.convertToYCbCa();
	}
	
	public ColorValues() {
	}
	
	
	public double getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public double getCb() {
		return cb;
	}

	public void setCb(float cb) {
		this.cb = cb;
	}

	public double getCa() {
		return ca;
	}

	public void setCa(float ca) {
		this.ca = ca;
	}
	
	public int getRed() {
		return red;
	}
	public void setRed(int red) {
		this.red = red;
	}
	public int getGreen() {
		return green;
	}
	public void setGreen(int green) {
		this.green = green;
	}
	public int getBlue() {
		return blue;
	}
	public void setBlue(int blue) {
		this.blue = blue;
	}
	
	public void convertToYCbCa() {
		this.y = (float) ((0.299 * this.red) + (0.587 * this.green) + ( 0.114 * this.blue));
		this.cb = (float) (128 - (0.168736 * this.red) - (0.331264 * this.green) + ( 0.5 * this.blue));
		this.ca = (float) (128 + (0.5 * this.red) - (0.418688 * this.green) - ( 0.081312 * this.blue));
	}
}
