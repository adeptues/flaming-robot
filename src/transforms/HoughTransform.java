/**
 *
 */
package transforms;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import utils.PPMFile;

/**
 * This class is the hough transform which detects lines in images by projecting
 * them into Hough space using histograms
 *
 * @author adeptues
 *
 */
public class HoughTransform {

    /**
     * This Hough space is the accumulator for the histogram bins and should be
     * cleared before the start of the run
     */
    private int houghSpace[][];
    private int x;
    private int y;
    private int maxRho;
    private int maxTheta;

    public HoughTransform(int x, int y) {
        this.x = x;
        this.y = y;
        int[] limits = findLimits();
        maxTheta = limits[0];
        maxRho = limits[1];
        houghSpace = new int[maxTheta][maxRho];//maybe need to swap these around
        clearBins();
    }

    public void printHoughSpace(String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printstream = new PrintWriter(bufferedWriter);
        
        for (int i = 0; i < maxTheta; i++) {
            for (int j = 0; j < maxRho; j++) {
                int result = houghSpace[i][j];
                 
                if (result > 0) {
                   // System.out.println(j+","+i+","+result);//format is rho,theta,result
                    //out.write(j+","+i+","+result+"\n");
                    String outstr = j + "," + i + "," + result;
                    printstream.println(outstr);
                }
            }
        }
        printstream.close();
    }

    /**
     * Clears the histogram of data by setting all of the bins to 0
     */
    private void clearBins() {
        for (int i = 0; i < maxTheta; i++) {
            for (int j = 0; j < maxRho; j++) {
                houghSpace[i][j] = 0;
            }
        }
    }

    /**
     * Finds the limits for maxRho and maxTheta by using pythagoras theorum to
     * find the maximum rho value of hough space
     */
    public int[] findLimits() {
        int theta = 180;
        int rho = (int) Math.rint(Math.sqrt(((x * x) + (y * y))));
        int max = rho + rho;
        int[] out = {theta, max};
        return out;
    }

    /**
     * computes the hough transform for an array of pixels which must be size
     * w*h where w is width and h is height. pixels should be in form rgb
     *
     * @param pixels
     */
    public void doHough(BufferedImage data) {
        //unsigned int x = 0;
        //unsigned int y = 0;
        // int i;
        int rho = 0;
        int max = 0;
        int min = 0;
        //const byte * pixel = data + width * y * 3 + 3 * x;

        for (int height = 0; height < y; height++) {//for each pixel
            for (int width = 0; width < x; width++ /*
                     * pixel += 3
                     */) {
                //  const byte blue = pixel[0], green = pixel[1], red = pixel[2];
                //int rgb = data.getRGB(width, height);
                Color colour = new Color(data.getRGB(width, height));
                int r = colour.getRed();
                int b = colour.getBlue();
                int g = colour.getGreen();
                if ((r == 255) && (b == 255) && (g == 255)) {//check pixel if white
                    for (int i = 0; i < maxTheta; i++) {//loop for theta 0 to 180
                        //double rad = i;
                        double rad = Math.toRadians(i);
                        //pixel_count++;
                        rho = (int) ((width * Math.cos(rad)) + (height * Math.sin(rad))); //calc rho
                        //positve + negative values of rho
                        if (rho > 0) {//TODO modify for 0 rho
                            //take rho from 499
                            int iy = 499 - rho;
                            //int index = calculate_index(i, iy, maxTheta);
                            //hough_array[index] = hough_array[index] + 1;
                            houghSpace[i][iy] = houghSpace[i][iy] + 1;

                        }
                        if (rho < 0) {
                            int temp = Math.abs(rho); //convert to positve
                            int iy2 = 499 + temp;
                            //int index = calculate_index(i, iy2, maxTheta);
                            //hough_array[index] = hough_array[index] + 1;
                            houghSpace[i][iy2] = houghSpace[i][iy2] + 1;
                        }
                    }
                }
            }
        }

    }

    /**
     * Converts the abstract hough space to a PPM file
     */
    public PPMFile houghSpaceToPPMImage(int threshold) {
        //hough_image = (unsigned char *) malloc(sizeof (unsigned char) *maxRho * maxTheta * 3);
        PPMFile houghImage = new PPMFile("houghspace.ppm", maxRho, maxTheta, 255);
        //set each pixel to black
        int x, y;
        for (y = 0; y < maxRho; y++) {
            for (x = 0; x < maxTheta; x++) {
                //draws for axis rho theta
                //int index = calculate_index(x, y, maxTheta);

                int result = houghSpace[x][y];
                if (result > 0) {
                    System.out.println("rho " + y + ", theta: " + x + " has" + result);
                }

                char luma = (char) (result * 0.3 + result * 0.59 + result * 0.11);
                if (result > threshold) {

                    if (luma < 255) {
                        //increase by 50%
                        luma = (char) (luma * 3); // may cause errors later
                    }
                    //set_pixel(hough_image, y, x, maxRho, maxTheta, luma, luma, luma);
                    houghImage.setPixel(x, y, luma, luma, luma);
                } else {
                    //set pixel black
                    //set_pixel(hough_image, y, x, maxRho, maxTheta, 0, 0, 0);
                    houghImage.setPixel(x, y, 0, 0, 0);
                }

            }
        }
        return houghImage;
    }

    /**
     * analyises hough space so it can draw lines back onto the original image
     * to show where they where detected
     *
     * @return
     */
    public BufferedImage drawLines(BufferedImage original) {
        return null;
    }
}
