/**
 * 
 */
package unitTests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import transforms.HoughTransform;
import utils.PPMFile;

/**
 * @author adeptues
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("g.jpg"));
		    HoughTransform hough = new HoughTransform(img.getWidth(), img.getHeight());
		    hough.doHough(img);
		    PPMFile ppm = hough.houghSpaceToPPMImage(0);
		    ppm.write();
		} catch (IOException e) {
		}

	}

}
