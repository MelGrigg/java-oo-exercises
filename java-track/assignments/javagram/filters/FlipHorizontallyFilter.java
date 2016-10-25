package javagram.filters;

import javagram.Picture;

public class FlipHorizontallyFilter implements Filter {
	
	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
		
		for (int column = 0; column < processed.width(); column++) {
			for (int row = 0; row < processed.height(); row++) {
				int newCol = (processed.width() - 1) - column;
				processed.set(column, row, original.get(newCol, row));
			}
		}
		
		return processed;
		
	}

}
