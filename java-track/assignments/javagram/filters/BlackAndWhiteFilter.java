package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class BlackAndWhiteFilter implements Filter {
	
	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
		
		int sum = 0;
		
		for (int column = 0; column < processed.width(); column++) {
			int temp = 0;
			for (int row = 0; row < processed.height(); row++) {
				Color c = original.get(column, row);
				temp += (c.getRed() + c.getGreen() + c.getBlue()) / 3;
			}
			temp /= processed.width();
			sum += temp;
		}
		
		int avg = sum / processed.height();
		
		for (int column = 0; column < processed.width(); column++) {
			for (int row = 0; row < processed.height(); row++) {
				Color c = original.get(column, row);
				int rgbSum = c.getRed() + c.getGreen() + c.getBlue();
				int val = ((rgbSum / 3) > avg) ? 255 : 0;
				processed.set(column, row, new Color(val, val, val));
			}
		}
		
		return processed;
		
	}

}
