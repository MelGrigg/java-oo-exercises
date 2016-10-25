package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class GrayscaleFilter implements Filter {
	
	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
		
		for (int column = 0; column < processed.width(); column++) {
			for (int row = 0; row < processed.height(); row++) {
				Color c = original.get(column, row);
				
				int g = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
				
				processed.set(column, row, new Color(g, g, g));
			}
		}
		
		return processed;
		
	}

}
