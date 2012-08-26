/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.io.FileOutputStream;

/**
 * This class represents a PPM image file otherwise known as a portable pixel map this file type is a colour
 * image contains a header and the data
 * @author adeptues
 */
public class PPMFile {

    private String header;
    private String fileName;
    private int height;
    private int width;
    private int maxVal;
    private byte [][][] pixmap;

    /**
     * Default constructor does nothing
     */
    public PPMFile(){

    }

    /**
     * Creates a PPM colour file which is one of the most simple colour file
     * formats available. It contains two parts a header containing file
     * information and then the actual pixel data. The header is created based on
     * the information supplied to the constructor.
     * @param fileName The name of the file to be written.
     * @param height the height of the file to be written in pixels.
     * @param width the width of the file to be written in pixels.
     * @param maxVal the maximum colour value to hold in the files default
     * should be 255.
     */
    public PPMFile(String fileName, int height, int width, int maxVal) {
        this.fileName = fileName;
        this.height = height;
        this.width = width;
        this.maxVal = maxVal;
        this.header = "P6\n"+this.width+" "+this.height+"\n"+this.maxVal+"\n";
        this.pixmap = new byte [width][height][3];
    }

    /**
     * sets a pixel in the ppm file defined by (x,y) co-ordinate to the
     * associated reg, green and blue values.
     * @param x The x location of the pixel
     * @param y The y location of the pixel
     * @param r The red value to set
     * @param g The green value to set
     * @param b the blue value to set
     * @return
     */
    public boolean setPixel(int x, int y, int r, int g, int b){
        if((x >= 0) && (x < width) && (y >= 0) && (y < height)){
            pixmap[x][y][0] = (byte)r;
            pixmap[x][y][1] = (byte)g;
            pixmap[x][y][2] = (byte)b;
            return true;
        }
        return false;
    }

    /**
     * Writes the ppm file from the data in the class
     */
    public void write(){
        try{
            FileOutputStream out = new FileOutputStream(fileName);
            byte [] buffer = this.header.getBytes();
            out.write(buffer);
            for(int x = 0; x < width; x++){
                for(int y = 0; y < height; y++){
                    out.write(pixmap[x][y][0]);
                    out.write(pixmap[x][y][1]);
                    out.write(pixmap[x][y][2]);
                }
            }
            out.flush();
            out.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    



}
