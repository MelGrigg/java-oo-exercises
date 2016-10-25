package javagram.filters;

import javagram.Picture;

public class FlipVerticallyFilter implements Filter {
	
	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
		
		for (int column = 0; column < processed.width(); column++) {
			for (int row = 0; row < processed.height(); row++) {
				int newRow = (processed.height() - 1) - row;
				processed.set(column, row, original.get(column, newRow));
			}
		}
		
		return processed;
		
	}

}
