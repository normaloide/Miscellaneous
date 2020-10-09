/**
* @author Edoardo Ferrari
* @version 1.0
*/

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.*;

public class AverageColour {

	/**
	* This method will find the average RGB value for the image given
	*
	* @param img     BufferedImage
	* @param w       int
	* @param h       int
	* @return array  int[]
	*/

	public static int[] average(BufferedImage img, int w, int h) {
		int r = 0;
		int g = 0;
		int b = 0;
		int pixels = w * h;
		Color color;

		// for every pixel, the program will get the RGB values summing them
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				color = new Color(img.getRGB(i, j));
				r += color.getRed();
				g += color.getGreen();
				b += color.getBlue();
			}
		}

		// dividing the RGB values for the number of pixels examined
		r /= pixels;
		g /= pixels;
		b /= pixels;

		// creating an array with the average values and returning it
		int[] array = new int[]{r, g, b};

		return array;
	}
	
	/**
	* The main method will get an image.png from the same folder of the
	* AverageColour.java, gets informations and print the average colour
	*/

	public static void main(String[] args) {
		String name = args[0];
		BufferedImage img = null;

		// throws IOException if the image is not found
		try {
			img = ImageIO.read(new File(name));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Image not found");
		}

		// gets width and height of image.png
		int w = img.getWidth();
		int h = img.getHeight();
		System.out.println(Arrays.toString(average(img, w, h)));
	}
}
