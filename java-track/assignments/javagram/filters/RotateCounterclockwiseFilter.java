package javagram.filters;

import javagram.Picture;

public class RotateCounterclockwiseFilter implements Filter {
	
	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.height(), original.width());
		
		for (int column = 0; column < processed.width(); column++) {
			for (int row = 0; row < processed.height(); row++) {
				int newCol = (original.width() - 1) - row;
				int newRow = column;
				processed.set(column, row, original.get(newCol, newRow));
			}
		}
		
		return processed;
		
	}

}
