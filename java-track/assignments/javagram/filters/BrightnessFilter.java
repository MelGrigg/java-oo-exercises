package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class BrightnessFilter implements Filter {
	
	private int addBrightness(int orig) {
		return (orig + 50 > 255) ? 255 : orig + 50;
	}
	
	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
		
		for (int column = 0; column < processed.width(); column++) {
			for (int row = 0; row < processed.height(); row++) {
				Color c = original.get(column, row);
				
				int r = this.addBrightness(c.getRed());
				int g = this.addBrightness(c.getGreen());
				int b = this.addBrightness(c.getBlue());
				
				processed.set(column, row, new Color(r, g, b));
			}
		}
		
		return processed;
		
	}

}
