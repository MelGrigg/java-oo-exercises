package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class ContrastFilter implements Filter {
	
	int scale = 4;
	
	private int adjust(int comp, int val) {
		if (val < comp) {
			return (val - (val / scale)) < 0 ? 0 : (val - (val / scale));
		}
		return (val + (val / scale)) > 255 ? 255 : (val + (val / scale));
	}

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
				int r = this.adjust(avg, c.getRed());
				int g = this.adjust(avg, c.getGreen());
				int b = this.adjust(avg, c.getBlue());
				processed.set(column, row, new Color(r, g, b));
			}
		}
		
		return processed;
		
	}
	
}
