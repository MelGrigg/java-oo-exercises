package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class RandomFilter implements Filter {
	
	private int randomRGB() {
		return (int)(Math.random() * 255);
	}
	
	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
		
		for (int column = 0; column < processed.width(); column++) {
			for (int row = 0; row < processed.height(); row++) {
				processed.set(column, row, new Color(this.randomRGB(), this.randomRGB(), this.randomRGB()));
			}
		}
		
		return processed;
		
	}

}
