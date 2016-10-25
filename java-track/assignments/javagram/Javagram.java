package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Javagram {

	public static void main(String[] args) {

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath;
		Picture picture = null;
		Scanner in = new Scanner(System.in);
		
		// prompt user for image to filter and validate input
		
		String originalName = "";
		
		do {
			
			String imagePath = "path not set";
			
			// try to open the file
			try {
				
				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();
				originalName = relPath;
				
				/*
				String[] relPathParts = relPath.split(File.separator);
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));
				*/
				imagePath = dir + "\\" + relPath;
				
				picture = new Picture(imagePath);
				
			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		
		Picture processed = picture;
		boolean doFilter = true;
		while (doFilter) {
			int select = displayFilterMenu(in);
			
			Filter filter = null;
			do {
				try {
					filter = getFilter(select);
				} catch (RuntimeException e) {
					System.out.println("Invalid selection.");
				}
			} while (filter == null);
	
			// filter and display image
			processed = filter.process(processed);
			processed.show();
			
			System.out.println("Image successfully filtered");
			
			String selection = "";
			do {
				System.out.println("Apply another filter?  y/n");
				selection = in.next();
			} while (!((selection.equals("y")) || (selection.equals("n"))));
			if (selection.equals("n"))
				doFilter = false;
		}
		
		// save image, if desired
		String fileName = "";
		
		System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
		
		fileName = in.next();

		boolean cont = false;
		if (fileName.equals("exit")) {
			System.out.println("Image not saved");
		} else if (fileName.equals(originalName)) {
			String selection = "";
			do {
				System.out.println("Save under same name?  y/n");
				selection = in.next();
			} while (!((selection.equals("y")) || (selection.equals("n"))));
			if (selection.equals("y"))
				cont = true;
		} else {
			cont = true;
		}
		
		if (cont) {
			String absFileName = dir + File.separator + fileName;
			processed.save(absFileName);
			System.out.println("Image saved to " + absFileName);
		}
		
		// close input scanner
		in.close();
	}
	
	private static int displayFilterMenu(Scanner in) {
		int select = 0;
		do {
			System.out.println("Please select a filter:");
			System.out.println("1 - Blue");
			System.out.println("2 - Invert");
			System.out.println("3 - Brightness");
			System.out.println("4 - Grayscale");
			System.out.println("5 - Random");
			System.out.println("6 - Contrast");
			System.out.println("7 - Black and White");
			System.out.println("8 - Blur");
			System.out.println("9 - Rotate Clockwise");
			System.out.println("10 - Rotate Counterclockwise");
			System.out.println("11 - Flip Horizontally");
			System.out.println("12 - Flip Vertically");
			if (in.hasNextInt())
				select = in.nextInt();
			else
				System.out.println("Invalid selection.");
		} while (select == 0);
		return select;
	}
	
	private static Filter getFilter(int select) {
		switch (select) {
		case 1:
			return new BlueFilter();
		case 2:
			return new InvertFilter();
		case 3:
			return new BrightnessFilter();
		case 4:
			return new GrayscaleFilter();
		case 5:
			return new RandomFilter();
		case 6:
			return new ContrastFilter();
		case 7:
			return new BlackAndWhiteFilter();
		case 8:
			return new BlurFilter();
		case 9:
			return new RotateClockwiseFilter();
		case 10:
			return new RotateCounterclockwiseFilter();
		case 11:
			return new FlipHorizontallyFilter();
		case 12:
			return new FlipVerticallyFilter();
		default:
			throw new RuntimeException();
		}
	}

}