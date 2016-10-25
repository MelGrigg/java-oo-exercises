package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class InvertFilter implements Filter {
	
	private int invertRGBVal(int orig) {
		return 255 - orig;
	}
	
	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
		
		for (int column = 0; column < processed.width(); column++) {
			for (int row = 0; row < processed.height(); row++) {
				Color c = original.get(column, row);
				
				int r = this.invertRGBVal(c.getRed());
				int g = this.invertRGBVal(c.getGreen());
				int b = this.invertRGBVal(c.getBlue());
				
				processed.set(column, row, new Color(r, g, b));
			}
		}
		
		return processed;
		
	}

}
