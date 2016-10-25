package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class BlurFilter implements Filter {
	
	int a = 0;
	int b = 6;
	int c = 2;
	int[][] positions = {
			{  0,  0, a },
			{  0,  1, b },
			{ -1,  0, b },
			{  1,  0, b },
			{  0, -1, b },
			{ -1,  1, b },
			{  1,  1, b },
			{ -1, -1, b },
			{  1, -1, b },
			{ -1,  2, c },
			{  0,  2, c },
			{  1,  2, c },
			{ -2,  1, c },
			{ -2,  0, c },
			{ -2, -1, c },
			{  2,  1, c },
			{  2,  0, c },
			{  2, -1, c },
			{ -1, -2, c },
			{  0, -2, c },
			{  1, -2, c }
	};
	
	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
		
		for (int column = 0; column < processed.width(); column++) {
			for (int row = 0; row < processed.height(); row++) {
				int rSum = 0;
				int gSum = 0;
				int bSum = 0;
				int valSum = 0;
				for (int i = 0; i < positions.length; i++) {
					Color c = null;
					try {
						c = original.get(column + (positions[i][0]), row + (positions[i][1]));
					} catch (IndexOutOfBoundsException e) {
						continue;
					}
					rSum += (c.getRed() * positions[i][2]);
					gSum += (c.getGreen() * positions[i][2]);
					bSum += (c.getBlue() * positions[i][2]);
					valSum += positions[i][2];
				}
				int r = (int)Math.round(rSum / (double)valSum);
				int g = (int)Math.round(gSum / (double)valSum);
				int b = (int)Math.round(bSum / (double)valSum);
				processed.set(column, row, new Color(r, g, b));
			}
		}
		
		return processed;
		
	}

}
