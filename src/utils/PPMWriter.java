/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.io.FileOutputStream;

/**
 *
 * @author adeptues
 */
public class PPMWriter {

	@Deprecated
    public static void writePPM(byte pixmap[][][], int width, int height){
        try{
            FileOutputStream out = new FileOutputStream("colour.ppm");
            String header = "P6\n"+width+" "+height+"\n255\n";
            byte [] buffer = header.getBytes();
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
